package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SuggestFeatures {
	public WebDriver driver;
	static WebElement element;
	
	By suggestfeatures = By.xpath("//span[contains(text(),'alji komentar')]");
	By nameandsurname = By.name("name_surname");
	By email = By.className("emailcheck");
	By comment = By.className("required");
	By greencheck = By.className("green");
	By redcheck = By.className("red");
	By sendbutton = By.xpath("//input[@class='btn green-button']");
	By canclebutton = By.className("btn grey-button");
		
	//Constructor
	public SuggestFeatures(WebDriver driver) {
		this.driver = driver;		
	}
	
	public void opetSuggestFeatures() {
		driver.findElement(suggestfeatures).click();
	}
	public void enterNameAndSurname(String name) {
		driver.findElement(nameandsurname).sendKeys(name);
	}
	public void enterEmail(String Email) {
		driver.findElement(email).sendKeys(Email);
	}
	public void enterComment(String Comment) {
		driver.findElement(comment).sendKeys(Comment);
	}
	public void markGreenCheck() {
		driver.findElement(greencheck).click();
	}
	public void markRedCheck() {
		driver.findElement(redcheck).click();
	}
	public void clickSendButton() {
		driver.findElement(sendbutton).click();
	}
	public void clickCancleButton() {
		driver.findElement(canclebutton).click();
	}
}
