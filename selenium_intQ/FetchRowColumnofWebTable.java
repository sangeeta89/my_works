/**
 * 
 */
package selenium_intQ;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Sangeeta
 *
 */
public class FetchRowColumnofWebTable {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception
	{
	
		System.setProperty("webdriver.chrome.driver", "D:/jars/sele_jars/chrome_32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
		//No. of Columns
		WebElement basetable=driver.findElement(By.tagName("table"));
		WebElement tableRow = basetable.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[1]"));
        String rowtext = tableRow.getText();
		System.out.println("First row of table : "+rowtext);

		WebElement tableRow1 = basetable.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[2]"));
        String rowtext1 = tableRow1.getText();
		System.out.println("Second row of table : "+rowtext1);
		
		WebElement cellIneed = tableRow.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[3]/td[2]"));
		String valueIneed = cellIneed.getText();
		System.out.println("Cell value is : " + valueIneed); 	 
			 
		WebElement col=driver.findElement(By.xpath(".//*[@id='leftcontainer']/table/thead/tr/th"));
		System.out.println("Number of column:" +col.getSize());
		
		//No. of Rows
		WebElement row=driver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("No. of rows:"+row.getSize());
		driver.quit();

	}

}