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

	private AudioPlayer		texttospeech;
	private MaryInterface	mary;

	/**
	 * Constructor
	 */
	public TextToSpeech() {
		try {
			mary = new LocalMaryInterface();

		} catch (MaryConfigurationException ex) {
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * Sets voice for MaryTTs, we used poppy exclusively due to sound quality
	 * of other voices available.
	 * @param voice
	 */
	public void setVoice(String voice) {
		mary.setVoice(voice);
	}

	/**
	 * Gives full list of possible voices in marytts
	 * Decided not to implement voice selection due to time constraint.
	 * @return The available voices for MaryTTS
	 */
	public Collection<Voice> getAvailableVoices() {
		return Voice.getAvailableVoices();
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

		try (AudioInputStream audio = mary.generateAudio(words)) {

			texttospeech = new AudioPlayer();
			texttospeech.setAudio(audio);
			texttospeech.setGain(gain);
			texttospeech.setDaemon(daemon);
			texttospeech.start();
			if (join)
				texttospeech.join();

		} catch (SynthesisException ex) {
			Logger.getLogger(getClass().getName()).log(Level.WARNING, "Error", ex);
		} catch (IOException ex) {
			Logger.getLogger(getClass().getName()).log(Level.WARNING, "IO Exception", ex);
		} catch (InterruptedException ex) {
			Logger.getLogger(getClass().getName()).log(Level.WARNING, "Interrupted ", ex);
			texttospeech.interrupt();
		}
	}

	/**
	 * Stop speech out put if needed
	 */
	public void stopSpeaking() {
		if (texttospeech != null)
			texttospeech.cancel();
	}

}