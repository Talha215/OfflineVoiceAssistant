import java.util.ArrayList;

public class repeat extends commandClass {
    ArrayList<String> commandPhrases = new ArrayList<>();

    public repeat() {
        commandPhrases.add("repeat");
    }

    @Override
    public boolean match(String token) {
        return commandPhrases.contains(token);
    }

    @Override
    public String run(String[] command) {
        return String.join(" ", command);
    }
}
