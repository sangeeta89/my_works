package pageObjectModel.Testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Helper.BrowserFactory;
import pageObjectModel.Pages.LoginPageNew;

public class VerifyValidLogin 
{

	@Test
	public void checkValidUser()
	{
		WebDriver driver=BrowserFactory.startBrowser("chrome","https://www.facebook.com/login/" );
		LoginPageNew loginpage= PageFactory.initElements(driver, LoginPageNew.class);
		loginpage.login_fb("sangeeta.sen28", "kuoooo12");
	
	}			
	
}
