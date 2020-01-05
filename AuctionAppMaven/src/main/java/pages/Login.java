package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Login {
	
	private String title_page = "LOGIN";
	private String login_message = "Login page did not load correctly.";
	
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
	
	public void openLogin() {
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
	public void loginTitle() {
		String title = driver.findElement(login_title).getText();
		Assert.assertTrue(title.contains(title_page), login_message);		
	}

}



