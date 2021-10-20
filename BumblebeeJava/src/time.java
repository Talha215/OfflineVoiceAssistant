import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class time extends commandClass implements commandInterface {
	ArrayList<String> commandPhrases = new ArrayList<String>();
	
	public time() {
    	commandPhrases.add("time");
    }
		
    public boolean match(String word){
        return commandPhrases.contains(word);
    }
    
    public String run(String[] input){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh mm a");
        LocalDateTime now = LocalDateTime.now();
        return ("it is currently " + dtf.format(now));
    }
}
