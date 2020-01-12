package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ProductCategories {
	
	By openShop = By.xpath("/html[1]/body[1]/app-root[1]/app-header[1]/nav[1]/div[3]/a[2]");
	By fashion = By.xpath("//li[contains(text(),'Fashion')]");
	By jeans = By.xpath("/html[1]/body[1]/app-root[1]/app-shop-page[1]/section[1]/div[1]/app-categories-list[1]/ul[1]/li[1]/ul[1]/li[1]/a[1]");
	By vintage = By.xpath("/html[1]/body[1]/app-root[1]/app-shop-page[1]/section[1]/div[1]/app-categories-list[1]/ul[1]/li[1]/ul[1]/li[2]/a[1]");
	By accessories = By.xpath("//li[contains(text(),'Accessories')]");
	By womenAccessories = By.xpath("/html[1]/body[1]/app-root[1]/app-shop-page[1]/section[1]/div[1]/app-categories-list[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]");
	By jewelry = By.xpath("//li[contains(text(),'Jewelry')]");
	By wristwatches = By.xpath("/html[1]/body[1]/app-root[1]/app-shop-page[1]/section[1]/div[1]/app-categories-list[1]/ul[1]/li[3]/ul[1]/li[1]/a[1]");
	By shoes = By.xpath("//li[contains(text(),'Shoes')]");
	By sneakers = By.xpath("/html[1]/body[1]/app-root[1]/app-shop-page[1]/section[1]/div[1]/app-categories-list[1]/ul[1]/li[4]/ul[1]/li[1]/a[1]");
	By sportware = By.xpath("//li[contains(text(),'Sportware')]");
	By sweatshirts = By.xpath("/html[1]/body[1]/app-root[1]/app-shop-page[1]/section[1]/div[1]/app-categories-list[1]/ul[1]/li[5]/ul[1]/li[1]/a[1]");
	By home = By.xpath("//li[contains(text(),'Home')]");
	By lamps = By.xpath("/html[1]/body[1]/app-root[1]/app-shop-page[1]/section[1]/div[1]/app-categories-list[1]/ul[1]/li[6]/ul[1]/li[1]/a[1]");
	By electronics = By.xpath("//li[contains(text(),'Electronics')]");
	By camera = By.xpath("/html[1]/body[1]/app-root[1]/app-shop-page[1]/section[1]/div[1]/app-categories-list[1]/ul[1]/li[7]/ul[1]/li[1]/a[1]");
	By mobile = By.xpath("//li[contains(text(),'Mobile')]");
	By phones = By.xpath("/html[1]/body[1]/app-root[1]/app-shop-page[1]/section[1]/div[1]/app-categories-list[1]/ul[1]/li[8]/ul[1]/li[1]/a[1]");
	By computer = By.xpath("//li[contains(text(),'Computer')]");
	By laptops = By.xpath("/html[1]/body[1]/app-root[1]/app-shop-page[1]/section[1]/div[1]/app-categories-list[1]/ul[1]/li[9]/ul[1]/li[1]/a[1]");
	By shopTitle = By.xpath("//span[contains(text(),'shop')]");
	By jeansTitle = By.xpath("//li[contains(text(),'Jeans')]");
	By vintageTitle = By.xpath("//li[contains(text(),'Vintage')]");
	By womenAccessoriesTitle = By.xpath("//li[contains(text(),\"Women's Accessories\")]");  
	By wristwatchesTitle = By.xpath("//li[contains(text(),'Wristwatches')]");
	By sneakersTitle = By.xpath("//li[contains(text(),'Sneakers')]");
	By sweatshirtsTitle = By.xpath("//li[contains(text(),'Sweatshirts')]");
	By lampsTitle = By.xpath("//li[contains(text(),'Lamps')]");
	By cameraTitle = By.xpath("//li[contains(text(),'Camera')]");
	By phonesTitle = By.xpath("//li[contains(text(),'Phones')]");
	By laptopsTitle = By.xpath("//li[contains(text(),'Laptops')]");
	By text = By.xpath("/html[1]/body[1]/app-root[1]/app-shop-page[1]/app-breadcrumb[1]/div[1]/div[1]/ul[1]/li[2]");
	
	
	public WebDriver driver;
	
	public ProductCategories(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnShopButton() {
		WebElement element = driver.findElement(openShop);
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();		
	}
	
	public void close() {
		WebElement element = driver.findElement(openShop);
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
		waitForLoad();
	}
	
	public void clickFashion() {
		driver.findElement(fashion).click();
		waitForLoad();
	}	
	
	public void clickJeans() {
		driver.findElement(jeans).click();
		waitForLoad();
	}	
	
	public void clickVintage() {
		driver.findElement(vintage).click();
		waitForLoad();
	}	
	
	public void clickAccessories() {
		driver.findElement(accessories).click();
		waitForLoad();
	}
	
	public void clickWomenAccessories() {		
		WebElement element = driver.findElement(womenAccessories);
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
		waitForLoad();
	}	
	
	public void clickJewelry() {
		driver.findElement(jewelry).click();
		waitForLoad();
	}
	
	public void clickWristwatches() {
		driver.findElement(wristwatches).click();
		waitForLoad();
	}	
	
	public void clickShoes() {
		driver.findElement(shoes).click();
		waitForLoad();
	}
	
	public void clickSneakers() {
		driver.findElement(sneakers).click();
		waitForLoad();
	}
	
	public void clickSportware() {
		driver.findElement(sportware).click();
		waitForLoad();
	}
	
	public void clickSweatshirts() {
		driver.findElement(sweatshirts).click();
		waitForLoad();
	}	
	
	public void clickHome() {
		driver.findElement(home).click();
		waitForLoad();
	}
	
	public void clickLamps() {
		driver.findElement(lamps).click();
		waitForLoad();
	}	
	
	public void clickElectronics() {
		driver.findElement(electronics).click();
		waitForLoad();
	}
	
	public void clickCamera() {
		driver.findElement(camera).click();
		waitForLoad();
	}
	
	public void clickMobile() {
		driver.findElement(mobile).click();
		waitForLoad();
	}
	
	public void clickPhones() {
		driver.findElement(phones).click();
		waitForLoad();
	}	
	
	public void clickComputer() {
		driver.findElement(computer).click();
		waitForLoad();
	}
	
	public void clickLaptops() {
		driver.findElement(laptops).click();
		waitForLoad();
	}
	
	public String getTitle() {
		String name = driver.findElement(text).getText();
		return name;
	}
	
	public void scrollToShopTitle() {
		WebElement element = driver.findElement(shopTitle);
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
