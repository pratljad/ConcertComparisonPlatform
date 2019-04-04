package app;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WebCrawlerWithDepth {
	
	 public static void main(String[] args) throws IOException {
	        Document doc = Jsoup.connect("https://www.oeticket.com/tickets.html?affiliate=EOE&doc=category&fun=kategorieliste&detailadoc=erdetaila&detailbdoc=evdetailb&hkId=109&nurbuchbar=true&showFilter=yes&tipps=yes").get();
	        log(doc.title());
		//test css queries: https://try.jsoup.org/
	        Elements newsHeadlines = doc.select("#taEventList tbody tr");
	        for (Element headline : newsHeadlines) {
	            log("%s\n\t%s", headline.attr("class"), headline.absUrl("onmouseover"));
	            System.out.println("taImage: " + headline.getElementsByClass("taImage") );
	            if(headline.tagName("td").equals("td")) {
	            	System.out.println("td Ausgabe: "+ headline.tagName() + " " + headline.attr("abs:src"));
	            }
	            //System.out.println(headline.tagName("td"));
	        }
	    }

	    private static void log(String msg, String... vals) {
	        System.out.println(String.format(msg, vals));
	    }
 /*   private HashSet<String> links;
    private List<List<String>> articles;

    public WebCrawlerWithDepth() {
        links = new HashSet<>();
        articles = new ArrayList<>();
    }

    //Find all URLs that start with "http://www.mkyong.com/page/" and add them to the HashSet
    public void getPageLinks(String URL) {
        if (!links.contains(URL)) {
            try {
                Document document = Jsoup.connect(URL).get();
                Elements otherLinks = document.select("tr");

                for (Element page : otherLinks) {
                    if (links.add(URL)) {
                        //Remove the comment from the line below if you want to see it running on your editor
                        System.out.println(URL);
                    }
                    getPageLinks(page.attr("abs:href"));
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    //Connect to each link saved in the article and find all the articles in the page
    public void getArticles() {
        links.forEach(x -> {
            Document document;
            try {
                document = Jsoup.connect(x).get();
                Elements articleLinks = document.select("tr");
                for (Element article : articleLinks) {
                    //Only retrieve the titles of the articles that contain Java 8
                    if (article.text().matches("^.*?(line).*$")) {
                        //Remove the comment from the line below if you want to see it running on your editor, 
                        //or wait for the File at the end of the execution
                       //System.out.println(article.attr("abs:href"));

                        ArrayList<String> temporary = new ArrayList<>();
                        temporary.add(article.text()); //The title of the article
                        temporary.add(article.attr("abs:href")); //The URL of the article
                        articles.add(temporary);
                    }
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        });
    }

    public void writeToFile(String filename) {
        FileWriter writer;
        try {
            writer = new FileWriter(filename);
            articles.forEach(a -> {
                try {
                    String temp = "- Title: " + a.get(0) + " (link: " + a.get(1) + ")\n";
                    //display to console
                    System.out.println(temp);
                    //save to file
                    writer.write(temp);
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            });
            writer.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
    	WebCrawlerWithDepth bwc = new WebCrawlerWithDepth();
        bwc.getPageLinks("https://www.oeticket.com");
        bwc.getArticles();
        bwc.writeToFile("Java 8 Articles");
    }
    */
}