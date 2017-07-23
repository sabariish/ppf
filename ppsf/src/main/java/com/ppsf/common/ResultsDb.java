package com.ppsf.common;

import org.testng.ITestResult;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
public class ResultsDb {

	private static Connection connect() throws IOException {
		String sDriver = BaseTestCase.getPropValues_IORead("driver");
		String sUsername = BaseTestCase.getPropValues_IORead("username");
		String sPassword = BaseTestCase.getPropValues_IORead("password");
		Connection connection = null;	 
						 
				try {
					try {
						Class.forName("com.mysql.jdbc.Driver").newInstance();
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (ClassNotFoundException e) {
					System.out.println("Where is your MySQL JDBC Driver?");
					e.printStackTrace();
					return null;
				}
		 
							 
				try {
					//connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/resultsdb","root", "sabarish");
			 
					connection = DriverManager.getConnection(sDriver,sUsername, sPassword);
					
				} catch (SQLException e) {
				
					e.printStackTrace();
					return null;
				}
			 
				return connection;
			  }
	public static void WriteResults (ITestResult result) throws SQLException, IOException{
		
		String sql;
		String sTestCaseStatus = "NotRun";
		
		// TestCase Run Status
		if (result.isSuccess()){
			sTestCaseStatus = "Passed";
		}
		if (result.getStatus()==2){
			sTestCaseStatus = "Failed";
		}
		if (result.getStatus()==3){
			sTestCaseStatus = "Skipped";
		}
		
		// Testcase Name
		String sTestName = result.getMethod().getMethodName();
		Throwable sErrorMessage = result.getThrowable();
		// Test Elapsed Time
		long lElapsedTime = (result.getEndMillis() - result.getStartMillis())/1000;

		// Execution Date
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD-hh-mm-ss");
		String sExecutionDate = sdf.format(new Date ());
		
				
		
		// Connection String 
		Connection connection =  connect();
		Statement stmt = null;
		
		stmt = connection.createStatement();

		sql = "INSERT INTO ResultsAutomation (TestName, ElapsedTime, Status, ErrorMessage, ExecutionDate)";
		sql = sql+"VALUES ('"+sTestName+"', '"+lElapsedTime+"', '"+sTestCaseStatus+"', '"+sErrorMessage+"', '"+sExecutionDate+"')";
	
			
		stmt.executeUpdate(sql);
		stmt.close();
	}
	
 
	
public static void WriteResults_Testing (ITestResult result) throws SQLException{
		
		
		String sTestCaseStatus = "NotRun";
		
		// TestCase Run Status
		if (result.isSuccess()){
			sTestCaseStatus = "Passed";
		}
		if (result.getStatus()==2){
			sTestCaseStatus = "Failed";
		}
		if (result.getStatus()==3){
			sTestCaseStatus = "Skipped";
		}
		
		// Testcase Name
		String sTestName = result.getMethod().getMethodName();
		Throwable sErrorMessage = result.getThrowable();
		// Test Elapsed Time
		long lElapsedTime = (result.getEndMillis() - result.getStartMillis())/1000;

		// Execution Date
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD-hh-mm-ss");
		String sExecutionDate = sdf.format(new Date ());
		
		
		System.out.println("Her Iam................START");
		System.out.println(sTestName);
		System.out.println(sTestCaseStatus);
		System.out.println(sErrorMessage);
		System.out.println(lElapsedTime);
		System.out.println(sExecutionDate);
		
		System.out.println("Her Iam................ END");
		
	}
	
	
	
}
