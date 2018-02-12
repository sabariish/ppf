package com.ppsf.elementfactory;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;

public class ElementFactory {
    public static Map<String, Object> metaData = new HashMap <String, Object>();
    
	/* Initializes a page factory from a class with a template of Elements. */
/*    public static <T> T initElements(WebDriver driver, Class<T> pageClassToProxy) {
        try {
            T page = pageClassToProxy.getConstructor(WebDriver.class).newInstance(driver);
            PageFactory.initElements(
                new ElementDecorator(
                    new DefaultElementLocatorFactory(driver)), page);
            return page;
        } catch (InstantiationException | IllegalAccessException            
            | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }*/
    
    /*public static void initElements(WebDriver driver, Object page) {
        final WebDriver driverRef = driver;
        //initElements(new DefaultElementLocatorFactory(driverRef), page);
        PageFactory.initElements(
                new ElementDecorator(
                    new DefaultElementLocatorFactory(driverRef)), page);
        
        //initMetadata();
 
      }*/
    
    
    
    public static void initElements(WebDriver driver, Object page) {
        final WebDriver driverRef = driver;
        initElements(new PPSFFieldDecorator(new PPSFElementLocatorFactory (driverRef)), page);
      }

      /**
       * Similar to the other "initElements" methods, but takes an {@link ElementLocatorFactory} which
       * is used for providing the mechanism for finding elements. If the ElementLocatorFactory returns
       * null then the field won't be decorated.
       *
       * @param factory The factory to use
       * @param page    The object to decorate the fields of
       */
    public static void initElements(ElementLocatorFactory factory, Object page) {
        final ElementLocatorFactory factoryRef = factory;
        initElements(new PPSFFieldDecorator(factoryRef), page);
      }
      /**
       * Similar to the other "initElements" methods, but takes an {@link FieldDecorator} which is used
       * for decorating each of the fields.
       *
       * @param decorator the decorator to use
       * @param page      The object to decorate the fields of
       */
      public static void initElements(FieldDecorator decorator, Object page) {
        Class<?> proxyIn = page.getClass();
        while (proxyIn != Object.class) {
          proxyFields(decorator, page, proxyIn);
          proxyIn = proxyIn.getSuperclass();
        }
      }

      private static void proxyFields(FieldDecorator decorator, Object page, Class<?> proxyIn) {
        Field[] fields = proxyIn.getDeclaredFields();
        for (Field field : fields) {
        
        //Object value = decorator.decorate(page.getClass().getClassLoader(), field);
        	Object value = decorator.decorate(page.getClass().getClassLoader(), field, page);
        if (value != null) {
            try {
              field.setAccessible(true);
              field.set(page, value);
              
            } catch (IllegalAccessException e) {
              throw new RuntimeException(e);
            }
          }
        }
      }
    
}
