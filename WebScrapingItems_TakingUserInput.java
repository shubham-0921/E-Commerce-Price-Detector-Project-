package myJSoupProject;

import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebScrapingItems_TakingUserInput {
	public static void main(String args[]) throws IOException{
		print("running...");
		Document document1;
		Document document2;
		
		Scanner sc=new Scanner(System.in);
		
		try {
			//Get Document object after parsing the html from given url.
			//By the Jsoup.connect method we can get the object from that we get the desired data  
			
			//For Flipkart
			String url1 = null;
			System.out.println("Enter the Flipkart product URL");
			url1=sc.next();
			
			document1 = Jsoup.connect(url1).get();
		
			//Get title
			String title1 = document1.title();
			System.out.println(title1);
			
			//Get price1
			Elements price1=document1.getElementsByClass("_1vC4OE _3qQ9m1");  //To get the price of an item we just need to put that class name which contains the price
			
			for(Element elements : price1) {
				System.out.println(elements.text());
			}
			
			
			//For Amazon 
			String url2 = null;
			System.out.println("Enter the Amazon product URL");
			url2=sc.next();
			
			document2 = Jsoup.connect(url2).get();
			
			
			String title2 = document2.title();
			System.out.println(title2);
			
			//Get price2
			Elements price2=document2.getElementsByClass("a-size-medium a-color-price priceBlockBuyingPriceString");  //To get the price of an item we just need to put that class name which contains the price
			
		
			for(Element elements : price2) {
				System.out.println(elements.text());
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
