import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Ian Zichko-Geithner
 *
 */
public interface commandInterface {
	ArrayList<String> commandPhrases = new ArrayList<String>();
	public boolean match(String token);
	public void run(String[] command);
	public String output(String[] command);

}
