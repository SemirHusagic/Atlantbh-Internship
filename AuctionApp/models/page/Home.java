package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class Home {
	
	public WebDriver driver;
	
	By bidNowButton = By.xpath("//a[contains(text(),'bid now')]");
	By homeText = By.xpath("//h3[contains(text(),'Categories')]");
	
	public Home(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickBidNow() {
		WebElement element = driver.findElement(bidNowButton);
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
	}
	
	public void waitForLoad() {
		Actions action = new Actions(driver);
		action.pause(java.time.Duration.ofSeconds(5)).perform();
	}
	
	public String pageTitle() {
		String title = driver.findElement(homeText).getText();
		return title;
	}

}
