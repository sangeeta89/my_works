package initialphase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MultipleAction {
	public WebDriver driver;
	
	public void startup() {
		//	driver=new WebDriver(); // Cannot instantiate object of an Interface(Webdriver)
			System.setProperty("webdriver.chrome.driver","D:/jars/sele_jars/chrome/chromedriver.exe");		
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.freshtohome.com/");
			System.out.println("Browser starts");
//			System.out.println(driver.getTitle());
//			System.out.println(driver.getPageSource());
	}
	public void action() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement messageElement = wait.until(
		       ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Bangalore']/following::li/child::a[text()='Tamil Nadu']"))) ; 

		messageElement.click();
		
		String selcity=driver.findElement(By.xpath("//span[@id='currentCity']")).getText();
		if(selcity.equals("Chennai")) {
			System.out.println("City matched: "+selcity);
			driver.findElement(By.xpath("//li[@class='level0 poultry']")).click();
			
			//Test action  when locating element that has more than 1 matching element 
			WebElement ele=driver.findElement(By.xpath("//ul[@class='products-grid']"));
			wait.until(ExpectedConditions.visibilityOf(ele));
			System.out.println(ele.getText());
			ele.click();
		}

		driver.navigate().to("https://www.freshtohome.com/all-products/");
		//Radio
//		WebElement rad1=driver.findElement(By.cssSelector("//input[id='yesRadio']"));
//		Boolean radSelected=rad1.isSelected();
		//Dropdown 
		Select drpSort=new Select(driver.findElement(By.xpath("//*[text()='Sort By']/following::select")));
		
		drpSort.selectByVisibleText("Price - Low to High");
		
		//Unable to locate selctByIndex, selectByValue,selectByvisibletext -Exception in thread "main" org.openqa.selenium.StaleElementReferenceException: stale element reference: element is not attached to the page document 
//		drpSort.selectByIndex(0);
//
//		drpSort.selectByVisibleText("Price - High to Low");
//		drpSort.selectByIndex(1);
		
		
		}
	public void checkboxdemo() {
		driver.get("https://www.demoqa.com/automation-practice-form");
		System.out.println(driver.getTitle());
		WebElement chckbox1=driver.findElement(By.xpath("//label[text()='Sports']"));
		Boolean isDisplay=chckbox1.isDisplayed();
		if(isDisplay==true) {
			WebDriverWait wait=new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.elementToBeClickable(chckbox1));
			Boolean isSelect=chckbox1.isSelected();
			if(isSelect==true) {
				System.out.println(chckbox1+"is selected");
				
			}
			
		}

	
	}
	public void teardown() {
		driver.quit();
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		MultipleAction ob=new MultipleAction();
		ob.startup();
		ob.action();
//		ob.checkboxdemo();
		ob.teardown();

	}

}
