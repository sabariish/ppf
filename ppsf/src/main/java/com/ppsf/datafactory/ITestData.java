package com.ppsf.datafactory;

import java.util.Iterator;

public interface ITestData {

	public Object[][] getTCInputData (String tcid);
	public Iterator<Object[]> getTCInputData ();
	
}
