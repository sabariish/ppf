package com.ppsf.pages;

import org.openqa.selenium.support.FindBy;
import com.ppsf.common.BaseTestPage;
import com.ppsf.element.HtmlLink;
import com.ppsf.elementfactory.Element;


public class GoogleSearchPage extends BaseTestPage{
	

	@FindBy(name="q")
	public Element edtSearchBox;
		
	@FindBy(name="btnk")
	public Element btnGoogleSearch;
	
	@FindBy(xpath="//a[text()='Gmail']")
	public HtmlLink linkGmail;

	
	public void Invoke () 
	{
		
		launchPage ();
	}
		
	}
	
		



