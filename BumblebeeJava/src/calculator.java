import java.util.ArrayList;

/**
 * 
 */

/**
 * @author No This is Patrick
 *
 */
public class calculator extends commandClass implements commandInterface {
	ArrayList<String> commandPhrases = new ArrayList<String>();
	StringToMath converter = new StringToMath();
	calc stack = new calc();
	
	public calculator() {
		commandPhrases.add("plus");
		commandPhrases.add("minus");
		commandPhrases.add("times");
		commandPhrases.add("divide");
		commandPhrases.add("divided");
		commandPhrases.add("multiplied");
		commandPhrases.add("multiply");
		commandPhrases.add("exponent");
		commandPhrases.add("power");
		commandPhrases.add("squared");
	}

	@Override
	public boolean match(String token) {
		return commandPhrases.contains(token);
	}

	@Override
	public String run(String[] command) {
		String fullCommand = "";
		for(int i=0;i<command.length;i++) {
			fullCommand += command[i] + " ";
		}
		String intMath = converter.convert(fullCommand);
		String output = stack.calculate(intMath);
		System.out.println(intMath);
		System.out.println(output);
		converter.clear();
		return output;
	}

}
