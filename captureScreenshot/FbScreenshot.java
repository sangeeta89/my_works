package captureScreenshot;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import library.Utility;

public class FbScreenshot {
	@Test
	public void captureScreenshot() throws Exception{
		System.setProperty("webdriver.chrome.driver", "D:/jars/sele_jars/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/login/");
		Utility.captureScreenshot(driver, "screen1");
		Thread.sleep(1000);
		
		driver.findElement(By.id("email")).sendKeys("learn124");
		
		Utility.captureScreenshot(driver, "screen2");
		driver.quit();
	}
}
