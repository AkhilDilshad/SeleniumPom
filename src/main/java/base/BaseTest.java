package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import utils.ExtentReportManager;
import utils.Log;

public class BaseTest {
	protected WebDriver driver;
	protected static ExtentReports extent;
	protected ExtentTest test;

	@BeforeSuite // Run once at the starting
	public void setUpReport() {
		extent = ExtentReportManager.getReportInstance();
	}

	@AfterSuite // Run once at the end
	public void tearDownReport() {
		extent.flush();
	}

	@BeforeMethod
	public void setUp() {
		Log.info("Starting Browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Log.info("Navigating to login page");
		driver.get("https://admin-demo.nopcommerce.com/login");
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			String SSPath = ExtentReportManager.captureSS(driver, "Login Failure");
			test.fail("Test Failed..Check ScreenShot", MediaEntityBuilder.createScreenCaptureFromPath(SSPath).build());
		}
		if (driver != null) {
			Log.warn("closing browser!!");
			driver.quit();
		}
	}
}
