package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	private WebDriver driver;
	
	@FindBy(id="Email") 
	WebElement usernameTB;
	
	@FindBy(id="Password") 
	WebElement passwdTB;
	
//	@FindBy(xpath="//*[@id=\\\"main\\\"]/div/div/div/div[2]/div[1]/div/form/div[3]/button")
//	WebElement Button;
	
//	By usernameTB = By.id("Email");
//	By passwdTB = By.id("Password");
	By Button = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div/form/div[3]/button");

	public LoginPage(WebDriver driver) {   // Constructor(function with same name as it's class and no return type)
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterUser(String username) {
		usernameTB.clear();
		usernameTB.sendKeys(username);
//		driver.findElement(usernameTB).clear();
//		driver.findElement(usernameTB).sendKeys(username);
	}

	public void enterPass(String password) {
		passwdTB.clear();
		passwdTB.sendKeys(password);
//		driver.findElement(passwdTB).clear();
//		driver.findElement(passwdTB).sendKeys(password);
	}

	public void login() {
		//Button.click();
		driver.findElement(Button).click();
	}
}
