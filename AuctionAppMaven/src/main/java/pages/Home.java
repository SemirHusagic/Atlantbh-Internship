package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


public class Home {
	
	private String home_page_text = "MY ACCOUNT";
	private String home_message = "Home page did not load correctly.";
	
	public WebDriver driver;
	
	By bidNowButton = By.xpath("//a[contains(text(),'bid now')]");
	By homeText = By.xpath("//a[contains(text(),'my account')]");
	By homeButton = By.xpath("//a[contains(text(),'home')]");
	By openShop = By.xpath("//a[contains(text(),'shop')]");
	
	public Home(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnHomeButton() {
		WebElement element = driver.findElement(homeButton);
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
	}
	
	public void clickBidNow() {
		WebElement element = driver.findElement(bidNowButton);
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
	}
	
	public void clickOnShopButton() {
		driver.findElement(openShop).click();
	}
	
	public void waitForLoad() {
		Actions action = new Actions(driver);
		action.pause(java.time.Duration.ofSeconds(3)).perform();
	}
	
	public void homePageTitle() {
		String title = driver.findElement(homeText).getText();
		Assert.assertTrue(title.contains(home_page_text), home_message);
	}
}


