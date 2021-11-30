import java.util.ArrayList;

public class date extends commandClass implements commandInterface {
    ArrayList<String> commandPhrases = new ArrayList<String>();

    public date() {
        commandPhrases.add("read");
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

        try {
            FileReader reader = new FileReader(filename + ".txt");
            for(k=(i+1); k<input.length; k++){
                int i;
                while ((i = fr.read()) != -1)
                    String output = ((char)i);
            }
            reader.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return output;
    }
}
