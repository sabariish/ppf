package com.ppsf.testcases;

import org.testng.annotations.Test;

import com.ppsf.common.BaseTestCase;
import com.ppsf.verify.Verify;
import com.ppsf.window.GoogleSearchInterimPage;
import com.ppsf.window.GoogleSearchPage;
 
public class test extends BaseTestCase {
	
	@Test
	public void test1() {

		GoogleSearchPage GSP =  new GoogleSearchPage();
		GSP.Invoke();
		GSP.edtSearchBox.sendKeys("Sabarish Just Rocks");
		//GSP.edtSearchBox
		
		GoogleSearchInterimPage GSIP = new GoogleSearchInterimPage();
		//GSIP.btnMagnifier.click();
		
	}
	
	@Test
	public void test2() {

		GoogleSearchPage GSP =  new GoogleSearchPage();
		GSP.Invoke();
		GSP.edtSearchBox.sendKeys("Sabarish Just Rocks");
		
		GoogleSearchInterimPage GSIP = new GoogleSearchInterimPage();
		GSIP.btnMagnifier.click();
		
		
	}
	@Test
	public void test3() {
			
		GoogleSearchPage GSP =  new GoogleSearchPage();
		GSP.Invoke();
		
		//Verify.PageInvoked(GSP.driver, "Google");
		Verify.ObjectExists(GSP.edtSearchBox, true);
		//GoogleSearchInterimPage GSIP = new GoogleSearchInterimPage();
		
		//Verify.ObjectExists(GSIP.btnMagnifier, true);
		//Verify.ObjectExists(GSIP.btnMagnifier, false);
	
	}

			
	@Test
	public void test5() {
		
		
		Verify.StringMatch("Sabarish", "SasidharanSabarish", "String Matched");
		Verify.StringMatch("Sabarish", "XYZ", "String Matched");
		Verify.StringMatch("Sabarish", "SABARISHS", "String Matched");
		Verify.StringMatch("Sabarish", "xyxSabarishChhh", "String Matched");
		//Verify.Value(2, 2, "");		
		//Verify.Value(2, -3);
		
			
	}
	@Test
	public void test4() {

		//String sHubUrl = "http://localhost:4444/wd/hub";
		

		//driver.get("http://facebook.com");
		
	}
	
	
	
	
}
