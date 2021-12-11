import java.io.File;
import java.util.ArrayList;
/**
 * @author Kathleen Snyder
 *
 */
public class delete extends commandClass implements commandInterface {
    ArrayList<String> commandPhrases = new ArrayList<String>();

    public delete() {
        commandPhrases.add("delete");
    }

    public boolean match(String word){
        return commandPhrases.contains(word);
    }

    public String run(String[] input){
        String fileName = "";
        for(int j=1; j<input.length; j++){
            if(j == input.length-1)
                fileName = fileName.concat(input[j]);
            else
                fileName = fileName.concat(input[j] + " ");
        }
        File file = new File(fileName + ".txt");
        if (file.delete()) {
            return ("successfully deleted " + fileName);
        } else {
            return ("no file called " + fileName + " could be deleted");
    }
}
}