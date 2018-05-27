/**
 * 
 */
package Amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * @author Sangeeta
 *
 */
public class VerifyFlipkartLogin 
{
	@Test
	public void VerifyLogin()throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:/jars/sele_jars/chrome_32/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(1000);
		LoginFlip log=new LoginFlip(driver);
		
		log.login();
		driver.quit();
	}
	
}
