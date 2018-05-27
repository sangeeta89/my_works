package selenium_intQ;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import Helper.BrowserFactory;

public class MouseEvent {
	static WebDriver driver;
    public static void main(String[] args) throws Exception {
      
        BrowserFactory.startBrowser("chrome", "http://demo.guru99.com/test/newtours/");
                Thread.sleep(1000);
                WebElement link_Home = driver.findElement(By.linkText("Home"));
                WebElement td_Home = driver.findElement(By
                        .xpath("//html/body/div"
                        + "/table/tbody/tr/td"
                        + "/table/tbody/tr/td"
                        + "/table/tbody/tr/td"
                        + "/table/tbody/tr"));    
                 
                Actions builder = new Actions(driver);
                Action mouseOverHome = builder
                        .moveToElement(link_Home)
                        .build();
                 
                String bgColor = td_Home.getCssValue("background-color");
                System.out.println("Before hover: " + bgColor);        
                mouseOverHome.perform();        
                bgColor = td_Home.getCssValue("background-color");
                System.out.println("After hover: " + bgColor);
                driver.close();
        }
}