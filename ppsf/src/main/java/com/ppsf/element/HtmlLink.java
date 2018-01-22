package com.ppsf.element;

import org.openqa.selenium.Rectangle;
import com.ppsf.classes.html.PPSFHtmlLink;
import com.ppsf.elementfactory.Element;
import com.ppsf.elementfactory.ImplementedBy;

@ImplementedBy(PPSFHtmlLink.class)
public interface HtmlLink extends Element {

	Rectangle getRect();
	boolean isDisplayed();
	void click();
	String getText();
	
}