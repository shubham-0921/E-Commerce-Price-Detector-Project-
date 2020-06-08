package myJSoupProject;


import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/*
 * This class is used for HTML parsing from URL using Jsoup.
 */

public class ParseZillowGuide {
	public static void main(String args[]) throws IOException{
		print("running...");
		Document document;
		try {
			//Get Document object after parsing the html from given url.
			document = Jsoup.connect("https://www.amazon.in/ref=gw_pc_Amazondevices_1/dp/B07PFFMP9P?pf_rd_r=MCCRAMTXA92C97DF7KGF&pf_rd_p=4a34e4c6-09f1-49fb-8282-8f136eebde44").get();
				
			//Get title
			String title = document.title();
			
			//Get price
			Elements price=document.select(".a-size-medium a-color-price priceBlockBuyingPriceString:contains(₹&nbsp;)"); 

			
			//From document.html we get the html code of the page 
			//System.out.println(document.html());
			
			System.out.println(title);
			
			//Problem 
			//The below statement is not being run 
			for (int i=0; i < price.size(); i++) {
					System.out.println("here");
					System.out.print(price.get(i).text());
				}
			
			

		} catch (IOException e) {
			e.printStackTrace();
		}
		print("done");
	}
		
	

	public static void print(String string) {
		System.out.println(string);
	}
}