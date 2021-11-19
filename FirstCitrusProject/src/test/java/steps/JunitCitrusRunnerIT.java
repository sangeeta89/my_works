package steps;

import org.junit.Test;

import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.dsl.junit.JUnit4CitrusTestRunner;


public class JunitCitrusRunnerIT extends JUnit4CitrusTestRunner{
	@Test
	@CitrusTest
	public void sayHello() {
		echo("Test case-1");
	}
		
	@Test
	@CitrusTest
	public void sayDateFromJunit() {
		variable("nowdate","citrus:currentDate()");
		echo("Test case-2");
		echo("Today's date is : $(nowdate)");
	}
	
	

}

