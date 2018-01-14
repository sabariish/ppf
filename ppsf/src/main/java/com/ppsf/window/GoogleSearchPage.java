package com.ppsf.window;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.ppsf.common.BaseTestPage;


public class GoogleSearchPage extends BaseTestPage{
	

	@FindBy(name="q")
	public WebElement edtSearchBox;

	@FindBy(name="btnk")
	public WebElement btnGoogleSearch;
	
	
	
	public void Invoke () 
	{
		
		launchPage ();
	}
		
	}
	
		



