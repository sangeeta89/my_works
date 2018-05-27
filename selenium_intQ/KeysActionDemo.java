package selenium_intQ;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import Helper.BrowserFactory;

public class KeysActionDemo {
	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//BrowserFactory.startBrowser("chrome", "https://www.facebook.com/");
		System.setProperty("webdriver.chrome.driver", "D:/jars/sele_jars/selenium3.11/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement usrname=driver.findElement(By.xpath("//*[@id='email']"));
		
		
		Actions act=new Actions(driver);
		Action seriesofAction=act
				.moveToElement(usrname)
				.click()
				.keyDown(usrname,Keys.SHIFT)
				.sendKeys("hallo")
				.keyUp(usrname, Keys.SHIFT)
				.doubleClick(usrname)
				.contextClick()
				.build();
		seriesofAction.perform();
		System.out.println("passed");
		driver.quit();
	}
}
