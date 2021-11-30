import java.util.ArrayList;

public class about extends commandClass implements commandInterface {
    ArrayList<String> commandPhrases = new ArrayList<String>();

    public about() {
        commandPhrases.add("syntax");
    }

    public boolean match(String word){
        return commandPhrases.contains(word);
    }

    public String run(String[] input){

        for(int i=0; i<input.length; i++) {
            if (input[i].equals("about")) {
                return ("the about command gives a brief description of a configured command");
            }
            if (input[i].equals("calculator")) {
                return ("the calculator can perform basic sequential operations between decimal numbers");
            }
            if (input[i].equals("coin")) {
                return ("performs a coin toss");
            }
            if (input[i].equals("date")) {
                return ("the date command can get the current date");
            }
            if (input[i].equals("delete")) {
                return ("the delete command can remove an existing note or list, or any text file in the " +
                        "designated path");
            }
            if (input[i].equals("google")) {
                return ("the google command allows you to perform a google search and returns the top result");
            }
            if (input[i].equals("joke")) {
                return ("the joke command will tell you a random, preset joke");
            }
            if (input[i].equals("list")) {
                return ("the list command generates a named text file with a list of all mentioned elements");
            }
            if (input[i].equals("note")) {
                return ("the note command generates a named text file with any mentioned phrase");
            }
            if (input[i].equals("read")) {
                return ("the read command can read the contents of a created note or list file, or any" +
                        "text file in the designated path on your machine");
            }
            if (input[i].equals("syntax")) {
                return ("the syntax command returns the required syntax for any command");
            }
            if (input[i].equals("time")) {
                return ("the time command can be used to get the current local time, or the the current time" +
                        "in any time zone");
            }
            if (input[i].equals("weather")) {
                return ("the weather command returns the current local weather");
            }
        }
        return null;
    }
}
}