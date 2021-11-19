package webAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class RunstepDefine {
public WebDriver driver;

	
	@Given("The webpage is launched")
	public void the_webpage_is_launched() {
		
			System.setProperty("webdriver.chrome.driver","C:/Users/705877/OneDrive - Cognizant/Documents/tools/chromedriver_win32/chromedriver.exe");		
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.freshtohome.com/");
			System.out.println(driver.getTitle());
			
			driver.findElement(By.xpath("//a[text()='Tamil Nadu']")).click();
			throw new io.cucumber.java.PendingException();
	}
	
	
	@When("I click on item")
	public void i_click_on_item()  {	
			WebElement srcbar=driver.findElement(By.name("q"));
			srcbar.click();
			srcbar.sendKeys("Bhetki");
			srcbar.submit();
			throw new io.cucumber.java.PendingException();
	}
	
	
	@Then("Item is added to cart")
	public void item_is_added_to_cart() throws Throwable{
			driver.findElement(By.xpath("//h3[contains(text(),'Bhetki')]/following::span[contains(text(),'329')]")).click();
	}
	
	
	@And("Verify the item")
	public void verify_the_item() throws Throwable{
		
			if(driver.getTitle().contains("Bhetki / ভেটকী / Barramundi / Asian Seabass / Kalanji / கொடுவா : Buy online | freshtohome.com")) {
				System.out.println(driver.getTitle());
			}//end of inner if
			
			Thread.sleep(2000);

			driver.findElement(By.className("menu-cart-icon")).click();
			driver.quit();
	}
	
}