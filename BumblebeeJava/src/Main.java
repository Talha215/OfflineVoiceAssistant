import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
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
		
		System.out.println("OUTPUT: " + output);
	}
}
