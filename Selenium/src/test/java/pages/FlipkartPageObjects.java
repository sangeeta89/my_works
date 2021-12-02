package pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartPageObjects {
	private static WebDriver driver=null;

	By loginpopup=By.xpath("//button[@class='_2KpZ6l _2doB4z']");
	By searchbox=By.xpath("//*[contains(@title,'Search')]");
	By searchbtn=By.xpath("//form/div/button[@class='L0Z3Pu']");
	By products=By.cssSelector("div._4rR01T");
	By addtocartbtn=By.xpath("//*[@class='_2KpZ6l_2U9uOA _3v1-ww']");
	By proddetail=By.xpath("//div[@class='_1AtVbE col-12-12']"); //div[@class='_16FRp0']");
	By cart= By.xpath("//div[@class='_1dVbu9']");

	public FlipkartPageObjects(WebDriver driver){
		FlipkartPageObjects.driver=driver;
	}

	public void loginpopup(){
		driver.findElement(loginpopup).sendKeys(Keys.RETURN);
	}	
	public void setsearchtext(String text){
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(searchbox)).sendKeys(text);

	}
	public void searchbtn(){
		driver.findElement(searchbtn).sendKeys(Keys.RETURN);
	}
	public List<WebElement> products(String expectedtext){
		String parentWin=driver.getWindowHandle();
		System.out.println(parentWin);
		List<WebElement> productlist=driver.findElements(products);	
		int count=productlist.size();

		for (int i=0; i<count; i++) {
			productlist.get(i);
			String txt=productlist.get(i).getText();
			if(txt.equalsIgnoreCase(expectedtext)){

				productlist.get(i).click();

				System.out.println("Product Found -" +productlist.get(i).getText());
				Set<String> allwindows=driver.getWindowHandles();
				for(String childWin: allwindows) {

					if(!parentWin.equals(childWin)){

						System.out.println("Child win " +childWin);
						driver.switchTo().window(childWin);
						productdetail();
						
					}
				}
			}
			/*
			else {
				
				driver.quit();
			}*/

		}	
		driver.switchTo().defaultContent();
		return productlist;
	}

	public void addcart(){
		driver.findElement(addtocartbtn);
	}
	public void productdetail(){
		try{
		driver.findElement(proddetail);
		}
		catch(StaleElementReferenceException e){
			WebElement det=driver.findElement(proddetail);
			String attribute=det.getAttribute("value");
			System.out.println("Actual attribute value is "+attribute);
			
		}
		
	}


}
