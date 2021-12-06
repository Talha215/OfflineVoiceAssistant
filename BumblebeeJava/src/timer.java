import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class timer extends commandClass implements commandInterface {
	ArrayList<String> commandPhrases = new ArrayList<String>();
	StringToMath stringToMath = new StringToMath();
	static TextToSpeech timerTextToSpeech = new TextToSpeech();
	calc calc = new calc();
	Timer timer;

	public timer() {
		commandPhrases.add("timer");
	}

	@Override
	public boolean match(String token) {
		return commandPhrases.contains(token);
	}

	@Override
	public String run(String[] command) {
		String fullCommand = "";
		String returnTime = "";
		for(int i=0;i<command.length;i++) {
			if(command[i].equals("for")) {
				
			}
			else if(command[i].equals("and")) {
				fullCommand+="plus ";
			}
			else if(command[i].equals("minutes") || command[i].equals("minute")) {
				fullCommand+="times sixty ";
				if(i>=1) {
					returnTime+= command[i-1] + " " + command[i] + " ";
				}
				else {
					returnTime+= command[i-1] + " " + command[i] + " ";
				}
			}
			else if(command[i].equals("hour") || command[i].equals("hours")) {
				if(i>0 && command[i-1].equals("an")) {
					fullCommand+= "one times sixty times sixty";
				}
				else {
					fullCommand+="times sixty times sixty ";
				}
				if(i>=1) {
					returnTime+= command[i-1] + " " + command[i] + " ";
				}
				else {
					returnTime+= command[i-1] + " " + command[i] + " ";
				}
			}
			else if(command[i].equals("seconds") || command[i].equals("second")) {
				fullCommand+=" ";
				if(i>=1) {
					returnTime+= command[i-1] + " " + command[i] + " ";
				}
				else {
					returnTime+= command[i-1] + " " + command[i] + " ";
				}
			}
			else {
				fullCommand+= command[i] + " ";
			}
		}
		String stringNumbers = stringToMath.convert(fullCommand);
		String calcNumbers = calc.calculate(stringNumbers);
		int numbers = Integer.parseInt(calcNumbers);
		stringToMath.clear();
		timer = new Timer();
		timer.schedule(new reminder(), numbers * 1000);

		return "Set a timer for " + returnTime;

	}
	class reminder extends TimerTask {
		public void run() {						
			boolean playCompleted = false;
	        File audioFile = new File("timer.wav");
	        
	        try {
	            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
	 
	            AudioFormat format = audioStream.getFormat();
	 
	            DataLine.Info info = new DataLine.Info(Clip.class, format);
	 
	            Clip audioClip = (Clip) AudioSystem.getLine(info);
	 
	            audioClip.addLineListener(null);
	 
	            audioClip.open(audioStream);
	             
	            audioClip.start();
	             
	            while (!playCompleted) {
	                // wait for the playback completes
	                try {
	                    Thread.sleep(1000);
	                } catch (InterruptedException ex) {
	                    ex.printStackTrace();
	                }
	            }
	            audioClip.close();
	            timerTextToSpeech.setVoice("dfki-poppy-hsmm");
				timerTextToSpeech.speak("Timer Completed", 1.5f, false, true);
				timer.cancel();
	             
	        } catch (UnsupportedAudioFileException ex) {
	            System.out.println("The specified audio file is not supported.");
	            ex.printStackTrace();
	        } catch (LineUnavailableException ex) {
	            System.out.println("Audio line for playing back is unavailable.");
	            ex.printStackTrace();
	        } catch (IOException ex) {
	            System.out.println("Error playing the audio file.");
	            ex.printStackTrace();
	        }
	       
		}
	}
}
