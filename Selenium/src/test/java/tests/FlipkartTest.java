package tests;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
//import io.github.bonigarcia.wdm.WebDriverManager;
import pages.FlipkartPages;

public class FlipkartTest {


	static WebDriver driver=null;
//	private static String browser="chrome";
//	SoftAssert softassert = new SoftAssert();
	

		public static void setup() throws Exception {
/*			
			if(browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().driverVersion("83.0.478.37").setup();
				driver=new EdgeDriver();
			}
			else if (browser.equalsIgnoreCase("chrome"))
			{	
				ChromeOptions chromeOptions = new ChromeOptions();
				WebDriverManager.chromedriver().driverVersion("96.0.4664.45").setup();
				driver=new ChromeDriver();
//				driver=new ChromeDriver(new ChromeDriverService.Builder().usingPort(65530).build());
			}
*/
//			System.setProperty("webdriver.chrome.driver","D:/jars/sele_jars/chrome/chromedriver.exe");
//			driver=new ChromeDriver();
			System.setProperty("webdriver.edge.driver","D:/jars/sele_jars/edge/msedgedriver.exe");
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.flipkart.com");
			System.out.println("Main page title:"+driver.getTitle());
			
		}
		public static void flipkartsearch() throws Exception {
			setup();
			FlipkartPages.loginpopup(driver).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			(new WebDriverWait(driver, 10))
					   .until(ExpectedConditions.elementToBeClickable(FlipkartPages.searchbox(driver)));
			FlipkartPages.searchbox(driver).sendKeys("iphone 13");
			
			String parentWin=driver.getWindowHandle();
	     	System.out.println(parentWin);
			
	     	FlipkartPages.srchbutton(driver).click();
	     	
//			List<WebElement> products=driver.findElements(By.cssSelector("div._4rR01T")); 
			FlipkartPages.products(driver);

			for(int i=0;i< FlipkartPages.products(driver).size();i++){

				FlipkartPages.products(driver).get(i);
				
				String text=FlipkartPages.products(driver).get(i).getText();
								
				if(text.equalsIgnoreCase("APPLE iPhone 13 (Blue, 512 GB)"))

					{	
						FlipkartPages.products(driver).get(i).click();
					}
					System.out.println("Product Found-" +FlipkartPages.products(driver).get(i).getText());
					Set<String> allwindows=driver.getWindowHandles();
					for(String childWin: allwindows) {
						
						if(!parentWin.equals(childWin)){
						
							System.out.println("Child win " +childWin);
							driver.switchTo().window(childWin);
							try{
								FlipkartPages.addcart(driver);
//								WebDriverWait wait=new WebDriverWait(driver,10);
//								wait.until(((WebElement) ExpectedConditions.presenceOfElementLocated(FlipkartPages.addcart(driver)).
									System.out.println(FlipkartPages.productdetail(driver).getText());
//									System.out.println(FlipkartPages.cart(driver).getText());
							}catch(NoSuchElementException e){ 
								e.printStackTrace();}
						}//if window loop
					}//inner for
				}//outer for loop
			teardown();
		
	}
	public static void teardown() {
			//			driver.switchTo().defaultContent();
			driver.quit();
			
		}
	

	public static void main(String[] args) throws Exception {
		FlipkartTest.flipkartsearch();
	}

}

