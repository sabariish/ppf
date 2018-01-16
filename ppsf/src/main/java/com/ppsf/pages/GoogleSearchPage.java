package com.ppsf.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.ppsf.common.BaseTestPage;
import com.ppsf.elementfactory.Element;


public class GoogleSearchPage extends BaseTestPage{
	

	@FindBy(name="q")
	public Element edtSearchBox;
		
	@FindBy(name="btnk")
	public WebElement btnGoogleSearch;
	
	
	
	public void Invoke () 
	{
		
		launchPage ();
	}
		
	}
	
		



