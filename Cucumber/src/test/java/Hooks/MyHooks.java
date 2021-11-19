package Hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class MyHooks {
	public WebDriver driver;
	@Before
	public void startup() {
		System.setProperty("webdriver.chrome.driver","C:/Users/705877/OneDrive - Cognizant/Documents/tools/chromedriver_win32/chromedriver.exe");		
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.freshtohome.com/");
		System.out.println(driver.getTitle());
		System.out.println("Launch browser");
	}
	
	@After
	public void teardown() {
		driver.quit();
		System.out.println("Close Browser");
	}

}
