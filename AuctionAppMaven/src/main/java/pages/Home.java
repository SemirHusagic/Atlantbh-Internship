package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class Home {
	
	private String home_page_text = "MY ACCOUNT";
	private String home_message = "Home page did not load correctly.";
	
	By bidNowButton = By.xpath("/html[1]/body[1]/app-root[1]/app-landing-page[1]/section[1]/div[1]/div[1]/app-carousel[1]/div[1]/div[1]/div[1]/a[1]");
	By homeText = By.xpath("//a[contains(text(),'my account')]");
	By homeButton = By.xpath("//a[contains(text(),'home')]");
	By openShop = By.xpath("//a[contains(text(),'shop')]");
	By aboutUs = By.xpath("//a[contains(text(),'About Us')]");
	By termsAndConditions = By.xpath("//a[contains(text(),'Terms and Conditions')]");
	By privacyAndPolicy = By.xpath("//a[contains(text(),'Privacy and Policy')]");
	By aboutUsTitle = By.xpath("//span[contains(text(),'about us')]");
	By termsAndConditionsTitle = By.xpath("//span[contains(text(),'terms and conditions')]");
	By privacyAndPolicyTitle = By.xpath("//span[contains(text(),'privacy and policy')]");
//	By  = By.xpath("");
//	By  = By.xpath("");
//	By  = By.xpath("");
	
	public WebDriver driver;
	
	public Home(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnHomeButton() {
		WebElement element = driver.findElement(homeButton);
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
	}
	
	public void clickBidNow() {		
		WebDriverWait wait = new WebDriverWait(driver, 60); 
	    wait.until(ExpectedConditions.visibilityOfElementLocated(bidNowButton)); 
	    driver.findElement(bidNowButton).click();
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
	
	public void openAboutUs() {
		driver.findElement(aboutUs).click();
		waitForLoad();
	}
	
	public void openTermsAndConditions() {
		driver.findElement(termsAndConditions).click();
		waitForLoad();
	}
	
	public void openPrivacyAndPolicy() {
		driver.findElement(privacyAndPolicy).click();
		waitForLoad();
	}
	
	public String aboutUsTitle() {
		String title = driver.findElement(aboutUs).getText();
		System.out.println(title);
		return title;
	}
	
	public String termsAndConditionsTitle() {
		String title = driver.findElement(termsAndConditions).getText();
		System.out.println(title);
		return title;
	}
	
	public String privacyAndPolicyTitle() {
		String title = driver.findElement(privacyAndPolicy).getText();
		System.out.println(title);
		return title;
	}
	
	
	public void scrollToBottom() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        waitForLoad();
	}
}


