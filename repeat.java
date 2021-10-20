import java.util.ArrayList;

public class repeat extends commandClass{
	public repeat() {
		commandPhrases.add("repeat");
	}

	@Override
	public boolean match(String token) {
		return commandPhrases.contains(token);
	}

	@Override
	public void run(String[] command) {
		output(command);
		
	}

	@Override
	public String output(String[] command) {
		return String.join(" ", command);
	}

}
