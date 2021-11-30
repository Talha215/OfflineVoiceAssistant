import java.util.ArrayList;

public class syntax extends commandClass implements commandInterface {
    ArrayList<String> commandPhrases = new ArrayList<String>();

    public date() {
        commandPhrases.add("syntax");
    }

    public boolean match(String word){
        return commandPhrases.contains(word);
    }

    public String run(String[] input){

        for(int i=0; i<input.length; i++) {
            if (input[i].equals("about")) {
                return ("for the about command, please say the word about " +
                        "followed by the command you would like to learn about");
                }
            if (input[i].equals("calculator")) {
                return ("to use the calculator, simply say any numbers with an operation between them, such as " +
                        "twenty two minus eighteen");
            }
            if (input[i].equals("calculator")) {
                return ("to perform a coin toss, say flip a coin or do a coin toss");
            }
            if (input[i].equals("date")) {
                return ("to get the current date, you can say what is the date today or simply say date alone");
            }
            if (input[i].equals("delete")) {
                return ("to delete a file, say delete followed by the file name, void of the dot t x t");
            }
            if (input[i].equals("google")) {
                return ("to use the google feature, say google followed by the exact phrase you would like" +
                        "entered to the google search bar");
            }
            if (input[i].equals("joke")) {
                return ("to hear a joke, just say tell me a joke");
            }
            if (input[i].equals("list")) {
                return ("for the list command, say what you would like the file being created to be named, followed" +
                        "by the word list, followed by the elements you would like in your list without any mention" +
                        "of deliminators");
            }
            if (input[i].equals("note")) {
                return ("for the note command, say what you would like the file being created to be named, followed" +
                        "by the word note, followed by the phrase you would like in your note without any mention" +
                        "of deliminators");
            }
            if (input[i].equals("read")) {
                return ("to read a created file, say read followed by the file name, void of the dot t x t");
            }
            if (input[i].equals("syntax")) {
                return ("to get the syntax of a command, say syntax followed by any command phrase " +
                        "configured into the machine");
            }
            if (input[i].equals("time")) {
                return ("to get the current time, you can say what is the time right now or simply say time alone," +
                        "and to get the time in a different time zone, your command simply needs the word time" +
                        "and the name of the timezone");
            }
            if (input[i].equals("weather")) {
                return ("to get the current weather, you can say what is the weather right now or simply " +
                        "say weather alone");
            }
            }
        }
        return null;
    }
}