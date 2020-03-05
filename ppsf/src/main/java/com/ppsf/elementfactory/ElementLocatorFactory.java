package com.ppsf.elementfactory;

import java.lang.reflect.Field;

public interface ElementLocatorFactory {
	  /**
	   * When a field on a class needs to be decorated with an {@link ElementLocator} this method will
	   * be called.
	   *
	   * @param field the field
	   * @return An ElementLocator object.
	   */
	  //ElementLocator createLocator(Field field);
	  ElementLocator createLocator(Field field, Object pageClass);
	}