package com.ppsf.classes.html;

import org.openqa.selenium.WebElement;
import com.ppsf.elementfactory.PPSFWebElement;
import com.ppsf.common.TAFException;
import com.ppsf.element.HtmlLink;
public class PPSFHtmlLink extends PPSFWebElement implements HtmlLink{

	public PPSFHtmlLink(WebElement element) {
		super(element);
	}

	@Override
	public void click() {
		
		if (!getWrappedElement().isDisplayed()) {
			throw new TAFException.EXPECTED_OBJECT_NOT_FOUND("Link:"+this+". Not found.");
		}
		getWrappedElement().click();
		
		return;
	}


}
