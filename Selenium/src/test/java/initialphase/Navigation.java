package initialphase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigation {
	public static WebDriver driver;
	
	void startup() {
		System.setProperty("webdriver.chrome.driver","D:/jars/sele_jars/chrome/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.swiggy.com/");
		
	}
	void navigatebackforth() {
		driver.navigate().forward();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
