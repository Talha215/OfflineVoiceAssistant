import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**
 * @author Kathleen Snyder
 *
 */
public class list extends commandClass implements commandInterface {
    ArrayList<String> commandPhrases = new ArrayList<String>();

    public list() {
        commandPhrases.add("list");
    }

    public boolean match(String word){
        return commandPhrases.contains(word);
    }

    public String run(String[] input){
        String fileName = "";
        int i, j, k, l=0;
        for(i=0; i<input.length; i++){
            if(input[i].equals("list")){
                l = i;
                break;
            }
        }
        for(j=0; j<l; j++){
            if(j == i-1)
                fileName = fileName.concat(input[j]);
            else
                fileName = fileName.concat(input[j] + " ");
        }
        try {
            FileWriter writer = new FileWriter(fileName + ".txt");
            for(k=(i+1); k<input.length; k++){
                writer.write(input[k] + System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "Made list: " + fileName;
    }
}