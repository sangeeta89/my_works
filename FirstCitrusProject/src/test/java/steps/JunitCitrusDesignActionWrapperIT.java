package steps;

import org.junit.Test;

import com.consol.citrus.actions.AbstractTestAction;
import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.context.TestContext;
import com.consol.citrus.dsl.junit.JUnit4CitrusTestDesigner;

import utils.LoggingService;


public class JunitCitrusDesignActionWrapperIT extends JUnit4CitrusTestDesigner{

	LoggingService obj=new LoggingService();
	@Test
	@CitrusTest
	public void testLog() {
		echo("Before Log");
		
		action(new AbstractTestAction() {
			@Override
			public void doExecute(TestContext context) {
				obj.logs("----PRINT ACTUAL LOGS HERE----");
			}

		});
		
		echo("After Log");
	}
}
