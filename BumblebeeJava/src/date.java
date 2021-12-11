import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
/**
 * @author Kathleen Snyder
 *
 */
public class date extends commandClass implements commandInterface {
	ArrayList<String> commandPhrases = new ArrayList<String>();
	
	public date() {
    	commandPhrases.add("date");
    }
		
    public boolean match(String word){
        return commandPhrases.contains(word);
    }
    
    public String run(String[] input){
        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        LocalDateTime now = LocalDateTime.now();
        return ("today is " + dtf.format(now));
    }
}
