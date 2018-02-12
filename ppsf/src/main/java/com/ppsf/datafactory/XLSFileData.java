package com.ppsf.datafactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class XLSFileData implements ITestData{

	@Override
	public Object[][] getTCInputData(String tcid) {
		Object[][] dataRow = null;
		try {
			dataRow = readXLSXFileRow(tcid);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataRow;
	}

	@Override
	public Iterator<Object[]> getTCInputData() {
		Collection<Object[]> dp = new ArrayList<Object[]>();	

		List<?> t = null;
		try {
			t = XLSFileData.readXLSXFileRows();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Iterator<?> iterator = t.iterator();
		
		while(iterator.hasNext()){
    		dp.add(new Object[] {iterator.next()});
    		}
		return dp.iterator();
		
	}
	
	public static Object[][] readXLSXFileRow(String tcid) throws IOException {
		InputStream xlsFile = new FileInputStream ("TestData.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(xlsFile);
		XSSFSheet sheet=wb.getSheetAt(0);
		
		int rows = sheet.getPhysicalNumberOfRows();
		//Object[][] excelData = new Object[rows-2][sheet.getRow(0).getLastCellNum()];
		List<Entry<String, String>> list = new ArrayList<Entry<String, String>>();
		Entry<String, String> e;
		TCData tcData = null;
		for (int i =2; i<rows; i++) {
			int columns = sheet.getRow(i).getLastCellNum();
			if (sheet.getRow(i).getCell(0).toString().equals(tcid)) {
			for (int j=0; j<columns; j++) {
				//excelData[i-2][j]= sheet.getRow(i).getCell(j).toString();
				e = new Entry<String, String>(sheet.getRow(1).getCell(j).toString(), sheet.getRow(i).getCell(j).toString());
				list.add(e);
			}
			tcData = new TCData(list);
			}
		}
		wb.close();
		return new Object[][]{{tcData}};
	}

	public static List<?> readXLSXFileRows() throws IOException {
		InputStream xlsFile = new FileInputStream ("TestData.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(xlsFile);
		XSSFSheet sheet=wb.getSheetAt(0);
		
		int rows = sheet.getPhysicalNumberOfRows();
		List<TCData> listTCData = new ArrayList<TCData>();
		List<Entry<String, String>> list = new ArrayList<Entry<String, String>>();
		Entry<String, String> e;
		for (int i =2; i<rows; i++) {
			int columns = sheet.getRow(i).getLastCellNum();
			for (int j=0; j<columns; j++) {
				e = new Entry<String, String>(sheet.getRow(1).getCell(j).toString(), sheet.getRow(i).getCell(j).toString());
				list.add(e);
			}
			TCData t = new TCData(list);
			listTCData.add(t);
			list.clear();
		}
		wb.close();
		
		return listTCData;
	}
	
	public static void main(String[] args) throws IOException {
		//readXLSXFile1();
	}
	
}
