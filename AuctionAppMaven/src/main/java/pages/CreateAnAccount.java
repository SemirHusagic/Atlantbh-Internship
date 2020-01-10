package pages;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAnAccount {
	
	public WebDriver driver;
	
	By createAccount = By.xpath("/html[1]/body[1]/app-root[1]/app-header[1]/header[1]/div[1]/div[2]/a[2]");
	By firstName = By.xpath("//input[@id='fName']");
	By lastName = By.xpath("//input[@id='lName']");
	By email = By.xpath("//input[@id='email']");
	By password = By.xpath("//input[@id='password']");
	By confirm_password = By.xpath("//input[@id='confirmPassword']");
	By registerButton = By.xpath("//button[contains(text(),'Register')]");
	By loginButton = By.xpath("//span[contains(text(),'Already have an account?')]");
	By scroolToMidle = By.xpath("//label[contains(text(),'Password')]");
	By register_title = By.xpath("//span[contains(text(),'register')]");
		
	public CreateAnAccount(WebDriver driver) {
		this.driver = driver;
	}
	
	public void openCreateAnAccount() {
		driver.findElement(createAccount).click();
	}
	
	public void enterFirstName(String first_name) {
		driver.findElement(firstName).sendKeys(first_name);
	}
	
	public void enterLastName(String last_name) {
		driver.findElement(lastName).sendKeys(last_name);
	}
	
	public void enterEmal(String user_email) {
		driver.findElement(email).sendKeys(user_email);
	}
	
	public void enterPassword(String user_password) {
		driver.findElement(password).sendKeys(user_password);
	}
	
	public void enterConfirmPassword(String user_confirm_password) {
		driver.findElement(confirm_password).sendKeys(user_confirm_password);
	}
	
	public void clickRegisterButton() {
		WebElement button = driver.findElement(registerButton);
		Actions action = new Actions(driver);		
		action.moveToElement(button).click().perform();
		

	}
	
	public void scroolPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(scroolToMidle));
        js.executeScript("arguments[0].scrollIntoView(true);", element);        
	}
	
	public void waitForElement() {
		WebElement button = driver.findElement(registerButton);
		WebDriverWait wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.elementToBeClickable(button));
	}
	
	public void clickLoginButton() {
		driver.findElement(loginButton).click();
	}
	
	public void waitForLoad() {
		Actions action = new Actions(driver);
		action.pause(java.time.Duration.ofSeconds(2)).perform();
	}
	public String getRegisterTitle() {
		String register = driver.findElement(register_title).getText();
		return register;
	}

}


