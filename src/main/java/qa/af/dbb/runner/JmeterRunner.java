package qa.af.dbb.runner;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.testng.TestNG;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.util.Reporter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JmeterRunner extends AbstractJavaSamplerClient implements Serializable {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(JmeterRunner.class);
	
	@Override
	public SampleResult runTest(JavaSamplerContext context) {
		
		 SampleResult sampleResult = new SampleResult();
	        sampleResult.sampleStart();
		
	        try {	// TODO Auto-generated method stub
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
		
		//int s = runner.getStatus();
        sampleResult.sampleEnd();;
        sampleResult.setSuccessful(Boolean.TRUE);
        sampleResult.setResponseCodeOK();
        //sampleResult.setResponseMessage(s);
	        }
	        catch (Exception e) {
	        	
	            Reporter.log("Request was not successfully processed: " + e);
	            LOGGER.error("Request was not successfully processed",e);
	            sampleResult.sampleEnd();
	            sampleResult.setResponseMessage(e.getMessage());
	            sampleResult.setSuccessful(Boolean.FALSE);
	        }
		return sampleResult;
	}
	
	
	

}
