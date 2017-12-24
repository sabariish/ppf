package com.ppsf.common;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.ppsf.verify.VerificationListener;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

@Listeners(VerificationListener.class)
public class BaseTestCase {

	
	public static WebDriver driver;
	
	public BaseTestCase (){
		
		PageFactory.initElements(driver, this);
	}

	@BeforeMethod
	public void TestcaseEnter (){
		
		
		try {
			InstantiateWebDriver ();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
		
	private void InstantiateWebDriver () throws IOException
	{
	
		String sBrowserName = DesiredCapabilities.firefox().getBrowserName();
		DesiredCapabilities oCapability = new DesiredCapabilities();
				
		oCapability.setBrowserName(sBrowserName);
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "iPhone 6 Plus");
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "9.2");
        capabilities.setCapability("browserName", "safari");
        AppiumDriverLocalService service=null;

 
		
		try{ 
		driver = new RemoteWebDriver(new URL(getPropValues_IORead ("sHubURL")), oCapability);
		System.out.println("Running via Selenium GRID");
		}
		catch (UnreachableBrowserException e){
			switch (getPropValues_IORead ("driver.name")) {
			
			case "chromeDriver":
				System.setProperty("webdriver.chrome.driver", new File(getPropValues_IORead ("webdriver.chrome.driver")).getCanonicalPath());
				driver = new ChromeDriver ();
			break;
			
			case "firefoxDriver":
				driver = new FirefoxDriver();
			break;
			
			case "ieDriver":
				System.setProperty("webdriver.ie.driver", new File(getPropValues_IORead ("webdriver.ie.driver")).getCanonicalPath());
				driver = new InternetExplorerDriver ();

			break;
			
			case "safariDriver":
				driver = new SafariDriver ();

			break;
			
			case "appiumDriver":
				//driver = new RemoteWebDriver(new URL(getPropValues_IORead ("AppiumServerURL")), oCapability);
			    service = AppiumDriverLocalService.buildDefaultService();
				service.start();
				driver = new IOSDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

			break;

			default:
				//throw new Exception("");
				new Throwable("driver.name: "+getPropValues_IORead ("driver.name")+"is not supported. "
						+ "Supported values: chromeDriver, appiumDriver, safariDriver, ieDriver & firefoxDriver");
				break;
			}
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
	
	
	protected void launchPage ()
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

