

import java.io.IOException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;

import marytts.LocalMaryInterface;
import marytts.MaryInterface;
import marytts.exceptions.MaryConfigurationException;
import marytts.exceptions.SynthesisException;
import marytts.modules.synthesis.Voice;

/**
 * @author Ian Zichko-Geithner
 *
 */
public class TextToSpeech {

	private AudioPlayer		tts;
	private MaryInterface	marytts;

	/**
	 * Constructor
	 */
	public TextToSpeech() {
		try {
			marytts = new LocalMaryInterface();

		} catch (MaryConfigurationException ex) {
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * Gives full list of possible voices in marytts
	 * Decided not to implement voice selection
	 * @return The available voices for MaryTTS
	 */
	public Collection<Voice> getAvailableVoices() {
		return Voice.getAvailableVoices();
	}

	/**
	 * Sets voice for MaryTTs
	 * @param voice
	 */
	public void setVoice(String voice) {
		marytts.setVoice(voice);
	}

	/**
	 * Main Text to speech method
	 * @param words words meant to be changed to speech
	 * @param daemon True sets TTS to work using daemon thread
	 * 				 False sets TTS to not use a daemon thread
	 * @param join True will force the thread to wait while the current audio finishes
	 */
	public void speak(String words, float gain, boolean daemon, boolean join) {

		stopSpeaking();

		try (AudioInputStream audio = marytts.generateAudio(words)) {

			tts = new AudioPlayer();
			tts.setAudio(audio);
			tts.setGain(gain);
			tts.setDaemon(daemon);
			tts.start();
			if (join)
				tts.join();

		} catch (SynthesisException ex) {
			Logger.getLogger(getClass().getName()).log(Level.WARNING, "Error", ex);
		} catch (IOException ex) {
			Logger.getLogger(getClass().getName()).log(Level.WARNING, "IO Exception", ex);
		} catch (InterruptedException ex) {
			Logger.getLogger(getClass().getName()).log(Level.WARNING, "Interrupted ", ex);
			tts.interrupt();
		}
	}

	/**
	 * Stop speech out put
	 */
	public void stopSpeaking() {
		if (tts != null)
			tts.cancel();
	}

}