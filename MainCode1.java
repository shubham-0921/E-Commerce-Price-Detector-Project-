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


public class MainCode1 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
//\\	//To generate a UUID we have below snippet of code
		
		 String shortId1 = RandomStringUtils.randomNumeric(4); 
		 String shortId2 = RandomStringUtils.randomNumeric(4); 
		 
	
		 
//\\	//Taking input from user 
		 
		 String title1 = "No Title Found";
		 
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
		 
		 
		 
		 
//\\		//Finding data from the url given by user
		 
		 	//We req to do scraping on all the rows of table 2 and fill data in table 3 
		 
		 	print("running...Scraping Title");
			
			try {
				Document document1;
				
				document1 = Jsoup.connect(url).get();
				
				
				title1 = document1.title();
				print(title1);
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			print("done scraping Title");
		
		 
			
			
//\\     //Output in command line
		 System.out.println (shortId1);
		 System.out.println (name);
		 System.out.println (mail);
		 System.out.println (phone);
		 System.out.println (url);

		 
		 
//\\		 //Now we will enter these details in the user table in our RDS 
		 	//We are filling the table1 and table2 ie: User table and ProductInput table below
		 
		 try{  
				Class.forName("com.mysql.jdbc.Driver");   //The driver class for the mysql database is com.mysql.jdbc.Driver.
				
				
				Connection con=DriverManager.getConnection(  
				"jdbc:mysql://database-1.ccff8lgiojth.us-east-2.rds.amazonaws.com:3306/new_schema","admin","abcd1234");  
				 
			
				
		//Inserting data into the table in database
				
				//Inserting a row in Table User
				String addRow1 = "insert into user (u_id,u_name,mail,phone_number) "+"values (?,?,?,?)";
				
				//Inserting a row in Table ProductInput
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
				p2.setInt(5,1200);  //just passing a temp value here || Need to make change here
				
				//We need to add the Price of item in the 3rd table 
				//p2.setString(6,priceItem); 
				
				int r1 = p1.executeUpdate();
				int r2 = p2.executeUpdate();
				
			
				
				
				con.close(); 

				
		
			}catch(Exception e){ System.out.println(e);} 
	}
	
	
	public static void print(String string) {
		System.out.println(string);
	}

}
