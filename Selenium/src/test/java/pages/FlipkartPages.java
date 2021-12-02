package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlipkartPages {
	
	
	private static WebElement loginpopup=null, searchbox=null, srchbutton=null, addtocartbtn=null,cart=null,proddetail=null ;
	private static List<WebElement> products=null;
	
	public static WebElement loginpopup(WebDriver driver){
		loginpopup=driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		return loginpopup;
	}
	
	public static WebElement searchbox(WebDriver driver){
		searchbox=driver.findElement(By.xpath("//*[contains(@title,'Search')]"));
		return searchbox;
	
		
	}
	public static WebElement srchbutton(WebDriver driver){
		srchbutton=driver.findElement(By.xpath("//form/div/button[@class='L0Z3Pu']"));
		return srchbutton;
	}
	
	public static List<WebElement> products(WebDriver driver){
		products=driver.findElements(By.cssSelector("div._4rR01T")); 
		return products;
	}
	
	public static WebElement addcart(WebDriver driver){
		addtocartbtn=driver.findElement(By.xpath("//*[@class='_2KpZ6l_2U9uOA _3v1-ww']"));
		return addtocartbtn;
	}
	
	public static WebElement productdetail(WebDriver driver){
		proddetail=driver.findElement(By.xpath("//div[@class='_16FRp0']"));
		return proddetail;
	}
	
	public static WebElement cart(WebDriver driver){
		cart=driver.findElement(By.xpath("//div[@class='_1dVbu9']"));
		return cart;
	}
}
