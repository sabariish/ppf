package qa.af.bdd.stepdef;

import org.testng.annotations.Test;

import com.qmetry.qaf.automation.step.WsStep;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
public class ChromeBrowser {

	
	@Test
	public void test ()
	{
		new WebDriverTestBase().getDriver().get("http://www.google.com");
		WsStep.userRequests("sample.reqwithbody1");
		WsStep.responseShouldHaveStatusCode(200);
		
		
	}
}
