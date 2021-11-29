import org.json.JSONException;
import org.json.JSONObject;
import java.net.URI;
import java.net.http.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author cheetu
 */
public class weather implements commandInterface{
    ArrayList<String> commandPhrases = new ArrayList<>();


    public weather() { commandPhrases.add("weather");}


    public boolean match(String word) { return commandPhrases.contains(word);}

    public  String run(String[] input) {
        String apiKey = "";
        String  urlCityID = "https://api.openweathermap.org/data/2.5/weather?id=";
        String units = "&units=imperial";
        int start = 0;

        for(int i = 0; i < input.length; i++){
            if(input[i].equals("in")) {
                start = i;
                break;
            }
            }

        String str =  String.join(" ", Arrays.copyOfRange(input, ++start, input.length));


        String ID = switch (str) {
            case "New York City", "New York" -> "5128581";
            case "Boston" -> "4930956";
            case "Los Angeles" -> "5368361";
            case "Vancouver" -> "6173331";
            case "Atlanta" -> "4180439";
            case "Albany" -> "5106834";
            //   case "Albany", default -> "5106834";
            default -> "616593";

        };

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlCityID + ID + apiKey + units)).build();
        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(weather::parse)
                .join();


    }


    public static String parse(String httpBody) throws JSONException {
        JSONObject info = new JSONObject(httpBody);

        //  System.out.println(httpBody); Uncomment to Debug JSON

        //more values
        float temp = info.getJSONObject("main").getFloat("temp");
        float low = info.getJSONObject("main").getFloat("temp_min");
        float high = info.getJSONObject("main").getFloat("temp_max");
        float feels = info.getJSONObject("main").getFloat("feels_like");
        float humidity = info.getJSONObject("main").getFloat("humidity");

        String description = info.getJSONArray("weather").getJSONObject(0).getString("description");
        String location = info.getString("name");


        // return "Right now, The temperature in " +  location  + " is " + temp + " degrees Fahrenheit. "  + "The weather report shows " + description +
        //         " with a low of " + low + " and a high of " + high + " the humidity is " + humidity + " percent" ;

        return "Right now, The temperature in " +  location  + " is " + temp + " degrees Fahrenheit. "  + "The weather report shows " + description +
                " with a humidity of " + humidity + " percent." ;


    }




}
