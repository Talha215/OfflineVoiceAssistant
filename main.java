import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args) {
        String phrase = "what time is it";
        String str[] = phrase.split(" ");
        List<String> elements = new ArrayList<String>();
        elements = Arrays.asList(str);
        /*for(String s: elements){
            System.out.println(s);
        } prints all elements*/
        //System.out.println(time.commandPhrases);
        System.out.println(time.run(elements));
    }
}
