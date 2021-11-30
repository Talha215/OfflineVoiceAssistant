import java.util.ArrayList;

public class delete extends commandClass implements commandInterface {
    ArrayList<String> commandPhrases = new ArrayList<String>();

    public delete() {
        commandPhrases.add("delete");
    }

    public boolean match(String word){
        return commandPhrases.contains(word);
    }

    public String run(String[] input){
        String filename "";
        for(j=1; j<input.length; j++){
            if(j == input.length)
                fileName = fileName.concat(input[j]);
            else
                fileName = fileName.concat(input[j] + " ");
        }
        File file = new File(filename + ".txt");
        if (file.delete()) {
            return ("successfully deleted " + filename);
        } else {
            return ("no file called " + filename + " could be deleted");
    }
}