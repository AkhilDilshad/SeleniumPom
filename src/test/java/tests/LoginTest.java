package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExcelUtils;
import utils.ExtentReportManager;
import utils.Log;

public class LoginTest extends BaseTest {
	
	@DataProvider(name = "LoginData")
	public Object[][] getLoginData() throws IOException{
		String filepath = System.getProperty("user.dir") + "/testdata/Testdata.xlsx";
		ExcelUtils.loadExcel(filepath, "Sheet1");  // calling from ExcelUtils class
		int n = ExcelUtils.getRowCount();
		Object[][] data = new Object[n-1][2];  // n-1 - without heading, 2 - userName and password(2 inputs) 
		
		for(int i=1; i<n ; i++) {
			data[i-1][0] = ExcelUtils.getCellData(i, 0);  // Takes UserName
			data[i-1][1] = ExcelUtils.getCellData(i, 1);  // Takes Password
		}
		ExcelUtils.closeExcel();
		return data;
	}
	
	
	@Test(dataProvider = "LoginData")
	public void validLogin(String username, String password) {
		test = ExtentReportManager.createTest("Login Test - " +username); // test case name

		test.info("Navigating to Browser");
		LoginPage loginpage = new LoginPage(driver); // Using the constructor from login page java class

		test.info("Entering Credentials");
		Log.info("Entering Credentials");
//		loginpage.enterUser("admin@yourstore.com");
//		loginpage.enterPass("admin");
		loginpage.enterUser(username);
		loginpage.enterPass(password);
		Log.info("Submitting...");
		test.info("Submitting...");
		loginpage.login();

		Log.info("Verifying page title");
		Assert.assertEquals(driver.getTitle(), "Just a moment...");

		Log.info("Login Test Completed");
		test.pass("Login Test Completed");
	}
//	@Test
//	public void invalidLogin() {
//		test = ExtentReportManager.createTest("Login Test with Invalid Credentials"); // test case name
//
//		test.info("Navigating to Browser");
//		LoginPage loginpage = new LoginPage(driver); // Using the constructor from login page java class
//
//		test.info("Entering Credentials");
//		Log.info("Entering Credentials");
//		loginpage.enterUser("admin@yourstore.com");
//		loginpage.enterPass("admin1234");
//		loginpage.login();
//
//		Log.info("Verifying page title");
//		Assert.assertEquals(driver.getTitle(), "Just a moment...1234");
//
//		Log.info("Login Test Completed");
//		//test.pass("Login Test Completed");
//	}
}
