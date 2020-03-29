package com.ppsf.elementfactory;

import java.util.List;

import org.openqa.selenium.WebElement;

public interface ElementLocator {
	  WebElement findElement();
	  List<WebElement> findElements();

}
