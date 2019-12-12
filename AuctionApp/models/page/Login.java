package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
	
	public WebDriver driver;
	
	By login = By.xpath("//a[contains(text(),'Login')]");
	By email = By.xpath("//input[@id='email']");
	By password = By.xpath("//input[@id='password']");
	By login_button = By.xpath("//button[@class='login-button']");
	By forgot_password = By.xpath("//a[@class='forgot-password']");
	By login_title = By.xpath("//span[contains(text(),'login')]");
	
	public Login(WebDriver driver) {
		this.driver = driver;
	}
	
	public void OpenLogin() {
		driver.findElement(login).click();
	}
	
	public void enterEmail(String user_email) {
		driver.findElement(email).sendKeys(user_email);
	}
	
	public void enterPassword(String user_password) {
		driver.findElement(password).sendKeys(user_password);
	}
	public void clickLogin() {
		driver.findElement(login_button).click();
	}
	public String LoginTitle() {
		String title = driver.findElement(login_title).getText();
		return title;
	}

}
