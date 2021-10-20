

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
 * An audio player that utilizes a single thread
 * 
 * @author Ian Zichko-Geithner
 *
 */
public class AudioPlayer extends Thread {

	//MaryTTS settings taken from a tutorial
	public static final int	MONO = 0;
	public static final int	STEREO = 3;
	public static final int	LEFT_ONLY = 1;
	public static final int	RIGHT_ONLY = 2;
	private AudioInputStream inStream;
	private LineListener listener;
	private SourceDataLine sourceLine;
	private int outputMode;
	private Status status = Status.WAITING;
	private boolean	exitRequested = false;
	private float gain = 1.0f;

	/**
	 * Reports status of the audio thread
	 *
	 */
	public enum Status {
		WAITING,
		PLAYING;
	}

	/**
	 * AudioPlayer can be used if setAudio() is used
	 *
	 */
	public AudioPlayer() {
	}

	/**
	 * @param file
	 * @throws IOException
	 * @throws UnsupportedAudioFileException
	 */
	public AudioPlayer(File file) throws IOException, UnsupportedAudioFileException {
		this.inStream = AudioSystem.getAudioInputStream(file);
	}

	/**
	 * @param inStream
	 */
	public AudioPlayer(AudioInputStream inStream) {
		this.inStream = inStream;
	}

	/**
	 * @param file
	 * @param listener
	 * @throws IOException
	 * @throws UnsupportedAudioFileException
	 */
	public AudioPlayer(File file, LineListener listener) throws IOException, UnsupportedAudioFileException {
		this.inStream = AudioSystem.getAudioInputStream(file);
		this.listener = listener;
	}

	/**
	 * @param inStream
	 * @param listener
	 */
	public AudioPlayer(AudioInputStream inStream, LineListener listener) {
		this.inStream = inStream;
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
		this.inStream = AudioSystem.getAudioInputStream(file);
		this.sourceLine = line;
		this.listener = listener;
	}

	/**
	 * @param inStream
	 * @param line
	 * @param listener
	 */
	public AudioPlayer(AudioInputStream inStream, SourceDataLine line, LineListener listener) {
		this.inStream = inStream;
		this.sourceLine = line;
		this.listener = listener;
	}

	/**
	 * 
	 * @param file
	 * @param line
	 * @param listener
	 * @param mode
	 * MONO has mono output 
	 * STEREO has stereo output
	 * LEFT_ONLY has mono output on left channel
	 * RIGHT_ONLY has mono output on the right channel
	 * @throws IOException
	 * @throws UnsupportedAudioFileException
	 */
	public AudioPlayer(File file, SourceDataLine line, LineListener listener, int mode)
			throws IOException, UnsupportedAudioFileException {
		this.inStream = AudioSystem.getAudioInputStream(file);
		this.sourceLine = line;
		this.listener = listener;
		this.outputMode = mode;
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
		this.inStream = inStream;
		this.sourceLine = line;
		this.listener = listener;
		this.outputMode = mode;
	}

	/**
	 * @param audio
	 */
	public void setAudio(AudioInputStream audio) {
		if (status == Status.PLAYING) {
			throw new IllegalStateException("Audio already playing");
		}
		this.inStream = audio;
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
		AudioFormat audioFormat = inStream.getFormat();
		if (audioFormat.getChannels() == 1) {
			if (outputMode != 0) {
				inStream = new StereoAudioInputStream(inStream, outputMode);
				audioFormat = inStream.getFormat();
			}
		} else {
			assert audioFormat.getChannels() == 2 : "Unexpected number of channels: " + audioFormat.getChannels();
			if (outputMode == 0) {
				inStream = new MonoAudioInputStream(inStream);
			} else if (outputMode == 1 || outputMode == 2) {
				inStream = new StereoAudioInputStream(inStream, outputMode);
			} else {
				assert outputMode == 3 : "Unexpected output mode: " + outputMode;
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

					inStream = AudioSystem.getAudioInputStream(targetFormat, inStream);
					audioFormat = inStream.getFormat();
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
				nRead = inStream.read(abData, 0, abData.length);
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