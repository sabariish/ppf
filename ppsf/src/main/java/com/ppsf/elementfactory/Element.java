package com.ppsf.elementfactory;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.internal.WrapsElement;

@ImplementedBy(PPSFWebElement.class)
public interface Element extends WebElement, WrapsElement, Locatable{
	
    public Map<String, Object> getMetaData();
}