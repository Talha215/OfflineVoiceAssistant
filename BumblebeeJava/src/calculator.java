import java.util.ArrayList;

/**
 * @author No This is Patrick
 *
 */
public class calculator extends commandClass implements commandInterface {
    ArrayList<String> commandPhrases = new ArrayList<>();
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
    }

    @Override
    public boolean match(String token) {
        return commandPhrases.contains(token);
    }

    @Override
    public String run(String[] command) {
        String fullCommand = "";
        for (String s : command) fullCommand += s + " ";
        String intMath = StringToMath.convert(fullCommand);
        String output = calc.calculate(intMath);
        System.out.println(intMath);
        System.out.println(output);
        return output;
    }

}
