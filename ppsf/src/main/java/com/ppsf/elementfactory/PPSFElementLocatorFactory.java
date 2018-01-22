package com.ppsf.elementfactory;

import org.openqa.selenium.SearchContext;

import java.lang.reflect.Field;

public final class PPSFElementLocatorFactory implements ElementLocatorFactory {
  private final SearchContext searchContext;

  public PPSFElementLocatorFactory(SearchContext searchContext) {
    this.searchContext = searchContext;
  }

/*  public ElementLocator createLocator(Field field) {
    return new DefaultElementLocator(searchContext, field);
  }
*/
@Override
public ElementLocator createLocator(Field field, Object pageClass) {
	return new PPSFElementLocator(searchContext, field, pageClass);
}
}