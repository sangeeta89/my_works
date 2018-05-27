/**
 * 
 */
package pageObjectModel.Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pageObjectModel.Pages.LoginPage;

/**
 * @author Sangeeta
 *
 */
public class VerifyFblLogin {
	
	@Test
	public void verifyValidLogin() throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sangeeta\\Desktop\\New folder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/login/");
		Thread.sleep(1000);
		
		LoginPage login=new LoginPage(driver); 	
		
		login.typeUsername();
		login.typePassword();
		login.loginsubmit();
		driver.quit();
	}
	
}
