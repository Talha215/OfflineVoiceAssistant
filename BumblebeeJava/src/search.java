import java.util.ArrayList;
import java.io.IOException;
import java.net.UnknownHostException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class search extends commandClass implements command{
	ArrayList<String> commandPhrases = new ArrayList<String>();

	public search() {
		commandPhrases.add("search");
	}

	@Override
	public boolean match(String token) {
		return commandPhrases.contains(token);
	}

	@Override
	public String run(String[] command) {

		final String URL = "https://duckduckgo.com/html/?q=";
		Document response = null;
		String fullCommand = "";
		for(int i=0;i<command.length;i++) {
			fullCommand += command[i] + " ";
		}

		try {
			response = Jsoup.connect(URL + fullCommand).get();
			Elements results = response.getElementById("links").getElementsByClass("results_links");
			//System.out.println(response.getElementsByClass("result__snippet").first().text());
			return response.getElementsByClass("result__snippet").first().text();
		} catch(UnknownHostException e) {
			return "You are not connected to the internet";
		} catch (IOException e) {
			e.printStackTrace(); 
		} 
		
		return "There was an error in the search";


	}

}
