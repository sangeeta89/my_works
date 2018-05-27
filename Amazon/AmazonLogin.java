package Amazon;

import Helper.BrowserFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.Test;

public class AmazonLogin {	
	
	public static String form;
	public void amazon() throws Exception
	{
		BrowserFactory.startBrowser("chrome", "https://www.amazon.in/");
		
	}
//	public void navigate()
//	{
//		BrowserFactory.driver.findElement(By.xpath("//*[@id='nav-link-yourAccount']")).click();
//	}
	public void login() throws Exception
	{
		
		
		BrowserFactory.driver.findElement(By.xpath("//*[@name='email']")).sendKeys("sngtsn64@gmail.com");
		Thread.sleep(2000);
		BrowserFactory.driver.findElement(By.xpath("//input[@class='a-button-input']")).submit();
		BrowserFactory.driver.findElement(By.xpath("//*[@id='ap_password']")).sendKeys("Kutti@123");
		BrowserFactory.driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		Thread.sleep(5000);
		Order();
	}
	
	public void Search()
	{
		WebElement srcbox=BrowserFactory.driver.findElement(By.id("twotabsearchtextbox"));
		srcbox.sendKeys("Dell Laptop");
		BrowserFactory.driver.findElement(By.xpath("//input[@value='Go']")).click();
	
	}
	public void Searchcontent() throws Exception
	{

		BrowserFactory.driver.findElement(By.linkText("Dell Inspiron 15 3565 15-inch Laptop (7th Gen E2-9000/4GB/1TB/Win. 10 /Integrated Graphics), Black")).click();
//		JavascriptExecutor js=(JavascriptExecutor)BrowserFactory.driver;
//		
//		WebElement productdetail=BrowserFactory.driver.findElement(By.xpath("//*[@id='prodDetails']"));
//		js.executeScript("arguments[0].scrollIntoView(true);",productdetail);
//		System.out.println(productdetail.getText());

//		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
//		
//		BrowserFactory.driver.findElement(By.linkText("See more product details")).sendKeys(selectLinkOpeninNewTab);
//		ArrayList<String> tabs=new ArrayList<>(BrowserFactory.driver.getWindowHandles());
//		BrowserFactory.driver.switchTo().window(tabs.get(2));

		
		   
	}
	public void Addcart() throws Exception
	{	
		Thread.sleep(3000);
		String parentWindow = BrowserFactory.driver.getWindowHandle();
		Set<String> handles =  BrowserFactory.driver.getWindowHandles();	
		
			for(String windowHandle  : handles)
		       {
		       if(!windowHandle.equals(parentWindow))
		          {
		    	   BrowserFactory.driver.switchTo().window(windowHandle);
		    
		    	   Thread.sleep(5000);
		    	   BrowserFactory.driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).submit();
		    	   BrowserFactory.driver.findElement(By.xpath("//*[@id='hlb-ptc-btn-native']")).click();
		    	   Thread.sleep(5000);
		    	   BrowserFactory.driver.findElement(By.xpath("//*[@id='siNoCoverage-announce']")).click();
		    	   String popup=BrowserFactory.driver.getWindowHandle();
		    	   System.out.println(popup);
		    	   	    	   
		    	   Thread.sleep(5000);
		    	   login();
		    	   }
		       }
	}
	public void Order() throws IOException
	{
		WebElement formElement = BrowserFactory.driver.findElement(By.name("spc"));
		form=formElement.getText();
		
		WriteFile();
		BrowserFactory.driver.findElement(By.xpath("//form//input[@class='a-button-text place-your-order-button']")).submit();
		System.out.println("order placed");

	}
	public void WriteFile() throws IOException
	{
		FileWriter fr=new FileWriter("E:\\Outputfiles\\data.txt");
		BufferedWriter br=new BufferedWriter(fr);
		br.write(form);
		br.newLine();
		br.close();
			
	}
	public void logout()
	{	
		System.out.println("Browser QUIT");
		BrowserFactory.driver.quit();

	}	
	public static void main(String arg[]) throws Exception
	{
		
		AmazonLogin obj=new AmazonLogin();
		obj.amazon();
		//obj.login();
		obj.Search();
		obj.Searchcontent();
		obj.Addcart();
		obj.logout();
	    
	}

}

