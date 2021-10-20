
public class test extends commandClass implements commandInterface{
	public test() {
		commandPhrases.add("test");
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
		return "SUCCESS";
	}

}
