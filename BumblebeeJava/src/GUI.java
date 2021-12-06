import java.awt.Color;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.JTextArea;

public class GUI {

	private JFrame frame;
	private static JTextArea inputField;
	private static JTextArea outputField;

	/**
	 * Launch the application.
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		while(true) {	
			Scanner input = new Scanner(System.in);
			String output = null;

			do {
				try {
					input = new Scanner(new BufferedReader(new FileReader("test.txt")));
					
					output = "";
					while(input.hasNext()) {
						output += input.nextLine() + '\n';
					}
					input.close();
					File toDelete = new File("test.txt");
					toDelete.delete();
					
					//string manipulation of output	
					output = output.substring(14, output.lastIndexOf('\"'));
					System.out.println("input: " + output);
					
				} catch(FileNotFoundException e ) {
					Thread.sleep(1000);
				}
			} while(output == null);
			
			stateMachine run;
			try {
				run = new stateMachine(output);
				String speech = run.outPut(run.match());
				outputField.setText(speech);
				inputField.setText(output);
				stateMachine.textToSpeech.setVoice("dfki-poppy-hsmm");
				stateMachine.textToSpeech.speak(speech, 1.5f, false, true);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 230, 140));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JLabel lblNewLabel = new JLabel("Input:");
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Output:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 104, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 3, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, 0, SpringLayout.EAST, lblNewLabel_1);
		frame.getContentPane().add(lblNewLabel_1);
		
		JTextArea textArea = new JTextArea();
		springLayout.putConstraint(SpringLayout.WEST, textArea, 6, SpringLayout.EAST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, textArea, -10, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, textArea);
		springLayout.putConstraint(SpringLayout.NORTH, textArea, 11, SpringLayout.NORTH, frame.getContentPane());
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		textArea.setForeground(new Color(255, 255, 255));
		textArea.setBackground(new Color(0, 0, 0));
		frame.getContentPane().add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		springLayout.putConstraint(SpringLayout.SOUTH, textArea, -6, SpringLayout.NORTH, textArea_1);
		textArea_1.setBackground(new Color(0, 0, 0));
		textArea_1.setForeground(new Color(255, 255, 255));
		springLayout.putConstraint(SpringLayout.NORTH, textArea_1, 128, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textArea_1, 6, SpringLayout.EAST, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.SOUTH, textArea_1, -24, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textArea_1, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(textArea_1);
		

	}
}