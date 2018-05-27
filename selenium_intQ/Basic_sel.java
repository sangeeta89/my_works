package selenium_intQ;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Basic_sel {
	
	static WebDriver driver;	
	
	public boolean alerting(){
		try{
			driver.switchTo().alert();
			return true;
		} catch(Exception e){
			System.out.println("Exception occured");
			return false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver","D:/jars/sele_jars/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.google.co.in/");
		System.out.println("kjkkj");
		driver.quit();
//		Alert test=driver.switchTo().alert();
//		System.out.println(test.getText());
		
	}
}
