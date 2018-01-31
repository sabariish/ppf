package com.ppsf.datafactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class XLSFileData implements ITestData{

	@Override
	public Object[][] getTCInputData(String tcid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[][] getTCInputData() throws Throwable {
		
		return readXLSXFile();
	}
	
	public static Object[][] readXLSXFile() throws IOException {
		InputStream xlsFile = new FileInputStream ("TestData.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(xlsFile);
		XSSFSheet sheet=wb.getSheetAt(0);
		
		int rows = sheet.getPhysicalNumberOfRows();
		Object[][] excelData = new Object[rows-2][sheet.getRow(0).getLastCellNum()];

		for (int i =2; i<rows; i++) {
			int columns = sheet.getRow(i).getLastCellNum();
			for (int j=0; j<columns; j++) {
				excelData[i-2][j]= sheet.getRow(i).getCell(j).toString();
			}
		}
		wb.close();
		return excelData;
	}

	public static void main(String[] args) throws IOException {
		readXLSXFile();
	}
	
}
