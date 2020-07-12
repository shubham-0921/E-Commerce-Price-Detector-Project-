package com.project1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class MainCode2_ScrapingPrice {

	public static void main(String[] args) throws IOException {
		
		String url = null;
		
		//We need to write our further code here of Scraping for rows in Table 2
		//Now we need to scrape for each row of table 2
		//We need to write a query here
		
		//We will do the scraping here 3 times for each row of table 2
		
		print("running...Scraping Price");
		try {
			
			Class.forName("com.mysql.jdbc.Driver");   //The driver class for the mysql database is com.mysql.jdbc.Driver.
			
			
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://database-1.ccff8lgiojth.us-east-2.rds.amazonaws.com:3306/new_schema","admin","abcd1234"); 
			
			
			//Call the RDS and access the table 2
			
			//We will write the query here to access the url 
			
//Doubt Here->     //We need to get the url from table 2 || This part of code needs to be iterative 	
			//Here we need to do this for all the rows in the table2 and then add to table3		
			
			
			
			con.close(); 

			
	
		}catch(Exception e){ System.out.println(e);} 
		
	
			
			Document document1;
			
			
			String priceItem = "No Price Found";

			//Here the below url should be taken from table 2
			

			
			document1 = Jsoup.connect(url).get();
			
			
			Element price1=document1.getElementById("priceblock_ourprice");  //To get the price of an item we just need to put that class name which contains the price
			
			Element price2=document1.getElementById("priceblock_dealprice");
			
			Element price3=document1.getElementById("priceblock_saleprice");
			
			
			//For Scraping the price we have different Element and we need to check if it not null and then only print
			
			if(price2!=null) {
				priceItem=price2.text();
				System.out.println(price2.text());
			}
			
			else if(price1!=null) {
				priceItem=price1.text();
				System.out.println(price1.text());
			}
			
			else if(price3!=null) {
				priceItem=price3.text();
				System.out.println(price3.text());
			}
			
			
			
		} 
		
				
	
	public static void print(String string) {
		System.out.println(string);
	}

}
