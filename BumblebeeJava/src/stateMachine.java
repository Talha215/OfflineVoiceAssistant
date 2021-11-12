import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * @author Ian Zichko-Geithner
 *
 */
public class stateMachine {
	//Data members
	ArrayList<Object> commandClassesList = new ArrayList<Object>();
	ArrayList<commandClass> activeClasses = new ArrayList<commandClass>();
	String[] commandTokens;
	static TextToSpeech textToSpeech = new TextToSpeech();
	
	
	//Constructor - initializes all classes in the commandClasses file.
	stateMachine (String command) throws FileNotFoundException{
		
		//PARSE
		commandTokens = command.split("\\s+");
		
		//loads classes from commmandClasses File
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream("config");
		Scanner scanner = new Scanner(inputStream).useDelimiter(" ");
		//Scanner gets class names from commandClasses file
		while (scanner.hasNextLine()) {
			commandClassesList.add(scanner.nextLine());
		}
		scanner.close();
		
		//Uses commandClassList to initialize all command classes within the config file "commandClasses" by trying the given "name" to search for classes related  to the name and initialize them
		for (int i = 0;i<commandClassesList.size();i++) {
			String name = (String) commandClassesList.get(i);
			try {
				//Creates temp commandCLass, adds it to the activeClass ArrayList for reference during matching.
				commandClass temporaryCommandClass = (commandClass) Class.forName(name).getDeclaredConstructor().newInstance();
				activeClasses.add(temporaryCommandClass);
			
			}catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				System.out.println("Command Class " + name + " not found.");
			}
		}
	}
	
	
	//Finds the int associated with the command class for the key phrase
	public int machineMatch() {
		for(int i=0;i<commandTokens.length;i++) {
			for(int j=0;j<activeClasses.size();j++) {
				if(activeClasses.get(j).match(commandTokens[i])) {
					return j;
				}
			}
		}
		return 0;
	}
	
	
	//Runs the output for the associated command CLass. should be run in final product.
	public String machineOutPut(int j) {
		return activeClasses.get(j).run(commandTokens);
	}

	
	
	public static void main(String[] args) throws InterruptedException {
		Scanner input = null;
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
				
			} catch(FileNotFoundException e ) {
				Thread.sleep(1000);
			}
		} while(output == null);
		
		stateMachine run;
		try {
			run = new stateMachine(output);
			System.out.println(run.machineOutPut(run.machineMatch()));
			stateMachine.textToSpeech.setVoice("dfki-poppy-hsmm");
			stateMachine.textToSpeech.speak(run.machineOutPut(run.machineMatch()), 1.5f, false, true);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
