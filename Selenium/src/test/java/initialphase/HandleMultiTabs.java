  package initialphase;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class HandleMultiTabs {
	public WebDriver driver;
	
	public void startup() {
		
			System.setProperty("webdriver.chrome.driver","D:/jars/sele_jars/chrome/chromedriver.exe");		
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.freshtohome.com/");
			System.out.println(driver.getTitle());
	}
	public void function() throws Exception{
//		WebElement city=driver.findElement(By.xpath("//a[text()='Bangalore']/following::li/child::a[text()='Tamil Nadu']"));
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement messageElement = wait.until(
		       ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Bangalore']/following::li/child::a[text()='Tamil Nadu']"))) ; 
//		city.click();
		messageElement.click();
		
		String selcity=driver.findElement(By.xpath("//span[@id='currentCity']")).getText();
		if(selcity.equals("Chennai")) {
			System.out.println("City matched: "+selcity);
			
			WebElement navList=driver.findElement(By.xpath("//div[@class='nav-container']"));
			System.out.println("Many elements:" +navList);
			
			
			System.out.println("Nav List "+navList.findElements(By.tagName("a")).size());

				for (int i=0; i<navList.findElements(By.tagName("a")).size();i++){
						String opentabs=Keys.chord(Keys.CONTROL,Keys.ENTER);	
						navList.findElements(By.tagName("a")).get(i).sendKeys(opentabs);
						
				}
				
				String mainWindow = driver.getWindowHandle();
				System.out.println("Main Parent window ID: "+mainWindow);
				
				Set<String> getHandles=driver.getWindowHandles();
				Iterator<String> it=getHandles.iterator();
				
				//Iterate through all windows
//				for(String childHandle:getHandles) {
				while(it.hasNext()==true) {
					
					String childHandle=it.next();
					System.out.println(driver.switchTo().window(childHandle));
					
					//checks if the parent window and child matches, if No ,switch to next window
					if(!mainWindow.equalsIgnoreCase(childHandle) && !driver.getTitle().equalsIgnoreCase("FreshToHome Home - Buy Fresh Fish, Chicken and Mutton Online.")) {
						
							System.out.println(driver.getTitle()+"\t\t\t" +"Childwindow ID :"+childHandle+"\n");
							
							if(driver.getTitle().equalsIgnoreCase("FreshToHome - Buy Fresh Fish Online")){
									
									WebElement srcbar=driver.findElement(By.name("q"));
									srcbar.click();
									srcbar.sendKeys("Bhetki");
									srcbar.submit();
									Thread.sleep(1000);
									driver.findElement(By.xpath("//h3[contains(text(),'Bhetki')]/following::span[contains(text(),'399')]")).click();
									Thread.sleep(1000);

									driver.findElement(By.xpath("//button[contains(text(),'Add to Cart')]")).click();
									Thread.sleep(1000);
									
//									if(driver.getTitle().contains("Bhetki / ভেটকী / Barramundi / Asian Seabass / Kalanji / கொடுவா : Buy online | freshtohome.com")) {
//										System.out.println(driver.getTitle());
//										Screenshot ts = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
//										try {
//											ImageIO.write(ts.getImage(), "jpg", new File("C:\\Users\\705877\\Screenshots\\screenshot.jpg"));
//										}catch (IOException e) {
//							                
//							                e.printStackTrace();
//										}
//
//									}//end of inner if
									
									driver.switchTo().window(childHandle);
									driver.getTitle();

							}//end of outer if
					}//end of outermost if
					
				}//end of while
				
				driver.close();
				driver.switchTo().window(mainWindow);
				WebElement ac=driver.findElement(By.xpath("//div[@class='camera_target']"));
				Actions act=new Actions(driver);
				act.moveToElement(ac).doubleClick().perform();
				System.out.println(driver.getTitle());
				
			}
		}
	
//			driver.findElement(By.xpath("//div[@class='menu-cart-icon']")).click();
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("//button[contains(text(),'My Cart')]")).click();
//			job();

	
	public void job() throws Exception {
			
			String cartItems=driver.findElement(By.xpath("//tbody")).getText();

			System.out.println("Cart items: "+cartItems);
			Thread.sleep(1000);

			//Get parent window
			 String parentWin=driver.getWindowHandle();
			 System.out.println("Parentwin: "+driver.getTitle());
			 
			
			//handle new tab
			 for(String handle:driver.getWindowHandles()) {
				 System.out.println("Child win " +handle);
				 driver.switchTo().window(handle);
			 }

			 driver.findElement(By.cssSelector("button.button ajcheckout btn-white")).click(); 
			 driver.switchTo().window(parentWin);
			//open link in New Tab

			String cart=driver.findElement(By.className("checkout")).getText();
			System.out.println(cart);
			
	}
	public void tearout() {
		driver.quit();
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		HandleMultiTabs mt=new HandleMultiTabs();
		mt.startup();
		mt.function();
		mt.tearout();
		

	}

}
