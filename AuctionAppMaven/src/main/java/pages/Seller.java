package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

public class Seller {
	
	By sellerButton = By.xpath("/html[1]/body[1]/app-root[1]/app-profile[1]/ul[1]/li[2]/a[1]");
	By activeProductButton = By.xpath("/html[1]/body[1]/app-root[1]/app-profile[1]/app-seller[1]/section[1]/ul[1]/li[1]/p[1]");
	By soldProductButton = By.xpath("/html[1]/body[1]/app-root[1]/app-profile[1]/app-seller[1]/section[1]/ul[1]/li[2]/p[1]");
	By productName = By.xpath("/html[1]/body[1]/app-root[1]/app-product-page[1]/section[1]/div[1]/h2[1]");
	By sellerPageTittle= By.xpath("//li[contains(text(),'seller')]");
//	By = By.xpath("");
//	By = By.xpath("");
//	By = By.xpath("");
//	By = By.xpath("");
//	By = By.xpath("");
//	By = By.xpath("");
//	By = By.xpath("");
	
	public WebDriver driver;
	
	public Seller(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickSeller() {
		driver.findElement(sellerButton).click();
	}
	
	public void findProduct(String product) {
		WebElement element = driver.findElement(By.xpath("//td[contains(text(),'"+ product +"')]"));
		scrollTo(element);
		waitForLoad();		
	}
	
	public void selectProductAndClickView(String productName) {
		List<WebElement> rows = driver.findElements(By.xpath("//body//tbody//tr"));
		
		for(int i=1; i<=rows.size(); i++) {
			String product = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-profile[1]/app-seller[1]/section[1]/app-table[1]/section[1]/table[1]/tbody[1]/tr["+ i +"]/td[2]")).getText();

			if(product.compareTo(productName) == 0) {
				WebElement element = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-profile[1]/app-seller[1]/section[1]/app-table[1]/section[1]/table[1]/tbody[1]/tr["+ i +"]/td[2]"));
				scrollToProduct(element);
				waitForLoad();
				driver.findElement(By.xpath("//tr["+ i +"]//td[8]//a[1]")).click();
				break;
			}				
		}
	}
	
	public String verifyProductAuction() {
		String nameOfProduct = driver.findElement(productName).getText();
		return nameOfProduct;
	}
	
	
	public void scrollActiveProducts() {
		WebElement element = driver.findElement(activeProductButton);
		scrollTo(element);
		waitForLoad();
	}
	
	public void waitForLoad() {
		Actions action = new Actions(driver);
		action.pause(java.time.Duration.ofSeconds(2)).perform();
	}
	
	public void scrollTo(WebElement element) {		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}	
	
	
	public void scrollToProduct(WebElement element) {		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}	
	
	public String getSellerPageTittle() {
		String title = driver.findElement(sellerPageTittle).getText();
		return title;
	}
}