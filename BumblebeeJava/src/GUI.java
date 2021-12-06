import java.awt.Color;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.UIManager;

public class GUI {

	private JFrame frame;
	private static JTextField outputField;
	private static JTextField inputField;

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
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 3, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(lblNewLabel);
		
		inputField = new JTextField();
		inputField.setForeground(new Color(255, 255, 255));
		inputField.setBackground(new Color(0, 0, 0));
		springLayout.putConstraint(SpringLayout.NORTH, inputField, 0, SpringLayout.NORTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, inputField, 6, SpringLayout.EAST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, inputField, 77, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, inputField, -10, SpringLayout.EAST, frame.getContentPane());
		inputField.setEditable(false);
		frame.getContentPane().add(inputField);
		inputField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Output:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 112, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_1, 0, SpringLayout.EAST, lblNewLabel);
		frame.getContentPane().add(lblNewLabel_1);
		
		outputField = new JTextField();
		outputField.setForeground(new Color(255, 255, 255));
		outputField.setBackground(new Color(0, 0, 0));
		springLayout.putConstraint(SpringLayout.NORTH, outputField, 0, SpringLayout.NORTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, outputField, 0, SpringLayout.WEST, inputField);
		springLayout.putConstraint(SpringLayout.SOUTH, outputField, 125, SpringLayout.SOUTH, inputField);
		springLayout.putConstraint(SpringLayout.EAST, outputField, -17, SpringLayout.EAST, frame.getContentPane());
		outputField.setEditable(false);
		frame.getContentPane().add(outputField);
		outputField.setColumns(10);
	}

}
