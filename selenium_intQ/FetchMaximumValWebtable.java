package selenium_intQ;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import Helper.BrowserFactory;

public class FetchMaximumValWebtable {
	
	static ArrayList<String> list = new ArrayList<String>(); 
	static WebDriver driver;
	
	public static ArrayList<Double> getDoubleArray(ArrayList<String> stringArray) {
        
		ArrayList<Double> result = new ArrayList<>();
        
		for(String stringValue : stringArray) {
            try {
                //Convert String to Integer, and store it into integer array list.
                result.add(Double.parseDouble(stringValue));
            } catch(Exception e) {
               //System.out.println("Could not parse " + nfe);
                System.out.println("The string contains text so that it cannot be converted as integer");
            } 
        }       
        return result;
    }
	
	public static void main(String[] args) throws ParseException {
		
		double maximum=0,value=0;
		
		String price;
		BrowserFactory.startBrowser("chrome", "https://money.rediff.com/gainers/bse/daily/groupa");
		
 		List<WebElement> rows = driver.findElements(By.xpath("//div[@id='leftcontainer']/table[@class='dataTable']/tbody/tr")); 
		System.out.println(rows.size());
		for(int i=1;i<=rows.size();i++) {
			
        String company = driver.findElement(By.xpath("/html/body/div[@id='wrapper']/div[@id='leftcontainer']/table[@class='dataTable']/tbody/tr["+i+"]/td[1]")).getText();

        price = driver.findElement(By.xpath("/html/body/div[@id='wrapper']/div[@id='leftcontainer']/table[@class='dataTable']/tbody/tr["+i+"]/td[4]")).getText();
        
        list.add(price);
        
        NumberFormat format =NumberFormat.getNumberInstance(); 
        
        Number num = format.parse(price);
        
        price = num.toString();
        
        maximum = Double.parseDouble(price);
        
        if(maximum>value)
         {    
        	value=maximum;
         }

       System.out.println(company+" : "+price);
              

		}
		
		System.out.println("Maximum current price is : "+value);
		
		
	}

}