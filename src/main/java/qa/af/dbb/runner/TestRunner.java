package qa.af.dbb.runner;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarFile;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import com.qmetry.qaf.automation.core.ConfigurationManager;

import qa.af.bdd.stepdef.ChromeBrowser;
import qa.af.common.utils.CopyResources;

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
	
	public static void main(String[] args) throws IOException, URISyntaxException {
		
		/*
		 * CodeSource codeSource =
		 * TestRunner.class.getProtectionDomain().getCodeSource(); File jarFile = new
		 * File (codeSource.getLocation().toURI().getPath());
		 * 
		 * JarFile source = new JarFile(jarFile.getParentFile().getPath()+
		 * "/af-0.0.1-SNAPSHOT-jar-with-dependencies.jar");
		 * System.out.println(jarFile.getParentFile().getPath()); CopyResources cp = new
		 * CopyResources(); cp.copyResourceDirectory(source, "resources", new
		 * File("./resources"));
		 */
		
		// Create object of TestNG Class
		TestNG runner=new TestNG();
		 
		// Create a list of String 
		List<String> suitefiles=new ArrayList<String>();
		
		
		
		// Add xml file which you have to execute
		//suitefiles.add("./src/main/resources/testng-config/testrun.xml");
		//suitefiles.add("./src/main/resources/testng-config/testrun2.xml");
		suitefiles.add((String) ConfigurationManager.getBundle().getProperty("testng.suitefile"));
		// now set xml file for execution
		runner.setTestSuites(suitefiles);
		 
		// finally execute the runner using run method
		runner.run();
		}
	
}
