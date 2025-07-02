package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;
	By usernameTB = By.id("Email");
	By passwdTB = By.id("Password");
	By Button = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div/form/div[3]/button");

	public LoginPage(WebDriver driver) {   // Constructor(function with same name as it's class and no return type)
		this.driver = driver;
	}

	public void enterUser(String username) {
		driver.findElement(usernameTB).clear();
		driver.findElement(usernameTB).sendKeys(username);
	}

	public void enterPass(String password) {
		driver.findElement(passwdTB).clear();
		driver.findElement(passwdTB).sendKeys(password);
	}

	public void login() {
		driver.findElement(Button).click();
	}
}
