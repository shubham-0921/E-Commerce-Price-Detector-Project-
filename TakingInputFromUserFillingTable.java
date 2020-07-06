package com.project1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.UUID;
import org.apache.commons.lang3.RandomStringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class TakingInputFromUserFillingTable {

	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		//To generate a UUID we have below snippet of code
		///
		 String shortId1 = RandomStringUtils.randomNumeric(4); 
		 String shortId2 = RandomStringUtils.randomNumeric(4); 
		 
		///
		 
		 String title1 = "none";
		 
		 //Taking input of name from user 
		 String name;
		 System.out.print ("Enter your Name:");
		 name=sc.next();
		 
		 
		 //Taking input of email from user 
		 String mail;
		 System.out.print ("Enter your Email:");
		 mail=sc.next();
		
		 
	
		 //Taking input of phone from user 
		 String phone;
		 System.out.print ("Enter your phone:");
		 phone=sc.next();
		 
		//Taking input of product url  from user 
		 String url;
		 System.out.print ("Enter Product url you would like to track:");
		 url=sc.next();
		 
		 
		 
		 
		 //Finding data from the url given by user
		 print("running...");
			Document document1;
			
			
			try {
		
				document1 = Jsoup.connect(url).get(); //Since we  already have the url in double inverted comma so we write here directly url
				//Get title
				title1 = document1.title();
				print(title1);
				
				//Get Price of an Item from the given url 
				Elements price1=document1.getElementsByClass("a-size-medium a-color-price priceBlockBuyingPriceString");  //To get the price of an item we just need to put that class name which contains the price
				
			
				for(Element elements : price1) {
					System.out.println(elements.text());
				}
				
		
			} catch (IOException e) {
				e.printStackTrace();
			}
			print("done");
		 
		 
			
			
		 //Output in command line
		 System.out.println (shortId1);
		 System.out.println (name);
		 System.out.println (mail);
		 System.out.println (phone);
		 System.out.println (url);

		 
		 //Now we will enter these details in the user table in our RDS 
		 
		 try{  
				Class.forName("com.mysql.jdbc.Driver");   //The driver class for the mysql database is com.mysql.jdbc.Driver.
				
				
				Connection con=DriverManager.getConnection(  
				"jdbc:mysql://database-1.ccff8lgiojth.us-east-2.rds.amazonaws.com:3306/new_schema","admin","abcd1234");  
				 
			
				
	//\\		//Inserting data into the table in database
				
				String addRow1 = "insert into user (u_id,u_name,mail,phone_number) "+"values (?,?,?,?)";
				String addRow2 = "insert into ProductInput (u_id,Product_id,Product_url,Product_name,TimeWindow) "+"values (?,?,?,?,?)";

				PreparedStatement p1 = con.prepareStatement(addRow1,Statement.RETURN_GENERATED_KEYS);
				PreparedStatement p2 = con.prepareStatement(addRow2,Statement.RETURN_GENERATED_KEYS);

				
				p1.setString(1,shortId1); 
				p1.setString(2,name); 
				p1.setString(3,mail); 
				p1.setString(4,phone);  
				
				p2.setString(1,shortId1); 
				p2.setString(2,shortId2);  
				p2.setString(3,url); 
				p2.setString(4,title1); 
				p2.setInt(5,1200); 
				
				int r1 = p1.executeUpdate();
				int r2 = p2.executeUpdate();
				
				
				
				con.close(); 

				
		
			}catch(Exception e){ System.out.println(e);} 
	}
	public static void print(String string) {
		System.out.println(string);
	}

}
