package qa.af.bdd.stepdef;

import com.qmetry.qaf.automation.step.WsStep;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SampleBDDTestStepDefinitions {

	@When("{string} is entered in the google search box")
	public void is_entered_in_the_google_search_box(String string) {
		//new WebDriverTestBase().getDriver().get("http://www.google.com");
	
	}
	
	@Then("search pages opens with results")
	public void search_pages_opens_with_results() {
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new io.cucumber.java.PendingException();
		WsStep.userRequests("sample.reqwithbody1");
		WsStep.responseShouldHaveStatusCode(200);
	}
	
	@Then("all the search items contain atleast one occurrence of the {string}")
	public void all_the_search_items_contain_atleast_one_occurrence_of_the(String string) {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
}
