package tests;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import pages.FlipkartPageObjects;

public class FlipkartPageJunitTest {
	static WebDriver driver=null;
	
	@BeforeClass
	public static void setup(){
		System.setProperty("webdriver.edge.driver","D:/jars/sele_jars/edge/msedgedriver.exe");
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com");
		System.out.println("Main page title:"+driver.getTitle());
	}
	@AfterClass
	public static void teardown(){
		driver.quit();
	}
	@Test
	public void flipkartactions()
	{	
		FlipkartPageObjects pageObj=new FlipkartPageObjects(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		pageObj.loginpopup();
		pageObj.setsearchtext("iphone 13");
     	pageObj.searchbtn();
     	pageObj.products("APPLE iPhone 13 (Blue, 512 GB)");
	}

}