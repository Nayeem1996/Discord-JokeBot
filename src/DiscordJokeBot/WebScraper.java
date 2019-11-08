package DiscordJokeBot;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WebScraper {

    private static final String url = "http://funnycomedianquotes.com/top/offensive-quotes.html";

    private static final List<String> jokesList = new ArrayList<>();

    public String generateJoke() {
        String randomJoke;

        try {
            //Connect to url and imitate a browser (Mozilla) in case bot browser is revoked
            final Document doc = Jsoup.connect(url).userAgent("Mozilla/17.0").get();

            Elements temp = doc.select("div.quote-item.clear");

            //Iterate through each element and add each joke to arrayList unless the element has no joke in it
            for (Element jokes : temp) {
                if (!jokes.getElementsByTag("p").first().hasText()) {
                    System.out.println("Empty joke");
                } else {
                    String tempComedianName = jokes.getElementsByTag("a").first().text();
                    jokesList.add("'" + jokes.getElementsByTag("p").first().text() + "' - " + tempComedianName);
                }
            }


            //Get a random joke from arrayList
            Random rand = new Random();
            randomJoke = jokesList.get(rand.nextInt(jokesList.size()));

        } catch (Exception ex) {
            ex.printStackTrace();
            randomJoke = "Funny joke";
        }
        return randomJoke;
    }
}

