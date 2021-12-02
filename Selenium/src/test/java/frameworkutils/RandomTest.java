package frameworkutils;

import java.util.Calendar;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

public class RandomTest {
	
	@Test
	public void test(){
		System.out.println("Random Alphanumeric: "+RandomStringUtils.randomAlphanumeric(10));
		System.out.println("Random Ascii: "+RandomStringUtils.randomAscii(10));
		System.out.println("Random Numeric: "+RandomStringUtils.randomNumeric(10));
		System.out.println("Random Number : "+RandomStringUtils.random(10, "akpsh"));
		System.out.println("Random Number : "+RandomStringUtils.randomAlphabetic(10));
		
	}
	
	@Test
	public void getRandomwithDate(){
		Calendar date=Calendar.getInstance();
//		System.out.println(date);
		String day=String.valueOf(date.get(Calendar.DAY_OF_MONTH));
		String month=String.valueOf(date.get(Calendar.MONTH)+1);
		String year=String.valueOf(date.get(Calendar.YEAR));
		
		if(day.length()==1){
			day="0"+day;
		}
		if(month.length()==1){
			month="0"+month;
		}
		
		String time=String.valueOf(date.get(Calendar.HOUR_OF_DAY))+String.valueOf(date.get(Calendar.MINUTE))+String.valueOf(date.get(Calendar.SECOND));
		System.out.println("Random Number generated with date : "+day+month+year+time);
	}

}
