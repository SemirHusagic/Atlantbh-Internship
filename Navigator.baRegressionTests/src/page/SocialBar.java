package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SocialBar {
	
	WebDriver driver;
	public WebDriver element;
	
	By facebook = By.className("iconav-facebook");
	By twitter = By.className("iconav-twitter-2");
	By googleplus = By.className("iconav-googleplus");

	public SocialBar (WebDriver driver) {
		this.driver = driver;
	}
	
	public void opetFacebook() {
		driver.findElement(facebook).click();
	}
	public void opetTwitter() {
		driver.findElement(twitter).click();
	}
	public void openGooglePlus() {
		driver.findElement(googleplus).click();
	}
}
