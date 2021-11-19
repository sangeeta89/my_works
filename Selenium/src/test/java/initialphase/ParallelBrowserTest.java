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


public class ParallelBrowserTest {



		public static WebDriver driver;
		public static String browser="edge";
		

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
				else{
					//If no browser passed throw exception
					throw new Exception("Browser is not correct");
				}
			
			//	System.setProperty("webdriver.chrome.driver","C:/Users/705877/OneDrive - Cognizant/Documents/tools/chromedriver_win32/chromedriver.exe");		
				driver.manage().window().maximize();
				driver.get("https://www.flipkart.com/");
				System.out.println(driver.getTitle());
			}
		
		void addfunctions() throws Exception{
				
				WebElement loginpopup=driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
				loginpopup.click();
				
				driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);			
				WebElement srcbar=driver.findElement(By.xpath("//input[@class='_3704LK']"));
				srcbar.click();
				srcbar.sendKeys("Iphone 12 pro max mobile");
				srcbar.submit();
				/*Xpath axes contains*/
				driver.findElement(By.xpath(".//*[contains(text(),'APPLE iPhone 12 Pro Max (Pacific Blue, 128 GB)' )]")).click();
				driver.manage().timeouts().implicitlyWait(4, TimeUnit.MINUTES);
				TakesScreenshot shot=((TakesScreenshot)driver);
				File srcfile=shot.getScreenshotAs(OutputType.FILE);
				File desfile=new File("C:/Users/705877/screenshot.jpg");

	            FileUtils.copyFile(srcfile, desfile);
				Thread.sleep(5000);
				
				
			}	 
				
				/*Catogry Mobiles*/
				/*
				WebElement mob=driver.findElement(By.xpath("//p[text()='Mobiles']"));
				mob.click();
				System.out.println(driver.getCurrentUrl());
				 */
				
				//WebElement sort=driver.findElement(By.xpath("//div[text()='Price -- Low to High']"));
				//sort.click();
				/*
				WebElement nav=driver.findElement(By.xpath("//a[@class='_1LKTO3']//span[text()='Next']"));
				js.executeScript("argument[0].scrollIntoView();",nav);
				nav.click();
				*/
				/*Category FLight*/
				/*
				WebElement catfl=driver.findElement(By.xpath("//p[text()='Flights']"));
				catfl.click();
				System.out.println(driver.getCurrentUrl());
				WebElement radiolist=driver.findElement(By.xpath("//input[@name='tripTypeList'][1]"));
				radiolist.click();
				Thread.sleep(4000);
				
				WebElement destfrom=driver.findElement(By.xpath("//input[@name='0-departcity']"));
				destfrom.sendKeys("MAA");
				WebElement desto=driver.findElement(By.xpath("//input[@name='0-arrivalcity']"));
				desto.sendKeys("DEL");
				*/
			

			void teardown() {
				driver.quit();
				
			}
		

		public static void main(String ar[]) throws Exception {
			ParallelBrowserTest ob=new ParallelBrowserTest();
			ob.setup();
			ob.addfunctions();
			ob.teardown();
		}

	}

