package Amazon.LoginFunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Helper.BrowserFactory;

public class LoginFunction  {

	public void launchApplication()
	{
		
		BrowserFactory.startBrowser("chrome", "https://www.amazon.in/");
			
	}
	public void registereduserlogincheck() throws Exception 
	{

		BrowserFactory.driver.findElement(By.xpath("//*[@id='nav-link-yourAccount']")).click();
		BrowserFactory.driver.findElement(By.xpath("//*[@name='email']")).sendKeys("sngtsn64@gmail.com");
		Thread.sleep(2000);
		BrowserFactory.driver.findElement(By.xpath("//input[@class='a-button-input']")).submit();
		BrowserFactory.driver.findElement(By.xpath("//*[@id='ap_password']")).sendKeys("Kutti@123");
		BrowserFactory.driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		
		Thread.sleep(5000);
		String customer=BrowserFactory.driver.findElement(By.xpath("//*[@id='nav-link-yourAccount']")).getText();
		System.out.println(customer);
		String expectedtext="Hello";
		if(customer.startsWith(expectedtext))
		{
			System.out.println("User is Registered");
		}
		else
		{
			System.out.println("User is not registered");
		}
		
	}
	public void InvalidCredentials() throws Exception
	{
		BrowserFactory.driver.findElement(By.xpath("//*[@id='nav-link-yourAccount']")).click();
		BrowserFactory.driver.findElement(By.xpath("//*[@name='email']")).sendKeys("");
		Thread.sleep(2000);
		BrowserFactory.driver.findElement(By.xpath("//input[@class='a-button-input']")).submit();
		BrowserFactory.driver.findElement(By.xpath("//*[@id='ap_password']")).sendKeys("Kutti@123");
		BrowserFactory.driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		
		
	}
	
	public static void main(String[] args) throws Exception {
		LoginFunction func=new LoginFunction();
		func.launchApplication();
		func.registereduserlogincheck();
		BrowserFactory.driver.close();
	}

}
