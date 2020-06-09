package myJSoupProject;


import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 * This class is used for HTML parsing from URL using Jsoup.
 */

public class ParseZillowGuide {
	public static void main(String args[]) throws IOException{
		print("running...");
		Document document1;
		Document document2;
		Document document3;
		Document document4;
		
		
		try {
			//Get Document object after parsing the html from given url.
			//By the Jsoup.connect method we can get the object from that we get the desired data  
			
			//For Flipakart
			String url;
			System.out.println("Please enter the URL for which you require the Product Price:");
			
			document1 = Jsoup.connect("https://www.flipkart.com/i-kall-k2180/p/itmextf99g7r6cqy?pid=MOBFHVWDPAYJGZFK&lid=LSTMOBFHVWDPAYJGZFKJ5NDJV&marketplace=FLIPKART&srno=b_1_1&otracker=hp_omu_Deals%2Bof%2Bthe%2BDay_3_3.dealCard.OMU_Deals%2Bof%2Bthe%2BDay_HSORBOAPEAPL_3&otracker1=hp_omu_SECTIONED_neo%2Fmerchandising_Deals%2Bof%2Bthe%2BDay_NA_dealCard_cc_3_NA_view-all_3&fm=neo%2Fmerchandising&iid=9a55633d-8ebb-430c-b2f0-13acbdc472de.MOBFHVWDPAYJGZFK.SEARCH&ppt=browse&ppn=browse&ssid=0mvqco9zps0000001591695569044").get();
			document2 = Jsoup.connect("https://www.flipkart.com/vivo-nex-black-128-gb/p/itmfb4ctja3mgrcz?pid=MOBFB4CTZYDFUTYH&lid=LSTMOBFB4CTZYDFUTYHBEIJP8&fm=neo%2Fmerchandising&iid=M_42f573e9-29d8-4e98-913a-24f63250f97a_20.A8P7313X839X&ppt=hp&ppn=homepage&ssid=l7q1un7ni80000001591695831013&otracker=hp_omu_Best%2BBattery%2BPhones_1_13.dealCard.OMU_Best%2BBattery%2BPhones_A8P7313X839X_10&otracker1=hp_omu_WHITELISTED_neo%2Fmerchandising_Best%2BBattery%2BPhones_NA_dealCard_cc_1_NA_view-all_10&cid=A8P7313X839X").get();
			
			//For Amazon 
			document3 = Jsoup.connect("https://www.amazon.in/gp/product/B07QD651MX?pf_rd_r=DXPVSYV60E97MVCPAAWJ&pf_rd_p=649eac15-05ce-45c0-86ac-3e413b8ba3d4").get();
			document4 = Jsoup.connect("https://www.amazon.in/ref=gw_pc_Amazondevices_1/dp/B07PFFMP9P?pf_rd_r=8GJJRYC3S7155DFP03F7&pf_rd_p=4a34e4c6-09f1-49fb-8282-8f136eebde44").get();

			
			//Get title
			String title1 = document1.title();
			String title2 = document2.title();
			String title3 = document3.title();
			String title4 = document4.title();
			
			
			//Get price1
			Elements price1=document1.getElementsByClass("_1vC4OE _3qQ9m1");  //To get the price of an item we just need to put that class name which contains the price
			
			System.out.println(title1);
			for(Element elements : price1) {
				System.out.println(elements.text());
			}

			//Get price2
			Elements price2=document2.getElementsByClass("_1vC4OE _3qQ9m1");  //To get the price of an item we just need to put that class name which contains the price
			
			System.out.println(title2);
			for(Element elements : price2) {
				System.out.println(elements.text());
			}	
						
			//Get price3
			Elements price3=document3.getElementsByClass("a-size-medium a-color-price priceBlockBuyingPriceString");  //To get the price of an item we just need to put that class name which contains the price
			
			System.out.println(title3);
			for(Element elements : price3) {
				System.out.println(elements.text());
			}	
			
			//Get price4
			Elements price4=document4.getElementsByClass("a-size-medium a-color-price priceBlockBuyingPriceString");  //To get the price of an item we just need to put that class name which contains the price
			
			System.out.println(title4);
			for(Element elements : price4) {
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