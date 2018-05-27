package Amazon.LoginFunctionality;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Helper.BrowserFactory;

public class AmazonOrderDetail {
	
	public static String order1,productname,image1;
	public void launchApplication()
	{
		
		BrowserFactory.startBrowser("chrome", "https://www.amazon.in/");
			
	}
	public void registereduserlogincheck() throws Exception 
	{

		//BrowserFactory.driver.findElement(By.xpath("//*[@id='nav-link-yourAccount']")).click();
		BrowserFactory.driver.findElement(By.xpath("//*[@name='email']")).sendKeys("sngtsn64@gmail.com");
		Thread.sleep(2000);
		BrowserFactory.driver.findElement(By.xpath("//input[@class='a-button-input']")).submit();
		BrowserFactory.driver.findElement(By.xpath("//*[@id='ap_password']")).sendKeys("Kutti@123");
		BrowserFactory.driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		
		Thread.sleep(5000);
	}
	public void Order() throws Exception
	{
//		WebElement menu;
//		
//		BrowserFactory.driver.findElement(By.id("nav-link-yourAccount")).click();
	
		
		Actions action = new Actions(BrowserFactory.driver);
		WebElement mainMenu = BrowserFactory.driver.findElement(By.id("nav-link-yourAccount"));
		action.moveToElement(mainMenu).moveToElement(BrowserFactory.driver.findElement(By.xpath("//*[@id='nav_prefetch_yourorders']/span[text()='Your Orders']"))).click().build().perform();
		registereduserlogincheck();
		System.out.println("Clicked orders");
		BrowserFactory.driver.findElement(By.linkText("Open Orders")).click();
		order1=BrowserFactory.driver.findElement(By.id("yourOrdersContent")).getText();
		System.out.println(order1);
//		order1=BrowserFactory.driver.findElement(By.xpath("//span[@class='order-date-invoice-item'][2]")).getText();
//		productname=BrowserFactory.driver.findElement(By.xpath("//*[@id='ordersContainer']/a[@class='a-link-normal']")).getText();
//		image1=BrowserFactory.driver.findElement(By.xpath("//img[@title='Weavers Villa® Punjabi Hand Embroidery Phulkari Faux Chiffon Pink Dupatta, Stoles']")).getAttribute("alt src");
//		
//		System.out.println(order1+productname+image1);
		WriteFile();
	}
	public void WriteFile() throws IOException
	{
		FileWriter fr=new FileWriter("E:\\Outputfiles\\productdetail.txt");
		BufferedWriter br=new BufferedWriter(fr);
		br.write(order1);
		System.out.println("file is written");
		br.newLine();
		br.close();
		BrowserFactory.driver.quit();
			
	}
	
	public static void main(String[] args) throws Exception{
		AmazonOrderDetail order=new AmazonOrderDetail();
		order.launchApplication();
		order.Order();

	}

}
