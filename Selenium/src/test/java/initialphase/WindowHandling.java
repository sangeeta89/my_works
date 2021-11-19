package initialphase;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {

	public static WebElement product = null;
	public static List<WebElement> products = null;
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
		
		//	System.setProperty("webdriver.chrome.driver","C:/Users/705877/OneDrive - Cognizant/Documents/tools/chromedriver_win32/chromedriver.exe");		
			driver.manage().window().maximize();
			driver.get("https://www.flipkart.com/");
			System.out.println("Main page title:"+driver.getTitle());
		}
	

	void addfunctions() {
//		try{
	
			WebElement loginpopup=driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
			loginpopup.click();
			WebElement searchbox=driver.findElement(By.xpath("//*[contains(@title,'Search')]"));
			searchbox.sendKeys("iphone 13");
//			String parentWin=driver.getWindowHandle();
//	     	System.out.println(parentWin);
			WebElement srchbutton=driver.findElement(By.xpath("//form/div/button[@class='L0Z3Pu']"));
			srchbutton.click();
			List<WebElement> products=driver.findElements(By.cssSelector("div._4rR01T")); 
//			System.out.println(count);
			for(int i=0;i< products.size();i++){

				WebElement product=products.get(i);
				
				String text=product.getText();
								
				if(text.equalsIgnoreCase("APPLE iPhone 13 (Blue, 512 GB)"))

				{	products.get(i).click();
					System.out.println("Product Found" +products.get(i).getText());
					for(String handle:driver.getWindowHandles()) {
						 System.out.println("Child win " +handle);
						 driver.switchTo().window(handle);
	
						WebElement addtocartbtn=driver.findElement(By.xpath("//*[@class='_2KpZ6l _2U9uOA _3v1-ww']"));
						WebDriverWait wait=new WebDriverWait(driver,10);
						wait.until(ExpectedConditions.visibilityOf(addtocartbtn)).click();
						if(addtocartbtn.isDisplayed()==false){
							WebElement proddetail=driver.findElement(By.xpath("//div[@class='_16FRp0']"));
							System.out.println(proddetail.getText());
							
						}//inner if
					}//inner for
				}//outer if
				
			}//outer for
			driver.close();
			driver.switchTo().defaultContent();
		}
//	        Robot robot = new Robot();
// Scroll Down using Robot class
//	        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
//	        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
//	        
//			System.out.println("Scrolling");
//			List<WebElement> getDetails = driver.findElements(By.xpath("//div[@class='_3dtsli']/descendant::div"));
//			for (int i=0; i<getDetails.size();i++){
//			      System.out.println("Specifications :" + getDetails.get(i).getText());
//			      System.out.println("Jumped to element");
//			    }

		void teardown() {
			driver.quit();
			
		}
	

	public static void main(String ar[]) throws Exception {
		WindowHandling ob= new WindowHandling();
		ob.setup();
		ob.addfunctions();
		ob.teardown();
	}

}

