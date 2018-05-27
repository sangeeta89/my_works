/**
 * 
 */
package Amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * @author Sangeeta
 *
 */
public class LoginFlip {
	
	WebDriver driver;
	By loginlink=By.xpath("//a[contains(.,'Login & Signup')]");
	
	By username=By.cssSelector("//div[@class='_39M2dM']//input[@class='_2zrpKA']");
	
	//driver.findElement(By.xpath("'/div[@class='_39M2dM']//input[@class='_2zrpKA']"));
	
	By password=By.xpath("//div[@class='_39M2dM']//input[@class='_2zrpKA _3v41xv']");
	By loginbutton=By.xpath("//button[@class='_2AkmmA _1LctnI _7UHT_c']");
	
	public LoginFlip(WebDriver driver)
	{
		this.driver=driver;
		
	}
	public void login()
	{
		driver.findElement(loginlink).click();
		
		driver.findElement(username).sendKeys("sngtsn64@gmail.com");
		driver.findElement(password).sendKeys("Kutti28");
		driver.findElement(loginbutton).click();
	}
	

}
