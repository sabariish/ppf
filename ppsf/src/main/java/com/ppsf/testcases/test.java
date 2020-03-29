package com.ppsf.testcases;

import org.testng.annotations.Test;
import com.ppsf.common.BaseTestCase;
import com.ppsf.datafactory.TCData;
import com.ppsf.pages.GoogleSearchInterimPage;
import com.ppsf.pages.GoogleSearchPage;
import com.ppsf.verify.Verify;
 
public class test extends BaseTestCase {
	
	@Test
	public void test1() {

		GoogleSearchPage GSP =  new GoogleSearchPage();
		GSP.Invoke();
		GSP.edtSearchBox.sendKeys("Sabarish");
		//GSP.edtSearchBox
		
		GoogleSearchInterimPage GSIP = new GoogleSearchInterimPage();
		GSIP.btnMagnifier.click();
		
	}
	//@Test(dataProvider = "tcData_SingleRow")
	@Test(dataProvider = "tcData_MultipleRows")
	public void sabarish(TCData tcdata) {
		GoogleSearchPage GSP =  new GoogleSearchPage();
		GSP.Invoke();
		System.out.println(tcdata.getUsername());
		GSP.edtSearchBox.sendKeys(tcdata.getUsername());
		
		//GoogleSearchInterimPage GSIP = new GoogleSearchInterimPage();
		//GSIP.btnMagnifier.click();
		
		
	}
	@Test
	public void test3() {
			
		GoogleSearchPage GSP =  new GoogleSearchPage();
		GSP.Invoke();
		GSP.linkGmail.click();
		//Verify.PageInvoked(GSP.driver, "Google");
		//Verify.ObjectExists(GSP.edtSearchBox, true);
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
