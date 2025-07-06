package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
	private static ExtentReports extent;
	private static ExtentTest test;

	public static ExtentReports getReportInstance() {
		if (extent == null) {
			String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
			String reportpath = "reports/ExtentReport_" + timestamp + ".html";
			ExtentSparkReporter reporter = new ExtentSparkReporter(reportpath);

			reporter.config().setDocumentTitle("Automation test Report"); // Tab Title name
			reporter.config().setReportName("Test Execution Report");  // Report Name

			extent = new ExtentReports();
			extent.attachReporter(reporter);
		}
		return extent;
	}

	public static ExtentTest createTest(String testName) {
		test = getReportInstance().createTest(testName);
		return test;
	}
	
	public static String captureSS (WebDriver driver, String SSname) {
		try {
			File SS = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String path = System.getProperty("user.dir")+ "/Screenshots/"+SSname+".png";
			System.out.println("Path for ScreenShot is: " +path);
			FileUtils.copyFile(SS, new File(path));
			return path;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
