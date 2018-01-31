package com.ppsf.datafactory;

public interface ITestData {

	public Object[][] getTCInputData (String tcid);
	public Object[][] getTCInputData () throws Throwable;
	
}
