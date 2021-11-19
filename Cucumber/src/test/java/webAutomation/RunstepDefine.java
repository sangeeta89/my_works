package webAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class RunstepDefine {
public WebDriver driver;

//	@Before
//	public void startup() {
//		System.setProperty("webdriver.chrome.driver","C:/Users/705877/OneDrive - Cognizant/Documents/tools/chromedriver_win32/chromedriver.exe");		
//		driver=new ChromeDriver();
//		driver.manage().deleteAllCookies();
//		driver.manage().window().maximize();
//	}
	

	@Given("The webpage is launched")
	public void the_webpage_is_launched() throws Throwable{
			driver.findElement(By.xpath("//a[text()='Tamil Nadu']")).click();
			new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Log In')]"))).click();
			
	}
	
	@When("I enter {string} and {string}")
	public void when_i_enter_credentials(String username, String password) throws Throwable{
			driver.findElement(By.id("youama-email-phone")).sendKeys(username);
			driver.findElement(By.name("youama-password")).sendKeys(password);
			driver.findElement(By.tagName("button")).click();
	}
	
	@Then("I logged into the application")
	public void i_logged_into_the_application() throws Throwable{
			String errMsg= driver.findElement(By.xpath("//div[@class='youama-ajaxlogin-error err-password err-dirtypassword err-nopassword err-longpassword err-inactive']")).toString();
			if(errMsg.contains("")){
				System.out.println("Logged successfully");
			}
			
	}
	

//		WebElement currentCity=driver.findElement(By.cssSelector("input#currentCity"));
//		WebDriverWait currentCity = new WebDriverWait(driver,30); 
//		currentCity.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#currentCity")));
//		System.out.println(currentCity);
			
	

	@When("I click on item")
	public void i_click_on_item() throws Throwable {	
			WebElement srcbar=driver.findElement(By.name("q"));
			srcbar.click();
			srcbar.sendKeys("Bhetki");
			srcbar.submit();
			
	}
	
	@Then("Item is added to cart")
	public void item_is_added_to_cart() throws Throwable{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[contains(text(),'Bhetki')]/following::span[contains(text(),'₹329.00')]")).click();
			
	}
	
	
	@And("Verify the item")
	public void verify_the_item() throws Throwable{
		
			if(driver.getTitle().contains("Bhetki / ভেটকী / Barramundi / Asian Seabass / Kalanji / கொடுவா : Buy online | freshtohome.com")) {
				System.out.println(driver.getTitle());
			}//end of inner if
			
			Thread.sleep(2000);
			driver.findElement(By.className("menu-cart-icon")).click();
						
	}
	
//	@After
//	public void teardown() {
//		driver.quit();
//	}
	
	
}