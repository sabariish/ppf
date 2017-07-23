package com.ppsf.verify;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Verify {
	
	private static List<String> lsErrorMsgs= new ArrayList<String>();
	private static List<StackTraceElement[]> lsStackStrace;
	
	public static boolean Value (Object actual, Object expected, String sMessage){
		
		boolean bMatch = true;
		
		try {	
			Assert.assertEquals (actual, expected);
			System.out.println("Verification Passed: "+sMessage);
		
		}
				
		catch(Throwable e){
	
			bMatch = false;
			System.err.println("Verification Failed: "+sMessage);
			addVerificationError (e);
			return bMatch;	
		}
		
		return bMatch;
	
	}
	private static boolean AssertTrue (boolean bMatch){
		
		try{
		Assert.assertTrue(bMatch);
		System.out.println("Verification Passed: String Matched in the Pattern");
		}
		catch (Throwable e){
			addVerificationError (e);
			System.err.println("Verification Failed: String did not match");
			return bMatch;
		}
		return bMatch;
	}
		
	static void addVerificationError (Throwable e){
	
		String sError;
		sError = e.getMessage();
		
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		sw.toString(); 
		
		sError = sError+sw;
				
		lsErrorMsgs.add(sError);
						
				
	}
	
	static List<String> getVerificationFailures(){
		return lsErrorMsgs;
	}
			
	static List<StackTraceElement[]> getStackTrace (Throwable e){
		
		lsStackStrace.add(e.getStackTrace());
		
		return lsStackStrace; 
	}
	
	static void removeAllErrors ()
	{
		lsErrorMsgs.removeAll(lsErrorMsgs);
	}
	
	
	public static boolean ObjectExists (WebElement wObject, boolean bExpected, String sMessage){
		
				
		if (Verify.Value(wObject.isDisplayed(), bExpected, sMessage)){
			return true;	
		}
		
		return false;
		
	}
	
	public static boolean StringMatch (String sActual, String sExpectedPattern, String sDescription){
		
		boolean bMatch = false;
		
		bMatch = sExpectedPattern.contains(sActual);
		
		Verify.AssertTrue(bMatch);
		
		return bMatch;
	}
	
	public static boolean PageInvoked (WebDriver dPage, String sTitle){
		boolean bPageFound = false;
		
		
		
		bPageFound = Verify.Value(dPage.getTitle(), sTitle, sTitle+ " Page is Invoked");
				
		return bPageFound;
			
		
	}
	
}