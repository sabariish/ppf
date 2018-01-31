package com.ppsf.common;


import java.io.IOException;
import java.sql.SQLException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import com.ppsf.datafactory.TestDataFactory;
import com.ppsf.verify.VerificationListener;


@Listeners(VerificationListener.class)
public class BaseTestCase {

	@BeforeMethod
	public void TestcaseEnter (){
		
		
		try {
			BaseTestPage.InstantiateWebDriver ();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
		
	
	@AfterMethod
	public void TestcaseExit (ITestResult result) throws IOException, SQLException{
		
		Boolean bLogResults;
		
		BaseTestPage.driver.quit();
		
		bLogResults = Boolean.parseBoolean(ConfigurationManager.getProperty ("bLogResults"));
		
		if (bLogResults){
			
			ResultsDb.WriteResults(result);	
		}
						
	}
	
	@DataProvider (name="tcData")
	public Object[][] getTCData() throws Throwable
    {
        Object[][] data = new TestDataFactory().getData().getTCInputData();
        return data;
    }

	}

