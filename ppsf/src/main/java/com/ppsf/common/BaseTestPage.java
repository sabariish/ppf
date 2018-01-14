package com.ppsf.common;

import java.io.File;
import java.io.IOException;
import java.net.URL;

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

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseTestPage {
	
	public static  WebDriver driver;
	
	public BaseTestPage (){
		
		PageFactory.initElements(driver, this);
	}

	public static void InstantiateWebDriver () throws IOException
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
		driver = new RemoteWebDriver(new URL(ConfigurationManager.getProperty ("sHubURL")), oCapability);
		System.out.println("Running via Selenium GRID");
		}
		catch (UnreachableBrowserException e){
			switch (ConfigurationManager.getProperty ("driver.name")) {
			
			case "chromeDriver":
				System.setProperty("webdriver.chrome.driver", new File(ConfigurationManager.getProperty ("webdriver.chrome.driver")).getCanonicalPath());
				driver = new ChromeDriver ();
			break;
			
			case "firefoxDriver":
				driver = new FirefoxDriver();
			break;
			
			case "ieDriver":
				System.setProperty("webdriver.ie.driver", new File(ConfigurationManager.getProperty ("webdriver.ie.driver")).getCanonicalPath());
				driver = new InternetExplorerDriver ();

			break;
			
			case "safariDriver":
				driver = new SafariDriver ();

			break;
			
			case "appiumDriver":
				//driver = new RemoteWebDriver(new URL(ConfigurationManager.getProperty ("AppiumServerURL")), oCapability);
			    service = AppiumDriverLocalService.buildDefaultService();
				service.start();
				driver = new IOSDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

			break;

			default:
				throw new PPFException.GENERAL_SCRIPT_ERROR("driver.name: "+ConfigurationManager.getProperty ("driver.name")+"is not supported. "
								+ "Supported values: chromeDriver, appiumDriver, safariDriver, ieDriver & firefoxDriver");
				
			}
		}
				
	}

	
	
	protected void launchPage ()
	{
		try {
			
			driver.get(ConfigurationManager.getProperty("sURL"));
		} 
		catch (IOException e) {
			
			e.printStackTrace();
					}
	}
	

	}

