import java.util.ArrayList;
/**
 * @author Ian Zichko-Geithner
 *
 */
public class repeat extends commandClass{
	ArrayList<String> commandPhrases = new ArrayList<String>();
	
	public repeat() {
		commandPhrases.add("repeat");
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
