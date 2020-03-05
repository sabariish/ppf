package com.ppsf.verify;

//import java.io.PrintWriter;
//import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.testng.Assert;

public class Verify {
	
	private static List<String> lsErrorMsgs= new ArrayList<String>();
	//private static List<StackTraceElement[]> lsStackStrace;

	private static void OutputResult (boolean bMatch, Object actual,Object expected, String description)
	{
		if (bMatch) {
			addVerificationPoint ("Passed", description);
			System.out.println("Verification Passed: "+description);
		}
		else
		{
			addVerificationPoint ("Failed", description);
			System.err.println("Verification Failed: "+description);

		}
		System.out.println("Expected: "+expected);
		System.out.println("Actual: "+actual);
	
		
	}
	
	private static void addVerificationPoint(String status, String description) {
		
		if (!status.contentEquals("Passed")) {
			lsErrorMsgs.add(description);
		}
	}
	
	public static boolean Value (Object actual, Object expected, String sMessage){
		
		boolean bMatch = false;
		
			bMatch = actual.equals(expected);
			OutputResult (bMatch, actual, expected, sMessage);
		return bMatch;
	
	}
/*	private static boolean AssertTrue (boolean bMatch){
		
		try{
		Assert.assertTrue(bMatch);
		System.out.println("Verification Passed: String Matched in the Pattern");
		}
		catch (Throwable e){
			addVerificationError (e, "Verification Failed: String did not match");
			System.err.println("Verification Failed: String did not match");
			return bMatch;
		}
		return bMatch;
	}*/
		
/*	static void addVerificationError (Throwable e, String... message){
	
		String sError;
		sError = message[0] + " Exception: "+e.getMessage();
		
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		sw.toString(); 
		
		sError = sError+sw;
				
		lsErrorMsgs.add(sError);
						
				
	}*/
	
	static List<String> getVerificationFailures(){
		return lsErrorMsgs;
	}
			
/*	static List<StackTraceElement[]> getStackTrace (Throwable e){
		
		lsStackStrace.add(e.getStackTrace());
		
		return lsStackStrace; 
	}*/
	
	static void removeAllErrors ()
	{
		lsErrorMsgs.removeAll(lsErrorMsgs);
	}
	
	
	public static boolean ObjectExists (WebElement wObject, boolean bExpected){
		String sMessage="";
		/*		String sMessage="";
		String page = "";
		if (bExpected) {
			sMessage =wObject +" should exist on the page: "+page+".";
		}
		else
		{
			sMessage =wObject +" should *NOT* exist on the page: "+page+".";
		}
*/		
		if (Verify.Value(wObject.isDisplayed(), bExpected, sMessage)){
			return true;	
		}
		
		return false;
		
	}
	
	public static boolean StringMatch (String sActual, String sExpectedPattern, String sDescription){
		
		boolean bMatch = false;
		
		bMatch = sExpectedPattern.contains(sActual);
		
		OutputResult (bMatch, sActual, sExpectedPattern, sDescription);
		
		return bMatch;
	}
	
	public static boolean PageInvoked (WebDriver dPage, String sTitle){
		boolean bPageFound = false;
		
		
		
		bPageFound = Verify.Value(dPage.getTitle(), sTitle, sTitle+ " Page is Invoked");
				
		return bPageFound;
			
		
	}
	
	public static boolean ObjectExistsWithValue (WebElement wObject, String sObjectValue, String sDescription) {
		boolean bReturn = false;
		
		if (Verify.ObjectExists(wObject, true)) {
			
		}
		
		return bReturn;
	}
	
}