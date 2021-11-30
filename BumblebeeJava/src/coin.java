import java.util.ArrayList;

public class coin extends commandClass implements commandInterface {
    ArrayList<String> commandPhrases = new ArrayList<String>();

    public coin() {
        commandPhrases.add("coin");
    }

    public boolean match(String word){
        return commandPhrases.contains(word);
    }

    public String run(String[] input){
        String result;
        int rand = (int)Math.floor(Math.random()*(2-1+1)+1);
        switch (rand) {
            case 1:  result = "heads";
                break;
            case 2:  joke = "tails";
                break;
        }
        return result;
    }
}