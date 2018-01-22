package com.ppsf.testcases;

import org.testng.annotations.Test;

import com.ppsf.common.BaseTestCase;
import com.ppsf.common.BaseTestPage;
import com.ppsf.pages.GoogleSearchPage;
import com.ppsf.verify.Verify;

public class test1 extends BaseTestCase{

	@Test
	public void test3() {
			
		GoogleSearchPage GSP =  new GoogleSearchPage();
		GSP.Invoke();
		
		Verify.PageInvoked(BaseTestPage.driver, "Google");
		Verify.ObjectExists(GSP.edtSearchBox, true);
		
	
	}
}
