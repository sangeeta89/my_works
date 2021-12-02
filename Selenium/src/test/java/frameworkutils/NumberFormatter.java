package frameworkutils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class NumberFormatter {

	@Test
	public void test(){

		String originalAmount="$ 10,8213.8912/-";
		String replacedAmt=originalAmount.replaceAll("[\\$,/-]", "");
		System.out.println("Parsed digit for "+originalAmount+" = "+Double.parseDouble(replacedAmt));
	}
	
	@Test
	public void getChars(){
		System.out.println("812kasdad .aasd231 23".replaceAll("[^a-z.]", ""));
	}
	
	@Test
	public void getDigits(){
		System.out.println("812kasdad .aasd231 23".replaceAll("[^0-9.]", ""));
	}
	
	@Test
	public void getSpecificMatch(){
		Pattern p=Pattern.compile("([0-9]+(.[0-9]+)?)");
		
		Matcher m=p.matcher("sdss33.11jasjkjk9787"); 
		
		if(m.find()){
			System.out.println("First specific match found: "+m.group(1));
		}
		if(m.find()){
			System.out.println("Second specific match found : "+m.group(1));
		}
		
		
	}
}
