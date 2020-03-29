package qa.af.dbb.runner;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import com.qmetry.qaf.automation.core.ConfigurationManager;

import qa.af.bdd.stepdef.ChromeBrowser;

public class TestRunner {

	/*
	 * public static void main(String[] args) {
	 * 
	 * Object test = ConfigurationManager.getBundle().getProperty("TestClass");
	 * 
	 * TestListenerAdapter tla = new TestListenerAdapter(); TestNG testng = new
	 * TestNG(); testng.setTestClasses(new Class[] { ChromeBrowser.class});
	 * testng.addListener(tla); testng.run(); }
	 */
	
	public static void main(String[] args) {
		 
		// Create object of TestNG Class
		TestNG runner=new TestNG();
		 
		// Create a list of String 
		List<String> suitefiles=new ArrayList<String>();
		 
		// Add xml file which you have to execute
		suitefiles.add("./src/main/resources/testng-config/testrun2.xml");
		 
		// now set xml file for execution
		runner.setTestSuites(suitefiles);
		 
		// finally execute the runner using run method
		runner.run();
		}
	
}
