package steps;
import org.junit.Test;

import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.dsl.junit.JUnit4CitrusTestDesigner;

import utils.LoggingService;


public class JunitCitrusDesignerDemoIT extends JUnit4CitrusTestDesigner{

	LoggingService obj=new LoggingService();
	@Test
	@CitrusTest
	public void testLog() {
		echo("Before Log");
		obj.logs("----PRINT ACTUAL LOGS HERE----");
		echo("After Log");
	}
}
