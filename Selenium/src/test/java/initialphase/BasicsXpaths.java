package initialphase;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import org.apache.commons.io.FileUtils;


public class BasicsXpaths {
	public static WebDriver driver;
	public static String browser="chrome";
	

		void setup() throws Exception {
			
			if(browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
			}
			else if (browser.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
			}
			else if (browser.equalsIgnoreCase("Firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
			}

		
		//	System.setProperty("webdriver.chrome.driver","D:/jars/sele_jars/chrome/chromedriver.exe");		
			driver.manage().window().maximize();
			driver.get("https://www.flipkart.com/");
			System.out.println(driver.getTitle());
		}
	
	void addfunctions() throws Exception{
			
			WebElement loginpopup=driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
			loginpopup.click();
			
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);	
			
			WebElement srcbar=driver.findElement(By.xpath("//input[@class='_3704LK']"));
			srcbar.sendKeys("Iphone 12 pro max mobile");
			srcbar.submit();
			String pw=driver.getWindowHandle();
			//iterate 
			for(String cw:driver.getWindowHandles())
			{
				driver.switchTo().window(cw);
						/*Xpath axes contains*/
					driver.findElement(By.xpath(".//*[contains(text(),'APPLE iPhone 12 Pro Max (Pacific Blue, 128 GB)' )]")).click();
					TakesScreenshot shot=((TakesScreenshot)driver);
					File srcfile=shot.getScreenshotAs(OutputType.FILE);
					File desfile=new File("D:/TakeScreenshots/screenshot.jpg");
		
		            FileUtils.copyFile(srcfile, desfile);
		            System.out.println("Child window title: "+driver.getTitle());
					
			}
			driver.switchTo().window(pw);
			srcbar.sendKeys("sony a6400 camera");
			srcbar.submit();
			driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);
			
			System.out.println("Parent window title: "+driver.getTitle());
			driver.close();
		}	 

		
		void teardown() {
			driver.quit();
			
		}
	

	public static void main(String ar[]) throws Exception {
		BasicsXpaths ob= new BasicsXpaths();
		ob.setup();
		ob.addfunctions();
		ob.teardown();
	}

}

