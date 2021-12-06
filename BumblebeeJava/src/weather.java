import org.json.JSONException;
import org.json.JSONObject;
import java.net.URI;
import java.net.http.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CompletionException;

public class weather extends commandClass implements commandInterface{
    ArrayList<String> commandPhrases = new ArrayList<>();


    public weather() { commandPhrases.add("weather");}


    public boolean match(String word) { return commandPhrases.contains(word);}

    public  String run(String[] input) {
        String apiKey = "c92c100a7829e172b2888b44106073b7";
        String urlCity = "https://api.openweathermap.org/data/2.5/weather?q=";
        String units = "&units=imperial";
        int start = 0;

        for(int i = 0; i < input.length; i++){
            if(input[i].equals("in")) {
                start = i;
                break;
            }
        }

        String str =  String.join(" ", Arrays.copyOfRange(input, ++start, input.length));

        str = str.replaceAll(" ", "%20");
        
        try {
	        HttpClient client = HttpClient.newHttpClient();
	        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlCity + str + "&appid=" + apiKey + units)).build();
	        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
	                .thenApply(HttpResponse::body)
	                .thenApply(weather::parse)
	                .join();
        } catch(CompletionException e) {
        	str = str.replaceAll("%20", " ");
        	if(!Arrays.asList(input).contains("in"))
        		return "Invalid syntax. Please try again or consult the syntax command.";
        	return str + " was not found.";
        }

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