/**
 * 
 */
package pageObjectModel.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Sangeeta
 *
 */
public class LoginPageNew 
{
	WebDriver driver;
	public WebDriver LoginPageNew(WebDriver localdriver)
	{
		return this.driver=localdriver;
	}
	

	@FindBy(id="email") 
	@CacheLookup
	WebElement email;
	
	@FindBy(how=How.NAME,using="pass") 
	@CacheLookup
	WebElement password;
	
	@FindBy(how=How.XPATH,using="//button[@name='login']")
	@CacheLookup
	WebElement loginbutton;
	
	public void login_fb(String emailid,String pass)
	{
		email.sendKeys("sngtsn64@gmail.com");
		password.sendKeys("Kkkkkqwww222");
		loginbutton.click();
	
	}
	
}
