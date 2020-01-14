package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Login {
	
	private String titlePage = "LOGIN";
	private String loginMessage = "Login page did not load correctly.";
	
	By login = By.xpath("//a[contains(text(),'Login')]");
	By email = By.xpath("/html[1]/body[1]/app-root[1]/app-login[1]/section[1]/form[1]/div[1]/app-input[1]/div[1]/div[1]/input[1]");
	By password = By.xpath("//input[@id='password']");
	By loginButton = By.xpath("//button[@class='login-button']");
	By forgotPassword = By.xpath("//a[@class='forgot-password']");
	By loginTitle = By.xpath("/html[1]/body[1]/app-root[1]/app-login[1]/app-breadcrumb[1]/div[1]/div[1]/span[1]");
	By loginNotification = By.xpath("/html[1]/body[1]/app-root[1]/app-login[1]/app-alert[1]/div[1]/div[1]/div[1]");
	
	public WebDriver driver;
	
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
		driver.findElement(loginButton).click();
	}
	
	public String loginNotificationMessage() {
		String message = driver.findElement(loginNotification).getText();
		return message;
	}
	public void loginTitle() {
		String title = driver.findElement(loginTitle).getText();
		Assert.assertTrue(title.contains(titlePage), loginMessage);		
	}
	
	public void scroolToLogin() {		
		WebElement element = driver.findElement(loginTitle);
		scrollTo(element);
		waitForLoad();
	}
	
	public void waitForLoad() {
		Actions action = new Actions(driver);
		action.pause(java.time.Duration.ofSeconds(1)).perform();
	}
	
	public void scrollTo(WebElement element) {		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
}