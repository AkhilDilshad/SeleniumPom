package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {
	@Test
	public void validLogin() {
		LoginPage loginpage = new LoginPage(driver); // Using the constructor from login page java class
		loginpage.enterUser("admin@yourstore.com");
		loginpage.enterPass("admin");
		loginpage.login();
		Assert.assertEquals(driver.getTitle(), "Just a moment...");
	}
}
