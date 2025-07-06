package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExtentReportManager;
import utils.Log;

public class LoginTest extends BaseTest {
	@Test
	public void validLogin() {
		test = ExtentReportManager.createTest("Login Test"); // test case name

		test.info("Navigating to Browser");
		LoginPage loginpage = new LoginPage(driver); // Using the constructor from login page java class

		test.info("Entering Credentials");
		Log.info("Entering Credentials");
		loginpage.enterUser("admin@yourstore.com");
		loginpage.enterPass("admin");
		loginpage.login();

		Log.info("Verifying page title");
		Assert.assertEquals(driver.getTitle(), "Just a moment...");

		Log.info("Login Test Completed");
		test.pass("Login Test Completed");
	}
	@Test
	public void invalidLogin() {
		test = ExtentReportManager.createTest("Login Test with Invalid Credentials"); // test case name

		test.info("Navigating to Browser");
		LoginPage loginpage = new LoginPage(driver); // Using the constructor from login page java class

		test.info("Entering Credentials");
		Log.info("Entering Credentials");
		loginpage.enterUser("admin@yourstore.com");
		loginpage.enterPass("admin1234");
		loginpage.login();

		Log.info("Verifying page title");
		Assert.assertEquals(driver.getTitle(), "Just a moment...1234");

		Log.info("Login Test Completed");
		test.pass("Login Test Completed");
	}
}
