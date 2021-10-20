import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.List;

public class time implements command {
    public void initialize(){ commandPhrases.add("time"); }
    public boolean isFound(String word){
        return commandPhrases.contains(word);
    }
    public static String run(List<String> input){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh mm a");
        LocalDateTime now = LocalDateTime.now();
        return ("it is currently " + dtf.format(now));
    }
}
