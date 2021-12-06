import java.util.ArrayList;
import java.util.Arrays;

public class about extends commandClass implements commandInterface {
    ArrayList<String> commandPhrases = new ArrayList<String>();

    public about() {
        commandPhrases.add("about");
    }

    public boolean match(String word){
        return commandPhrases.contains(word);
    }

    public String run(String[] input){
		int j = 0;

        for(j=0; j<input.length; j++){
            if(input[j].equals("about")){
                break;
            }
        }

		for(int i=j+1; i<input.length; i++) {
            if (Arrays.asList(input).contains("calculator")) {
                return ("the calculator can perform basic sequential operations between decimal numbers");
            }
            if (Arrays.asList(input).contains("coin")) {
                return ("performs a coin toss");
            }
            if (Arrays.asList(input).contains("date")) {
                return ("the date command can get the current date");
            }
            if (Arrays.asList(input).contains("delete")) {
                return ("the delete command can remove an existing note or list, or any text file in the " +
                        "designated path");
            }
            if (Arrays.asList(input).contains("joke")) {
                return ("the joke command will tell you a random, preset joke");
            }
            if (Arrays.asList(input).contains("list")) {
                return ("the list command generates a named text file with a list of all mentioned elements");
            }
            if (Arrays.asList(input).contains("note")) {
                return ("the note command generates a named text file with any mentioned phrase");
            }
            if (Arrays.asList(input).contains("read")) {
                return ("the read command can read the contents of a created note or list file, or any" +
                        "text file in the designated path on your machine");
            }
            if (Arrays.asList(input).contains("search")) {
            	return ("the search command allows you to perform a search via the internet and returns the top result");
            }
            if (Arrays.asList(input).contains("syntax")) {
                return ("the syntax command returns the required syntax for any command");
            }
            if (Arrays.asList(input).contains("time")) {
                return ("the time command can be used to get the current local time, or the the current time" +
                        "in any time zone");
            }
            if (Arrays.asList(input).contains("weather")) {
                return ("the weather command returns the weather in a city you ask for");
            }
            else{
            	return ("i am your personal voice assistant designed to work primarily offline");
            }
        }
        return "Failed to complete command";
    }
}
