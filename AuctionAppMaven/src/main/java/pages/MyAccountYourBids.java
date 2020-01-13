package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class MyAccountYourBids {
	
	By myAccountButton = By.xpath("//body/app-root/app-header/nav[@class='navigation container']/div[@class='nav-links']/span[1]");
	By yourBidsButton = By.xpath("//span[contains(text(),'Your Bids')]");
	By topTable = By.xpath("//td[contains(text(),'Item')]");
	By productName = By.xpath("/html[1]/body[1]/app-root[1]/app-product-page[1]/section[1]/div[1]/h2[1]");
//	By = By.xpath("");
//	By = By.xpath("");
//	By = By.xpath("");
	
	public WebDriver driver;
	
	public MyAccountYourBids(WebDriver driver) {
		this.driver = driver;
	}
	
	public void openMyAccountMenu() {
		driver.findElement(myAccountButton).click();
	}
	
	public void clickYourBids() {
		driver.findElement(yourBidsButton).click();
	}
	
	public String getProductName() {
		String name = driver.findElement(productName).getText();
		return name;
	}
	
	public void selectProductAndClickView(String productName) {
		List<WebElement> rows = driver.findElements(By.xpath("//body//tbody//tr"));
		
		for(int i=1; i<=rows.size(); i++) {
			String product = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-profile[1]/app-bids[1]/section[1]/app-table[1]/section[1]/table[1]/tbody[1]/tr["+ i +"]/td[2]")).getText();
			if(product.compareTo(productName) == 0) {
				WebElement element = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-profile[1]/app-bids[1]/section[1]/app-table[1]/section[1]/table[1]/tbody[1]/tr["+ i +"]/td[2]"));
				element.getText();
				scrollTo(element);
				Assert.assertEquals(product, productName, "Product on which bid was made is not listed.");
				waitForLoad();
				break;
			}				
		}
	}
	
	
	
	public void scrollToBidTable() {
		WebElement element = driver.findElement(topTable);
		scrollTo(element);
		waitForLoad();
	}
	
	public void scrollTo(WebElement element) {		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public void waitForLoad() {
		Actions action = new Actions(driver);
		action.pause(java.time.Duration.ofSeconds(2)).perform();
	}

}
