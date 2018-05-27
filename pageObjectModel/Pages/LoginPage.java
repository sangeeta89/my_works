/**
 * 
 */
package pageObjectModel.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Sangeeta
 * This class stores all locators
 */
public class LoginPage {
	WebDriver driver;
	By username=By.id("email");
	By password=By.name("pass");
	By loginbutton=By.xpath("//button[@name='login']");
	
	
		
	public LoginPage(WebDriver driver){
		this.driver=driver;
		
	}
	public void typeUsername(){
		driver.findElement(username).sendKeys("sngtsn64@gmail.com");
		
			
	}
	public void typePassword(){
		driver.findElement(password).sendKeys("Neeelad12");
		
	}
	public void loginsubmit(){
		driver.findElement(loginbutton).click();
	
	}
	
}