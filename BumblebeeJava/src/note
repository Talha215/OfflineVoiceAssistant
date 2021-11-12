import java.io.FileWriter;
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
        for(i=0;i++;i<input.length){
            if(input[i].equals(note)){
                for(j=0;j++;j<i){
                    if(i != j)
                        fileName = fileName.concat(input[i] + " ");
                    else
                        fileName = fileName.concat(input[i]);
                }
            }
        }
        FileWriter writer = new FileWriter(fileName + ".txt");
        for(k=(i+1);k++;k<input.length-1){
            writer.write(input[k] + System.lineSeparator());
        }
    }
}
