package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.Log;

public class LoginTest extends BaseTest {
	@Test
	public void validLogin() {
		LoginPage loginpage = new LoginPage(driver); // Using the constructor from login page java class
		Log.info("Entering Credentials");
		loginpage.enterUser("admin@yourstore.com");
		loginpage.enterPass("admin");
		loginpage.login();
		Log.info("Verifying page title");
		Assert.assertEquals(driver.getTitle(), "Just a moment...");
	}
}
