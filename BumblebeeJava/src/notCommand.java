import java.util.ArrayList;
/**
 * @author Talha Qureshi
 *
 */
public class notCommand extends commandClass{
	ArrayList<String> commandPhrases = new ArrayList<String>();
	
	public notCommand() {
	}

	@Override
	public boolean match(String token) {
		return commandPhrases.contains(token);
	}

	@Override
	public String run(String[] command) {
		String temp = String.join(" ", command);
		return temp + " is not a command";	
	}
}
