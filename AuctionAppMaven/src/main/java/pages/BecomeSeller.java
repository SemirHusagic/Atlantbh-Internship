package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class BecomeSeller {
	
	private String expectedStartSelling = "SELL";
	private String messageSartSelling = "There is problem with start selling product.";
	private String expectedDetailInformation = "DETAIL INFORMATION ABOUT PRODUCT";
	private String messageDeatailInformation = "Form for selling product is not shown.";
	private String pictureOnePath = "/Users/semir/Desktop/picture1.jpg";
	private String pictureTwoPath = "/Users/semir/Desktop/picture2.jpg";
	private String pictureThreePath = "/Users/semir/Desktop/picture3.jpg";

	
	By myAccountButton = By.xpath("//body/app-root/app-header/nav[@class='navigation container']/div[@class='nav-links']/span[1]");
	By becomeSeller = By.xpath("//span[contains(text(),'Become Seller')]");
	By buttonStartSelling= By.xpath("//button[contains(text(),'start selling')]");
	By noProductSellByNow = By.xpath("//html//body//app-root//app-profile//app-add-product");
	By sellTitle = By.xpath("/html[1]/body[1]/app-root[1]/app-profile[1]/app-add-product[1]/app-no-active[1]/section[1]/div[1]/h3[1]");
	By detailInformationTitle = By.xpath("/html[1]/body[1]/app-root[1]/app-profile[1]/app-add-product[1]/section[1]/div[1]/h3[1]");
	By detailInformation = By.xpath("//html//body//app-root//app-profile//app-add-product");
	By productName = By.xpath("//input[@id='name']");
	By selectCategory = By.xpath("//div[@class='category']//app-select-input[1]//div[1]//div[1]//p[1]");
	By selectCategoryDropdown= By.xpath("//li[contains(text(),'Accessories')]");
	By selectSubcategory = By.xpath("//app-first-step//app-select-input[2]//div[1]//div[1]//p[1]");
	By selectSubcategoryDropdown = By.xpath("//li[contains(text(),\"Women's Accessories\")]");
	By selectBrand = By.xpath("//div[@class='brand']//p[@class='paragraphDropdown']");
	By selectBrandDropdown = By.xpath("//li[contains(text(),'Ray-Ban')]");
	By selectColor = By.xpath("/html[1]/body[1]/app-root[1]/app-profile[1]/app-add-product[1]/section[1]/div[1]/div[1]/app-first-step[1]/div[1]/div[3]/app-select-input[1]/div[1]/div[1]/p[1]");
	By selectColorDropdown = By.xpath("//li[contains(text(),'black')]");
	By selectMaterial = By.xpath("/html[1]/body[1]/app-root[1]/app-profile[1]/app-add-product[1]/section[1]/div[1]/div[1]/app-first-step[1]/div[1]/div[3]/app-select-input[2]/div[1]/div[1]/p[1]");
	By selectMaterialDropdown = By.xpath("//li[contains(text(),'wood')]");
	By descriptionTitle= By.xpath("//label[contains(text(),'Description')]");
	By descriptionBox = By.xpath("//textarea[@id='description']");
	By uploadBox = By.xpath("/html[1]/body[1]/app-root[1]/app-profile[1]/app-add-product[1]/section[1]/div[1]/div[1]/app-first-step[1]/div[1]/app-upload-images[1]/div[1]/input[1]");
	By scroolToNextButton = By.xpath("/html[1]/body[1]/app-root[1]/app-profile[1]/app-add-product[1]/section[1]/div[1]/div[1]/app-first-step[1]/div[1]/div[4]/p[1]");
	By nextButton = By.xpath("//div[@class='first-step show']//button[@class='next'][contains(text(),'next')]");
	
//	vec ima 				 /html[1]/body[1]/app-root[1]/app-profile[1]/app-add-product[1]/section[1]/div[1]/div[1]/app-first-step[1]/div[1]/div[5]/button[1]
//							 /html[1]/body[1]/app-root[1]/app-profile[1]/app-add-product[1]/section[1]/div[1]/div[1]/app-first-step[1]/div[1]/div[5]/button[2]
	//div[@class='first-step show']//button[@class='next'][contains(text(),'next')]
	//div[@class='first-step show']//button[@class='next'][contains(text(),'next')]
	
	By setPricesTitle = By.xpath("/html[1]/body[1]/app-root[1]/app-profile[1]/app-add-product[1]/section[1]/div[1]/h3[1]");
	By productPrice = By.xpath("//input[@placeholder='Enter product price']");
	By startDate = By.xpath("/html[1]/body[1]/app-root[1]/app-profile[1]/app-add-product[1]/section[1]/div[1]/div[1]/app-second-step[1]/div[1]/div[2]/app-custom-date-input[1]/div[1]/div[1]/input[1]");
	By endDate = By.xpath("/html[1]/body[1]/app-root[1]/app-profile[1]/app-add-product[1]/section[1]/div[1]/div[1]/app-second-step[1]/div[1]/div[2]/app-custom-date-input[2]/div[1]/div[1]/input[1]");
	By setPriceNextButton= By.xpath("/html[1]/body[1]/app-root[1]/app-profile[1]/app-add-product[1]/section[1]/div[1]/div[1]/app-second-step[1]/div[1]/div[3]/button[2]");
	By locationAndShipingTitle = By.xpath("/html[1]/body[1]/app-root[1]/app-profile[1]/app-add-product[1]/section[1]/div[1]/h3[1]");
	By address = By.xpath("//input[@id='address']");
	By county = By.xpath("//input[@id='country']");
	By city = By.xpath("//input[@id='city']");
	By zipcode = By.xpath("//input[@id='zip']");
	By phone = By.xpath("//input[@id='phone']");
	By cardInformationTitle= By.xpath("/html[1]/body[1]/app-root[1]/app-profile[1]/app-add-product[1]/section[1]/div[1]/div[1]/app-last-step[1]/div[1]/div[4]/h3[1]");
	By cardName = By.xpath("//input[@id='cName']");
	By cardNumber = By.xpath("//input[@id='cNumber']");
	By cardYearExpiration = By.xpath("//app-last-step//app-select-input[1]//div[1]//div[1]//p[1]");
	By cardMonthExpiration = By.xpath("//app-last-step//app-select-input[2]//div[1]//div[1]//p[1]");
	By cvc = By.xpath("//input[@id='cvc']");
	By doneButton = By.xpath("/html[1]/body[1]/app-root[1]/app-profile[1]/app-add-product[1]/section[1]/div[1]/div[1]/app-last-step[1]/div[1]/div[5]/button[2]");
//	By = By.xpath("");
//	By = By.xpath("");
//	By = By.xpath("");
//	By = By.xpath("");
	
	public WebDriver driver;
	
	public BecomeSeller(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickMyAccountButton() {
		driver.findElement(myAccountButton).click();
	}
	
	public void clickBecomeSellerButton() {
		driver.findElement(becomeSeller).click();
	}
	
	public void clickStartSellerButton() {
		String startSelling = driver.findElement(noProductSellByNow).getText();
		
		if(startSelling.indexOf(expectedStartSelling) != -1) {
		String actualSellingTitle = driver.findElement(sellTitle).getText();
		driver.findElement(buttonStartSelling).click();
		Assert.assertEquals(actualSellingTitle, expectedStartSelling, messageSartSelling);
		}
		else {
			String alreadySell = driver.findElement(detailInformationTitle).getText();
			Assert.assertEquals(alreadySell, expectedDetailInformation, messageDeatailInformation);
		}
	}
	
	public void enterProductName(String nameOfProduct) {
		driver.findElement(productName).sendKeys(nameOfProduct);
	}
	
	public void enterSelectCategory() {
		driver.findElement(selectCategory).click();
		driver.findElement(selectCategoryDropdown).click();		
	}
	
	public void enterSelectSubcategory() {
		driver.findElement(selectSubcategory).click();
		driver.findElement(selectSubcategoryDropdown).click();		
	}
	
	public void enterSelectBrand() {
		driver.findElement(selectBrand).click();
		driver.findElement(selectBrandDropdown).click();		
	}
	
	public void enterSelectColor() {
		driver.findElement(selectColor).click();
		driver.findElement(selectColorDropdown).click();		
	}
	
	public void enterSelectMaterial() {
		driver.findElement(selectMaterial).click();
		driver.findElement(selectMaterialDropdown).click();		
	}
	
	public void enterDescription(String text) {
		driver.findElement(descriptionBox).sendKeys(text);
	}
	
	public void uploadPictures() {
		driver.findElement(uploadBox).sendKeys(pictureOnePath + "\n" + pictureTwoPath + "\n" + pictureThreePath);
	}
	
	public void clickNextButton() {
		driver.findElement(nextButton).click();
	}
	
	public void enterProductPrice(String price) {
		driver.findElement(productPrice).sendKeys(price);
	}
	
	public void clickNextButtonOnSetPrice() {
		driver.findElement(setPriceNextButton).click();
	}
	
	public void enterStartDate(String date) {
		driver.findElement(startDate).sendKeys(date);
	}
	
	public void enterEndDate(String date) {
		driver.findElement(endDate).sendKeys(date);
	}
	
	public void enterAddress(String Address) {
		driver.findElement(address).sendKeys(Address);
	}
	
	public void enterCountry(String Country) {
		driver.findElement(county).sendKeys(Country);
	}
	
	public void enterCity(String City) {
		driver.findElement(city).sendKeys(City);
	}
	
	public void enterZipcode(String Zipcode) {
		driver.findElement(zipcode).sendKeys(Zipcode);
	}
	
	public void enterPhone(String Phone) {
		driver.findElement(phone).sendKeys(Phone);
	}
	
	public void enterCardName(String Name) {
		driver.findElement(cardName).clear();
		driver.findElement(cardName).sendKeys(Name);
	}
	
	public void enterCardNumber(String Number) {		
		driver.findElement(cardNumber).clear();
		driver.findElement(cardNumber).sendKeys(Number);
	}
	
	public void enterCardExperationYear(String Year, String Month) {		
		driver.findElement(cardYearExpiration).click();
		driver.findElement(By.xpath("//li[contains(text(),'" + Year + "')]")).click();
		driver.findElement(cardMonthExpiration).click();
		driver.findElement(By.xpath("//html[1]/body[1]/app-root[1]/app-profile[1]/app-add-product[1]/section[1]/div[1]/div[1]/app-last-step[1]/div[1]/div[4]/div[2]/div[1]/div[1]/app-select-input[2]/div[1]/div[1]/ul[1]/li[" + Month + "]")).click();
	}
	
	public void enterCVC(String CVC) {		
		driver.findElement(cvc).clear();
		driver.findElement(cvc).sendKeys(CVC);
	}
	
	public void clickDoneButton() {
		driver.findElement(doneButton).click();
	}
	
	public void scrollToDetailinformation() {
		WebElement element = driver.findElement(detailInformationTitle);
		scrollTo(element);
		waitForLoad();
	}
	
	public void scrollToDescription() {
		WebElement element = driver.findElement(descriptionTitle);
		scrollTo(element);
		waitForLoad();
	}
	
	public void scrollToNextButton() {
		WebElement element = driver.findElement(scroolToNextButton);
		scrollTo(element);
		waitForLoad();
	}
	
	public void scrollToSetPrices() {
		WebElement element = driver.findElement(setPricesTitle);
		scrollTo(element);
		waitForLoad();
	}
	
	public void scrollToLocationAndShiping() {
		WebElement element = driver.findElement(locationAndShipingTitle);
		scrollTo(element);
		waitForLoad();
	}
	
	public void scrollToCardInformation() {
		WebElement element = driver.findElement(cardInformationTitle);
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


