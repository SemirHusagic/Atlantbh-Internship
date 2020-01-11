package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Shop {
	
	private String expectedShopPageTitle = "SHOP";
	private String messageShopPageTitle = "Shop page did not load correctly.";
	private String expectedDescendingText = "Sort by Price Descending";
	private String messageDescendingPrice = "The products did not show up in descending order.";
	private String expectedAscendingText = "Sort by Price Ascending";
	private String messageAscendingPrice = "The products did not show up in ascending order.";
	private String timeDescending = "Sort by Time Left Descending";
	private String expectedTimeDescending = "Sort by Time Left Descending";
	private String messageTimeDescending = "The products did not show up in time descending order.";
	private String expectetTimeAscending = " Sort by Time Left Ascending ";
	private String messageTimeAscending = "The products did not show up in time ascending order.";
	
	By openShop = By.xpath("//a[contains(text(),'shop')]");
	By grid = By.xpath("//span[@class='active']");
	By list = By.xpath("//span[contains(text(),'List')]");
	By dropdownSorting = By.xpath("//div[@class='dropdown']");
	By priceDescengind = By.xpath("//li[contains(text(),'Sort by Price Descending')]");
	By priceAscending  = By.xpath("//li[contains(text(),'Sort by Price Ascending')]");
	By timeLeftDescending  = By.xpath("//li[contains(text(),'Sort by Time Left Descending')]");
	By timeLeftAscending  = By.xpath("//li[contains(text(),'Sort by Time Left Ascending')]");
	By fashion = By.xpath("//li[contains(text(),'Fashion')]");
	By accessories = By.xpath("//li[contains(text(),'Accessories')]");
	By jewelry = By.xpath("//li[contains(text(),'Jewelry')]");
	By shoes = By.xpath("//li[contains(text(),'Shoes')]");
	By sportware = By.xpath("//li[contains(text(),'Sportware')]");
	By home = By.xpath("//li[contains(text(),'Home')]");
	By electronics = By.xpath("//li[contains(text(),'Electronics')]");
	By mobile = By.xpath("//li[contains(text(),'Mobile')]");
	By computer = By.xpath("//li[contains(text(),'Computer')]");
	By shopPageTitle = By.xpath("//span[contains(text(),'shop')]");
	By firstProduct = By.xpath("//body//app-collection-item[1]");
	By secondProduct = By.xpath("//body//app-collection-item[2]");
	By descendingText = By.xpath("//p[contains(text(),'Sort by Price Descending')]");
	By ascendingText = By.xpath("//p[contains(text(),'Sort by Price Ascending')]");
	By shopTitle = By.xpath("//span[contains(text(),'shop')]");
//	By  = By.xpath("");
	
	public WebDriver driver;
	
	public Shop(WebDriver driver) {
		this.driver = driver;
	}
	
	public void waitForLoad() {
		Actions action = new Actions(driver);
		action.pause(java.time.Duration.ofSeconds(2)).perform();
	}
	
	public void clickOnShopButton() {
		driver.findElement(openShop).click();
	}
	
	public void clickGrid() {
		driver.findElement(grid).click();
	}
	
	public void clickList() {
		driver.findElement(list).click();
	}
	
	public void clickDeafultSorting() {
		driver.findElement(dropdownSorting).click();
	}
	
	public void clickPriceDescending() {
		driver.findElement(priceDescengind).click();
	}
	
	public void clickPriceAscending() {
		driver.findElement(priceAscending).click();
	}
	
	public void clickTimeDescending() {
		driver.findElement(timeLeftDescending).click();
	}
	
	public void clickTimeAscending() {
		driver.findElement(timeLeftAscending).click();
	}
	
	public String getFirstProductPrice() {
		return driver.findElement(firstProduct).getText();
	}
	
	public String getSecondProductPrice() {
		return driver.findElement(secondProduct).getText();
	}
	
	public String parsePrice(String s) {
		//parse the first double value after the '$' sign
		String value = "";
		
		for(int i=0; i < s.length(); i++) {
			if(s.charAt(i) == '$') {
				i++;
				while(s.charAt(i) != '.') {
					value += s.charAt(i);
					i++;
				}
				for(int j = i; j < i+3; j++)
					value += s.charAt(j);
				break;
			}
		}
		return value;
	}
	
	public void comperPricesAndVerifySorting() {
		
			String dropdown = driver.findElement(dropdownSorting).getText();
 			//Auction started
 			String firstProductDetails = getFirstProductPrice();
 			String secondProductDetails = getSecondProductPrice();
 			
 			//Parse price form details
 			String fp = parsePrice(firstProductDetails);
 			String sp = parsePrice(secondProductDetails);
 			
 			//Cast/change type from String to Double
 			fp = fp.replace(",", "");
 			double firstProduct = Double.parseDouble(fp);
 			sp = sp.replace(",", "");
 			double secondProduct = Double.parseDouble(sp);
 			 			
 			//Return next bid value
 			if(firstProduct > secondProduct) {
 				
 				Assert.assertEquals(dropdown, expectedDescendingText, messageDescendingPrice);
 			}
 			else if(firstProduct < secondProduct) {
 				
 				Assert.assertEquals(dropdown, expectedAscendingText, messageAscendingPrice);
 			} 			
 	}
	
	public void scrollToShopTitle() {
		WebElement element = driver.findElement(shopTitle);
		scrollTo(element);
		waitForLoad();
	}
	
	
	public void scrollTo(WebElement element) {		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public void verifyTimeSorting() {
		String dropdown = driver.findElement(dropdownSorting).getText();
		if(dropdown.indexOf(timeDescending) != -1)
				Assert.assertEquals(dropdown, expectedTimeDescending, messageTimeDescending);
		else
				Assert.assertEquals(dropdown, expectetTimeAscending, messageTimeAscending);
	}
	
	
	public void verifyShopIsOpen() {
		String shopTitle = driver.findElement(shopPageTitle).getText();
		Assert.assertEquals(shopTitle, expectedShopPageTitle, messageShopPageTitle);
	}
}