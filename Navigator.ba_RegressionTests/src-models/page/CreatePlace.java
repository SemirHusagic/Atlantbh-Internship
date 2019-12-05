package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class CreatePlace {
	static WebElement element;
	public WebDriver driver = null;
	
	By createplace = By.xpath("//span[contains(text(),'Kreiraj objekat')]");
	By name = By.id("poi_name");
	By city = By.name("poi[city_name]");
	By street = By.name("poi[zip_code]");
	By zipcode = By.name("poi[zip_code]");
	By addcategory = By.className("ember-view btn btn-small");
	By menu1 = By.xpath("//div[@class='span3']//select");
	By menu2 = By.xpath("//div[3]//select[1]");
	By menu3 = By.xpath("//div[@class='span4']//select");
	By createbutton = By.xpath("//button[@class='btn btn-success']");
	By createPlaceSlideBar = By.xpath("//div[@class='mCSB_dragger']");
	By error_message = By.xpath("//div[@class='row validation-error-msg']");
	
	//Constructor
	public CreatePlace(WebDriver driver1) {
		this.driver = driver1;
	}	
	public void OpenCreatePlace() {
		driver.findElement(createplace).click();
	}
	
	public void enterName(String objectName) {
		driver.findElement(name).sendKeys(objectName);
	}
	
	public void enterCity(String cityName) {
		driver.findElement(city).sendKeys(cityName);
	}
	
	public void enterStreet(String streetName) {
		driver.findElement(street).sendKeys(streetName);
	}
	
	public void enterZipCode(String zipcodeNumber) {
		driver.findElement(zipcode).sendKeys(zipcodeNumber);
	}
	
	public void addCategoryOne(String catOne) {
        WebElement category = driver.findElement(addcategory);	        
        Actions action = new Actions(driver);
        action.moveToElement(category).click().perform();
        
        WebElement dropdown1 = driver.findElement(menu1);
        Select selectElement = new Select (dropdown1);
        selectElement.selectByValue(catOne);
        action.click();
        
	}
	public void addCategoryTwo(String catOne, String catTwo) {
        WebElement category = driver.findElement(addcategory);	        
        Actions action = new Actions(driver);
        action.moveToElement(category).click().perform();
        
        WebElement dropdown1 = driver.findElement(menu1);
        Select selectElement = new Select (dropdown1);
        selectElement.selectByValue(catOne);
        action.click();
        
        WebElement dropdown2 = driver.findElement(menu2);
        Select selectElement1 = new Select (dropdown2);
        selectElement1.selectByValue(catTwo);
        action.click();
	}
	public void addCategoryThree(String catOne, String catTwo, String catThree) {
        WebElement category = driver.findElement(addcategory);	        
        Actions action = new Actions(driver);
        action.moveToElement(category).click().perform();
        
        WebElement dropdown1 = driver.findElement(menu1);
        Select selectElement = new Select (dropdown1);
        selectElement.selectByValue(catOne);
        action.click();
        
        WebElement dropdown2 = driver.findElement(menu2);
        Select selectElement1 = new Select (dropdown2);
        selectElement1.selectByValue(catTwo);
        action.click();
        
        WebElement dropdown3 = driver.findElement(menu3);
        Select selectElement2 = new Select (dropdown3);
        selectElement2.selectByValue(catThree);
        action.click();
	}
	
	public void moveMarkerLeft(String pixels)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementsByClassName('leaflet-marker-icon')[0].style.marginLeft = \"" + pixels + "\"");
	}
	
	public void scroolCreatePlaceWindowToBottom() {
		Actions action = new Actions(driver);
		WebElement createButton = driver.findElement(createbutton);
        WebElement slideBar = driver.findElement(createPlaceSlideBar);
        action.clickAndHold(slideBar).moveToElement(createButton).release().build().perform();
        action.moveToElement(createButton).click().perform();       
	}
	
	public void clickCreateButton() {
		driver.findElement(createbutton).click();
	}
	
	public String errorMessage() {
		String message = driver.findElement(error_message).getText();
		return message;
	}
	

}
