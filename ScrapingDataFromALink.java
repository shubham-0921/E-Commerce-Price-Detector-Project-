package myJSoupProject;

import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ScrapingDataFromALink {
	public static final String Site="https://commits.top/worldwide.html"; //We will look for the links on this site
	
	//////////////////////
	//Some mistake in the code here 
	//Find it 
	//////////////////////////
	public static void main(String args[]) {
		print("running...");
		Document document1; //creating an object of Document class 
		
		
		try {
			
			
			document1 = Jsoup.connect("https://commits.top/worldwide.html").get(); 
			
		
			//Get title
			String title1 = document1.title();
			print(title1);
			
			Element table=document1.select("table").get(0); //Here we are selecting the table 
			
			Elements rows=table.select("tr"); 
			
			for (int i = 1; i < rows.size(); i++) { 
				Element row=rows.get(i);  //iterating over each row 
				Elements cols=row.select("td");
				
				//Now we need to print the href
				//System.out.println(cols.get(1)); //By this statement it is printing the entire 1st col but we only need the href 
				
				//By the below code we are able to extract the links from a column of a table 
				Elements link=cols.get(1).select("a"); //what we are doing here is that we are storing the elements in link from column 1 and selecting "a" to get the href
				String url=link.attr("href");
				
				//System.out.println(url);
				
				//Now we need to Pass this url to get the details from the profile
				FindDetails(url);
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		print("done");
		
	}
	
	public static void FindDetails(String url) { //Here we are passing the url link 
		Document document2 = null;
		try {
			document2=Jsoup.connect(url).get();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Can't Access the link");
		}
		
		//Getting the Name
		Elements name=document2.getElementsByClass("p-name vcard-fullname d-block overflow-hidden");
		
		//Now we print the name 
		for(Element elements:name) {
			System.out.println(elements.text());
		}
		
		//Getting the GitHub ID
		Elements git_name=document2.getElementsByClass("p-nickname vcard-username d-block");
		
		 
		for(Element elements:git_name) {
			System.out.println(elements.text());
		}
		
		
		//Getting Location 
		//I am able to access the location directly from the list 
		Elements loc=document2.getElementsByClass("p-label");
		
		 
		for(Element elements:loc) {
			System.out.println(elements.text());
		}
		
		
		
		//Not Working Code [Skip it]
		
		//We need to get the email out of the list 
		/*
		Element list=document2.select("ul").get(2);  //change the number to find that ul(unordered list)
		Elements item=list.select("li"); //Getting all the lists in the ul 
		Elements l1=item.get(0).select("a");
		String mail=l1.attr("href");
		*/
		
		
		
		//Doubt here.............
		//////////////////////////////////////
		
		//Getting the Email
		
		Elements m1=document2.select("div > div > ul > li > a[href]");

		String link=m1.attr("href");
		
		
		System.out.println(m1.text()); //This way it prints everything which has the above select 
		System.out.println(link);  //Printing the Email 
		////////////////////////////////////////
	
		System.out.println();
	}
	
	public static void print(String string) {
		System.out.println(string);
	}
}
