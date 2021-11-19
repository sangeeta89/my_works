package initialphase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathAxes {
	public WebDriver driver;
		public void axes() {
			
				System.setProperty("webdriver.chrome.driver","D:/jars/sele_jars/chrome/chromedriver.exe");		
				driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://www.freshtohome.com/");
				System.out.println(driver.getTitle());
				
				//self:: xpath axes
				String city= driver.findElement(By.xpath("//div[@id='cityModal']/self::*")).getText();
				System.out.println("Self node: "+city);
				
				//child:: xpath
				List<WebElement> cityNum=driver.findElements(By.xpath("//div[@id='cityModal']/child::*"));
				System.out.println("Child Axes- No of child nodes in city ::" +cityNum.size());
				
				
				//descendant::
				List<WebElement> cityList=driver.findElements(By.xpath("//div[@id='cityModal']/child::div[2]/descendant::*"));
				System.out.println("Descendant Axes - No. of cities: "+cityList.size());
				
				city=driver.findElement(By.xpath("//div[@id='cityModal']/child::div[2]/descendant::a[text()='Tamil Nadu']")).getText();
				System.out.println("Descendant Node - Selected city: "+city);
				
				//parent ::
				String country=driver.findElement(By.xpath("//a[@id='AE']/parent::*")).getText();
				System.out.println("Parent Axes -  Country :"+country);
				
				//ancestor::
				country=driver.findElement(By.xpath("//a[@id='AE']/ancestor::div[2]")).getAttribute("class");
				System.out.println("Ancestor - Country: "+country);
				
				//Preceding::
				cityList=driver.findElements(By.xpath("//a[@id='AE']/preceding::*"));
				System.out.println("Preceding - City List: "+cityList.size());
				
				//Preceding::
				city=driver.findElement(By.xpath("//a[@id='AE']/preceding::a[@id=7]")).getText();
				System.out.println("Preceding - selected city list:"+city);
	
		
				//Preceding-sibling::
				cityList=driver.findElements(By.xpath("//a[@id='7']/parent::li/preceding-sibling::*"));
				System.out.println("Preceding-sibling - Preceding Cities: "+cityList.size());
		
				
				city=driver.findElement(By.xpath("//a[@id='7']/parent::li/preceding-sibling::li/child::a[@id='14']")).getText();
				System.out.println("Preceding-sibling- selected city:"+city);
				
				//Following-sibling ::
				cityList=driver.findElements(By.xpath("//a[@id='14']/parent::li/following-sibling::*"));
				System.out.println("Following-sibling - List of cities:"+cityList.size());
				
				
				//Following
				cityList=driver.findElements(By.xpath("//a[text()='Bangalore']/following::li"));
				System.out.println("Following - List of cities: "+ cityList.size());
				
		}

	public void BuyFish() throws Exception {
			
			WebElement city=driver.findElement(By.xpath("//a[text()='Bangalore']/following::li/child::a[text()='Tamil Nadu']"));
			city.click();
			city.toString();
			
			String selcity=driver.findElement(By.xpath("//span[@id='currentCity']")).getText();
			if(selcity.equals("Chennai")) {
				System.out.println("City matched: "+selcity);
				
				List<WebElement> navList=driver.findElements(By.xpath("//ul[@id='nav']/descendant::span"));
				System.out.println("Nav List "+navList.size());
				WebElement fish=driver.findElement(By.xpath("//ul[@id='nav']/descendant::span[text()='Fish & Seafood']"));
				fish.toString();
				for (int i=0; i<navList.size();i++){
									
						System.out.println("Element found:" +navList.get(i).getText());
				}
				driver.findElement(By.xpath("//li[@class='level0 fish']")).click();

						
				System.out.println("FISH found");
				WebElement item=driver.findElement(By.xpath("//div[@class='product-shop']/h3[text()='Indian Prawns / Venami / Vannamei / Jhinga / Chemmin (60+ Count/kg)']"));
				System.out.println(item.getText());
				item.click();
				driver.findElement(By.xpath("//button[contains(text(),'Add to Cart')]")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//div[@class='menu-cart-icon']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[contains(text(),'My Cart')]")).click();
				checkout();
			}
	}
		public void checkout() throws Exception {
			String cartItems=driver.findElement(By.xpath("//tbody")).getText();
			System.out.println("Cart items: "+cartItems);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@class='totals']/ul/li/child::button")).click();
			String cart=driver.findElement(By.className("checkout")).getText();
			System.out.println(cart);
		}
		public void tearout() {

			driver.close();
		}
	
	public static void main(String[] args) throws Exception {

		XpathAxes obj=new XpathAxes();
		obj.axes();
		obj.BuyFish();
		obj.tearout();
		
	}

}
