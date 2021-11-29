import java.util.ArrayList;

public class test extends commandClass implements commandInterface {
    ArrayList<String> commandPhrases = new ArrayList<String>();

    public test() {
        commandPhrases.add("test");
    }

    @Override
    public boolean match(String token) {
        return commandPhrases.contains(token);
    }

    @Override
    public String run(String[] command) {
        return "SUCCESS";
    }

}
