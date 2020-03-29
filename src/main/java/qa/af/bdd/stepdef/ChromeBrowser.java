package qa.af.bdd.stepdef;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.qmetry.qaf.automation.step.WsStep;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
public class ChromeBrowser extends WebDriverTestBase {

	
	@Test
	public void test () throws MalformedURLException
	{
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\sabarish.sasidharan\\eclipse-workspace\\af\\src\\main\\resources\\browser-drivers\\chromedriver.exe");
	
		//WebDriver driver2 = new ChromeDriver();
		//driver2.get("http://google.com");		
		
		//DesiredCapabilities d = DesiredCapabilities.chrome();
		//d.setBrowserName("chrome");
		//d.setVersion("80.0.3987.149");
		//d.setPlatform(Platform.ANY);
		//WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), d);
		//driver.get("http://www.google.com");
		
		//getDriver().get("http://www.google.com");
		new WebDriverTestBase().getDriver().get("http://www.google.com");
		
		WsStep.userRequests("sample.reqwithbody1");
		WsStep.responseShouldHaveStatusCode(200);
		
		
	}
}
