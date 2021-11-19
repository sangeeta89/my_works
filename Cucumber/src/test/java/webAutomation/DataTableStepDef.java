package webAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class DataTableStepDef {
	public WebDriver driver;
	
	@Before
	public void startup() {
		System.setProperty("webdriver.chrome.driver","C:/Users/705877/OneDrive - Cognizant/Documents/tools/chromedriver_win32/chromedriver.exe");		
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
	}
	
	@Given("Page already launched")
	public void pageAlreadyLaunched() {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("https://www.freshtohome.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//a[text()='Tamil Nadu']")).click();
		
	}

	@When("User click on login button")
	public void userClickOnLoginButton() {

		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log In")));
		WebElement loginbutton=driver.findElement(By.linkText("Log In"));
		loginbutton.click();
		
	}

	@And("User enters username and password")
	public void userEntersUsernameAndPassword(DataTable dataTable) {
		try {
		
		List<List<String>> dataValues=dataTable.cells();//raw() is changed to cells()
		
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("youama-email-phone")));
		driver.findElement(By.id("youama-email-phone")).sendKeys(dataValues.get(0).get(0));
		
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("youama-password")));
		driver.findElement(By.name("youama-password")).sendKeys(dataValues.get(0).get(1));
		
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.tagName("button")));
		driver.findElement(By.tagName("button")).click();
		
		}catch(ElementNotInteractableException e) {
			e.printStackTrace();
		}
	}
	@But("User should not see error")
	public void userShouldNotSeeError() {
		WebElement login=driver.findElement(By.xpath("//a[contains(text(),'Log In')]"));
		if(!login.isDisplayed()) {
			System.out.println("Pass"); }
	}
	@After
	public void teardown() {
		driver.quit();
	}
}
