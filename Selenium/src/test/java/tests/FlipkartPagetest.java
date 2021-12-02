package tests;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import pages.FlipkartPageObjects;


public class FlipkartPagetest {

	static WebDriver driver=null;
	public static void main(String[] args) {
		setup();
		flipkartactions();
		teardown();

	}
	public static void setup(){
		System.setProperty("webdriver.edge.driver","D:/jars/sele_jars/edge/msedgedriver.exe");
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com");
		System.out.println("Main page title:"+driver.getTitle());
	}
	public static void teardown(){
		driver.quit();
	}
	public static void flipkartactions(){
		
		FlipkartPageObjects pageObj=new FlipkartPageObjects(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		pageObj.loginpopup();
		pageObj.setsearchtext("iphone 13");
     	pageObj.searchbtn();
     	pageObj.products("APPLE iPhone 13 (Blue, 512 GB)");
  
     	
	}
}

























