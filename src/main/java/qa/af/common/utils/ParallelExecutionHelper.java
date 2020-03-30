package qa.af.common.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import com.qmetry.qaf.automation.core.ConfigurationManager;

public class ParallelExecutionHelper implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		
		Object invocationCount = ConfigurationManager.getBundle().getProperty("method.invocationCount");
		Object threadPoolSize =  ConfigurationManager.getBundle().getProperty("method.threadPoolSize");
		
		Integer invCount, threadSize;
		
		if (invocationCount==null) {
			invCount=1;
		}
		else {
			invCount = Integer.parseInt((String) ConfigurationManager.getBundle().getProperty("method.invocationCount"));
		}
		
		if (threadPoolSize==null) {
			threadSize=1;
		}
		else
		{
			threadSize =  Integer.parseInt((String)ConfigurationManager.getBundle().getProperty("method.threadPoolSize"));
		}
		
		annotation.setInvocationCount(invCount);
		annotation.setThreadPoolSize(threadSize);
	
	}

}
