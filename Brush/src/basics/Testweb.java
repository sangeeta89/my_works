package basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testweb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\705877\\OneDrive - Cognizant\\Documents\\tools\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/java/");
		driver. manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		
		driver.close();
		
		
	}

}
