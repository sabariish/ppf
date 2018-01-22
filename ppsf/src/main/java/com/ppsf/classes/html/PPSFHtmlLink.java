package com.ppsf.classes.html;

import org.openqa.selenium.WebElement;
import com.ppsf.elementfactory.PPSFWebElement;
import com.ppsf.interfaces.html.HtmlLink;
import com.ppsf.common.Exception;
public class PPSFHtmlLink extends PPSFWebElement implements HtmlLink{

	public PPSFHtmlLink(WebElement element) {
		super(element);
	}

	@Override
	public void click() {
		
		if (!getWrappedElement().isDisplayed()) {
			throw new Exception.EXPECTED_OBJECT_NOT_FOUND("Link:"+this+". Not found.");
		}
		getWrappedElement().click();
		
		return;
	}


}
