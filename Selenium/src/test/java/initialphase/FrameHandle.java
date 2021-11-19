package initialphase;

import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandle {

	public WebDriver driver;
	
	public void startup() {
		
			System.setProperty("webdriver.chrome.driver","D:/jars/sele_jars/chromedriver.exe");		
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.toolsqa.com/iframe-practice-page/");
			System.out.println(driver.getTitle());
	}
	public void iHandle()  {
		try {
			driver.switchTo().frame("iframe1");
		}catch(NoSuchFrameException e) {
			System.out.println("Handled NoSuchFrameException");
		}
	}
	public void teardown() {
		driver.close();
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FrameHandle fh=new FrameHandle();
		fh.startup();
		fh.iHandle();
		fh.teardown();
		
	}

}
