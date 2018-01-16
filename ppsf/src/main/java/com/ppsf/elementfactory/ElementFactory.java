package com.ppsf.elementfactory;

import java.lang.reflect.InvocationTargetException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class ElementFactory extends PageFactory {
    /* Initializes a page factory from a class with a template of Elements. */
    public static <T> T initElements(WebDriver driver, Class<T> pageClassToProxy) {
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
    }
    
    public static void initElements(WebDriver driver, Object page) {
        final WebDriver driverRef = driver;
        //initElements(new DefaultElementLocatorFactory(driverRef), page);
        PageFactory.initElements(
                new ElementDecorator(
                    new DefaultElementLocatorFactory(driverRef)), page);
 
      }
}
