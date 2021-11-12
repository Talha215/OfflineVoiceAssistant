import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class note extends commandClass implements commandInterface {
    ArrayList<String> commandPhrases = new ArrayList<String>();

    public note() {
        commandPhrases.add("note");
    }

    public boolean match(String word){
        return commandPhrases.contains(word);
    }

    public String run(String[] input){
        String fileName = "";
        int i, j, k, l=0;
        for(i=0; i<input.size(); i++){
            if(input.get(i).equals("note")){
                l = i;
                break;
            }
        }
        for(j=0; j<l; j++){
            if(j == i-1)
                fileName = fileName.concat(input.get(j));
            else
                fileName = fileName.concat(input.get(j) + " ");
        }
        FileWriter writer = new FileWriter(fileName + ".txt");
        for(k=(i+1); k<input.size(); k++){
            writer.write(input.get(k) + " ");
        }
        writer.close();
    }
}
