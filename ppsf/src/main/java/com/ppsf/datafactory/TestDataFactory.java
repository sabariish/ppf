package com.ppsf.datafactory;

import java.io.IOException;

import com.ppsf.common.ConfigurationManager;
import com.ppsf.common.TAFException;

public class TestDataFactory {
	
	public ITestData getData() throws IOException {
		String type = ConfigurationManager.getProperty("testcasedata.type");
		
		switch(type) {
		case "db": return new DBDataImpl();
		case "xls": return new XLSFileData();
		case "xml": return new XMLFileData();
		default: throw new TAFException.GENERAL_SCRIPT_ERROR("Invalid data source type: "+ type+" valid values are: 'alm', 'xls', 'xml'");
		}
		
	}

}
