

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import marytts.util.data.audio.MonoAudioInputStream;
import marytts.util.data.audio.StereoAudioInputStream;
/**
 * @author Ian Zichko-Geithner
 *
 */
public class AudioPlayer extends Thread {

	//MaryTTS settings
	public static final int	MONO = 0;
	public static final int	RIGHT_ONLY = 2;
	public static final int	LEFT_ONLY = 1;
	public static final int	STEREO = 3;
	
	private float gain = 1.0f;
	private LineListener listener;
	private SourceDataLine sourceLine;
	private int Mode;
	private AudioInputStream Stream;
	private Status status = Status.WAITING;
	private boolean	exitRequested = false;

	/**
	 * AudioPlayer can be used if setAudio() is used
	 *
	 */
	public AudioPlayer() {
	}
	/**
	 * Reports status of the audio thread
	 *
	 */
	public enum Status {
		WAITING,
		PLAYING;
	}

	/**
	 * @param file
	 * @throws IOException
	 * @throws UnsupportedAudioFileException
	 */
	public AudioPlayer(File file) throws IOException, UnsupportedAudioFileException {
		this.Stream = AudioSystem.getAudioInputStream(file);
	}

	/**
	 * @param inStream
	 */
	public AudioPlayer(AudioInputStream inStream) {
		this.Stream = inStream;
	}

	/**
	 * @param file
	 * @param listener
	 * @throws IOException
	 * @throws UnsupportedAudioFileException
	 */
	public AudioPlayer(File file, LineListener listener) throws IOException, UnsupportedAudioFileException {
		this.Stream = AudioSystem.getAudioInputStream(file);
		this.listener = listener;
	}

	/**
	 * @param inStream
	 * @param listener
	 */
	public AudioPlayer(AudioInputStream inStream, LineListener listener) {
		this.Stream = inStream;
		this.listener = listener;
	}

	/**
	 * @param file
	 * @param line
	 * @param listener
	 * @throws IOException
	 * @throws UnsupportedAudioFileException
	 */
	public AudioPlayer(File file, SourceDataLine line, LineListener listener)
			throws IOException, UnsupportedAudioFileException {
		this.Stream = AudioSystem.getAudioInputStream(file);
		this.sourceLine = line;
		this.listener = listener;
	}

	/**
	 * @param inStream
	 * @param line
	 * @param listener
	 */
	public AudioPlayer(AudioInputStream inStream, SourceDataLine line, LineListener listener) {
		this.Stream = inStream;
		this.sourceLine = line;
		this.listener = listener;
	}

	/**
	 * 
	 * @param file
	 * @param line
	 * @param listener
	 * @param mode
	 * @throws IOException
	 * @throws UnsupportedAudioFileException
	 */
	public AudioPlayer(File file, SourceDataLine line, LineListener listener, int mode)
			throws IOException, UnsupportedAudioFileException {
		this.Stream = AudioSystem.getAudioInputStream(file);
		this.sourceLine = line;
		this.listener = listener;
		this.Mode = mode;
	}

	/**
	 * 
	 * @param inStream
	 * @param line
	 * @param listener
	 * @param mode
	 * MONO has mono output 
	 * STEREO has stereo output
	 * LEFT_ONLY has mono output on left channel
	 * RIGHT_ONLY has mono output on the right channel
	 */
	public AudioPlayer(AudioInputStream inStream, SourceDataLine line, LineListener listener, int mode) {
		this.Stream = inStream;
		this.sourceLine = line;
		this.listener = listener;
		this.Mode = mode;
	}

	/**
	 * @param audio
	 */
	public void setAudio(AudioInputStream audio) {
		if (status == Status.PLAYING) {
			throw new IllegalStateException("Audio already playing");
		}
		this.Stream = audio;
	}

	/**
	 * stop the audio thread
	 */
	public void cancel() {
		if (sourceLine != null) {
			sourceLine.stop();
		}
		exitRequested = true;
	}

	/**
	 * @return The SourceDataLine
	 */
	public SourceDataLine getLine() {
		return sourceLine;
	}

	/**
	 * Returns the GainValue
	 */
	public float getGainValue() {
		return gain;
	}

	/**
	 * Sets Gain value.
	 * Line should be opened before calling this method. 
	 * Should be between 0.0 and 1.0. Use a 1/2 Coefficient
	 * @param fGain
	 */
	public void setGain(float gain) {

		gain = gain;

		if (sourceLine != null && sourceLine.isControlSupported(FloatControl.Type.MASTER_GAIN))
			((FloatControl) sourceLine.getControl(FloatControl.Type.MASTER_GAIN))
					.setValue((float) (20 * Math.log10(gain <= 0.0 ? 0.0000 : gain)));
	}

	@Override
	//Run class modeled after marytts tutorial
	public void run() {

		status = Status.PLAYING;
		AudioFormat audioFormat = Stream.getFormat();
		if (audioFormat.getChannels() == 1) {
			if (Mode != 0) {
				Stream = new StereoAudioInputStream(Stream, Mode);
				audioFormat = Stream.getFormat();
			}
		} else {
			assert audioFormat.getChannels() == 2 : "Unexpected number of channels: " + audioFormat.getChannels();
			if (Mode == 0) {
				Stream = new MonoAudioInputStream(Stream);
			} else if (Mode == 1 || Mode == 2) {
				Stream = new StereoAudioInputStream(Stream, Mode);
			} else {
				assert Mode == 3 : "Unexpected output mode: " + Mode;
			}
		}

		DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);

		try {
			if (sourceLine == null) {
				boolean bIsSupportedDirectly = AudioSystem.isLineSupported(info);
				if (!bIsSupportedDirectly) {
					AudioFormat sourceFormat = audioFormat;
					AudioFormat targetFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
							sourceFormat.getSampleRate(), sourceFormat.getSampleSizeInBits(),
							sourceFormat.getChannels(),
							sourceFormat.getChannels() * (sourceFormat.getSampleSizeInBits() / 8),
							sourceFormat.getSampleRate(), sourceFormat.isBigEndian());

					Stream = AudioSystem.getAudioInputStream(targetFormat, Stream);
					audioFormat = Stream.getFormat();
				}
				info = new DataLine.Info(SourceDataLine.class, audioFormat);
				sourceLine = (SourceDataLine) AudioSystem.getLine(info);
			}
			if (listener != null) {
				sourceLine.addLineListener(listener);
			}
			sourceLine.open(audioFormat);
		} catch (Exception ex) {
			Logger.getLogger(getClass().getName()).log(Level.WARNING, null, ex);
			return;
		}

		sourceLine.start();
		setGain(getGainValue());
		int nRead = 0;
		byte[] abData = new byte[65532];
		while ((nRead != -1) && (!exitRequested)) {
			try {
				nRead = Stream.read(abData, 0, abData.length);
			} catch (IOException ex) {
				Logger.getLogger(getClass().getName()).log(Level.WARNING, null, ex);
			}
			if (nRead >= 0) {
				sourceLine.write(abData, 0, nRead);
			}
		}
		if (!exitRequested) {
			sourceLine.drain();
		}
		sourceLine.close();
	}

}