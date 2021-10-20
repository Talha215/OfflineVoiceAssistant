import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class date implements command{
    public void initialize(){
        commandPhrases.add("date");
    }
    public boolean isFound(String word){
        return commandPhrases.contains(word);
    }
    public static String run(ArrayList<String> input){
        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        LocalDateTime now = LocalDateTime.now();
        return ("today is " + dtf.format(now));
    }
}
