package com.ppsf.verify;



import java.util.List;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;


public class VerificationListener implements IInvokedMethodListener {

	List<Throwable> lThrowable;
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		
		List<String> lsError = Verify.getVerificationFailures();
		
				
		if(lsError.size() > 0)
		{
			testResult.setStatus(ITestResult.FAILURE);
		
				
		StringBuffer failureMessage = new StringBuffer("Number of  verification failures: (").append(lsError.size()).append(")\n");

		for(int i =0 ; i < lsError.size(); i++)
		{ 
                    failureMessage.append("(").append(i+1).append(")").append(lsError.get(i)).append("\n");                      
        }

                
        testResult.setThrowable(new Throwable(failureMessage.toString()));
       
              
		}
		
		Verify.removeAllErrors();
    }



	public void beforeInvocation(IInvokedMethod method, ITestResult testresult) 
	{
		
        if(method.isTestMethod())
        {  
         
            if(Verify.getVerificationFailures().size()!=0)
            {
                throw new RuntimeException("Stale error buffer detected!");
            }
             
        }

	}
}
