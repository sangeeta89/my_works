package initialphase;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebdriverManagerDemo {
	static WebDriver driver;

	public void manage() {
		driver.get("https://www.freshtohome.com/");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//a[text()='Bangalore']/following::li/child::a[text()='Tamil Nadu']")));

		messageElement.click();

		String mainWindow = driver.getWindowHandle();
		System.out.println("Main Parent window ID: " + mainWindow);

		Set<String> getHandles = driver.getWindowHandles();
		Iterator<String> it = getHandles.iterator();
		while (it.hasNext() == true) {

			String childHandle = it.next();
			System.out.println(driver.switchTo().window(childHandle));

			wait = new WebDriverWait(driver, 5);
			// CSS selector using prefix
			driver.findElement(By.cssSelector("input[placeholder^='E-m']")).click();
			wait = new WebDriverWait(driver, 5);

			// CSS selector using suffix
			driver.findElement(By.cssSelector("input[name$='email-phone']")).click();

			// CSS selector using contains
			driver.findElement(By.cssSelector("input[name*='email-phone']")).click();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		WebdriverManagerDemo wd = new WebdriverManagerDemo();
		wd.manage();
		driver.close();

	}
	//Ctr+Shifty+F =format teh indexing of program
}
