package com.ppsf.common;


import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.ppsf.verify.VerificationListener;

@Listeners(VerificationListener.class)
public class BaseTestCase {

	
	public static WebDriver driver;
	
	public BaseTestCase (){
		
		PageFactory.initElements(driver, this);
	}

	@BeforeMethod
	public void TestcaseEnter (){
		
		
		try {
			InstantiateRemoteWebDriver ();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
		
		//driver = new FirefoxDriver();	
	
		
	
		
	}
	
		
	public void InstantiateRemoteWebDriver () throws IOException
	{
	
		String sBrowserName = DesiredCapabilities.firefox().getBrowserName();
		DesiredCapabilities oCapability = new DesiredCapabilities();
				
		oCapability.setBrowserName(sBrowserName);
		
		String sHubURL = getPropValues_IORead ("sHubURL");
		
		try{ 
		driver = new RemoteWebDriver(new URL(sHubURL), oCapability);
		System.out.println("RAN VIA SELENIUM GRID");
		}
		catch (UnreachableBrowserException e){
			System.out.println("NO SELENIUM GRID/NODE RUNNIG");
		//e.printStackTrace();
		//driver = new FirefoxDriver ();
			System.setProperty("webdriver.chrome.driver", "/Users/sabarishsasidharan/git/ppf/ppsf/server/chromedriver 2");
			driver = new ChromeDriver ();
		}
				
	}
	
	@AfterMethod
	public void TestcaseExit (ITestResult result) throws IOException, SQLException{
		
		Boolean bLogResults;
		
		driver.quit();
		
		bLogResults = Boolean.parseBoolean(getPropValues_IORead ("bLogResults"));
		
		if (bLogResults){
			
			ResultsDb.WriteResults(result);	
		}
						
	}
	
	
	// Below method is just for testing purpose.
	
	/*@AfterMethod
	public void TestcaseExit_Testing (ITestResult result) throws IOException, SQLException{
		
		
		
			ResultsDb.WriteResults_Testing(result);		
		}
	*/
	
	public void launchPage ()
	{
		try {
			driver.get(getPropValues_IORead("sURL"));
		} 
		catch (IOException e) {
			
			e.printStackTrace();
					}
	}
	
	// File Input-Output Section
	// Get Property Value from config.properties
	public static String getPropValues (String sProperty) throws IOException{
		
		String result = "";
		Properties prop = new Properties();
		FileReader reader = new FileReader("config.properties");
		
		prop.load(reader);
 		
		result = prop.getProperty(sProperty);
		Reporter.log("Result from getPropValues:"+result);
		
		return result;
		
	}
	public static String getPropValues_IORead (String sProperty) throws IOException{
		
		String result = "";
		Properties prop = new Properties();
		InputStream inputStream = 
				new FileInputStream("config.properties");
		
		prop.load(inputStream);
 		
		result = prop.getProperty(sProperty);
		Reporter.log("Result from getPropValues:"+result);
		
		
		return result;
		
	}	
	
	

	}

