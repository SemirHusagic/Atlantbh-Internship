package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class MyAccountProfile {
	
	private String profileUpdate = "Profile info updated";
	private String profileIsntUpdateProperly = "Profile is not properly update.";
	private String noChanges = "No changes to user profile are made";
	private String noChangesOnProfile = "Profile should remain un-upgraded.";
	private String expectedProfileTitle = "PROFILE";
	private String messageProfileTitle = "Profile page did not load correctly.";
	private String expectedFirstName = "Please enter the first name that is not longer than 100 characters";
	private String messageFirstName = "Something went wrong when enter more than 100 characters in first name.";
	private String expectedLastName = "Please enter the last name that is not longer than 100 characters";
	private String messageLastName = "Something went wrong when enter more than 100 characters in last name.";
	
	By myAccountButton = By.xpath("//body/app-root/app-header/nav[@class='navigation container']/div[@class='nav-links']/span[1]");
	By profileButton = By.xpath("//span[contains(text(),'Profile')]");
	By firstName = By.xpath("//input[@id='firstName']");
	By lastName = By.xpath("//input[@id='lastName']");
	By gender = By.xpath("/html[1]/body[1]/app-root[1]/app-profile[1]/app-edit-profile[1]/section[1]/form[1]/app-required-info[1]/div[1]/div[2]/div[2]/app-select-input[1]/div[1]/div[1]/p[1]");
	By maleGender = By.xpath("//li[contains(text(),'Male')]");
	By femaleGender = By.xpath("//li[contains(text(),'Female')]");
	By otherGender = By.xpath("//li[@class='ng-star-inserted active']");
	By year = By.xpath("//app-required-info//app-date-input//app-select-input[1]//div[1]//div[1]//p[1]");
	By month = By.xpath("//app-required-info//app-select-input[2]//div[1]//div[1]//p[1]");
	By day = By.xpath("//app-select-input[3]//div[1]//div[1]//p[1]");
	By phoneNumber = By.xpath("/html[1]/body[1]/app-root[1]/app-profile[1]/app-edit-profile[1]/section[1]/form[1]/app-required-info[1]/div[1]/div[2]/div[2]/app-input[3]/div[1]/div[1]/input[1]");
	By email = By.xpath("//input[@id='email']");
	By cardName = By.xpath("//input[@id='cName']");
	By cardNumber = By.xpath("//input[@id='cNumber']");
	By cardYearExpiration = By.xpath("//app-card-info//app-select-input[1]//div[1]//div[1]//p[1]");
	By cardMonthExpiration = By.xpath("//app-card-info//app-select-input[2]//div[1]//div[1]//p[1]");
	By cvc = By.xpath("//input[@id='CVC']");
	By street = By.xpath("//input[@id='street']");
	By city = By.xpath("//input[@id='city']");
	By zipCode = By.xpath("//input[@id='zip']");
	By state = By.xpath("//input[@id='state']");
	By country = By.xpath("//input[@id='country']");
	By saveInfoButton = By.xpath("//button[@class='primary-button ml-auto uppercase']");
	By chooseYear = By.xpath("//app-required-info//app-date-input[@class='ng-star-inserted']//app-select-input[1]//div[1]//div[1]//ul[1]");
	By alert = By.xpath("//div[@class='alert-wrapper']");
	By profileTitle = By.xpath("//span[contains(text(),'profile')]");
	By requiredTitle = By.xpath("//h3[contains(text(),'Required')]");
	By optionalTitle = By.xpath("//h3[contains(text(),'Optional')]");
	By cardInformationTitle = By.xpath("//h3[contains(text(),'Card Information')]");
	By actualFirstName = By.xpath("/html[1]/body[1]/app-root[1]/app-profile[1]/app-edit-profile[1]/section[1]/form[1]/app-required-info[1]/div[1]/div[2]/div[2]/app-input[1]/div[1]/div[1]/span[1]");
	By actualLastName = By.xpath("/html[1]/body[1]/app-root[1]/app-profile[1]/app-edit-profile[1]/section[1]/form[1]/app-required-info[1]/div[1]/div[2]/div[2]/app-input[2]/div[1]/div[1]/span[1]");
	By actualPhoneNumber = By.xpath("/html[1]/body[1]/app-root[1]/app-profile[1]/app-edit-profile[1]/section[1]/form[1]/app-required-info[1]/div[1]/div[2]/div[2]/app-input[3]/div[1]/div[1]/span[1]");
	
	public WebDriver driver;
	
	public MyAccountProfile(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickMyAccountButton() {
		driver.findElement(myAccountButton).click();
	}
	
	public void clickProfile() {
		driver.findElement(profileButton).click();
	}
	
	public void enterFirstName100() {
		driver.findElement(firstName).clear();
		String characters = "";
		for(int i=1; i<200; i++) {
			characters += Integer.toString(i);
		}
		driver.findElement(firstName).sendKeys(characters);
		String actualFirstName100 = driver.findElement(actualFirstName).getText();
		Assert.assertEquals(actualFirstName100, expectedFirstName, messageFirstName);
	}
	
	public void enterLastName100() {
		driver.findElement(lastName).clear();
		String characters = "";
		for(int i=1; i<200; i++) {
			characters += Integer.toString(i);
		}
		driver.findElement(lastName).sendKeys(characters);
		String actualLastNameAssert = driver.findElement(actualLastName).getText();
		Assert.assertEquals(actualLastNameAssert, expectedLastName, messageLastName);
	}
	
	public void enterFirstName(String first) {		
		driver.findElement(firstName).clear();
		driver.findElement(firstName).sendKeys(first);
	}
	
	public void enterLastName(String last) {
		driver.findElement(lastName).clear();
		driver.findElement(lastName).sendKeys(last);
	}
	
	public void enterGender(String sex) {
		
		driver.findElement(gender).click();
		
		switch(sex) {
		
		case "Female":
			driver.findElement(femaleGender).click();
			break;
			
		case "Male":
			driver.findElement(maleGender).click();
			break;
		case "Other":
			driver.findElement(otherGender).click();
			break;
		}			
	}
	
	public void enterBirthYear(String Year, String Month, String Day) {

		driver.findElement(year).click();
		driver.findElement(By.xpath("//li[contains(text(),'" + Year + "')]")).click();
		
		driver.findElement(month).click();
		driver.findElement(By.xpath("//li[contains(text(),'" + Month + "')]")).click();
		
		driver.findElement(day).click();
		driver.findElement(By.xpath("//app-select-input[3]//div[1]//div[1]//ul[1]//li["+ Day + "]")).click();
	}
	
	public void enterPhoneNumber(String Number) {		
		driver.findElement(phoneNumber).clear();
		driver.findElement(phoneNumber).sendKeys(Number);
	}
	
	public void enterEmail(String Email) {		
		driver.findElement(email).clear();
		driver.findElement(email).sendKeys(Email);
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
		driver.findElement(By.xpath("//div[@class='two-cols']//div[@class='two-cols']//li[contains(text(),'" + Year + "')]")).click();
		driver.findElement(cardMonthExpiration).click();
		driver.findElement(By.xpath("//app-card-info//app-select-input[2]//div[1]//div[1]//ul[1]//li[" + Month + "]")).click();
	}
	
	public void enterCVC(String CVC) {		
		driver.findElement(cvc).clear();
		driver.findElement(cvc).sendKeys(CVC);
	}
	
	public void enterStreet(String Street) {		
		driver.findElement(street).clear();
		driver.findElement(street).sendKeys(Street);
	}
	
	public void enterCity(String City) {		
		driver.findElement(city).clear();
		driver.findElement(city).sendKeys(City);
	}
	
	public void enterZipcode(String Zipcode) {		
		driver.findElement(zipCode).clear();
		driver.findElement(zipCode).sendKeys(Zipcode);
	}
	
	public void enterState(String State) {		
		driver.findElement(state).clear();
		driver.findElement(state).sendKeys(State);
	}
	
	public void enterCountry(String Country) {		
		driver.findElement(country).clear();
		driver.findElement(country).sendKeys(Country);
	}
	
	public void clickSaveButton() {
		driver.findElement(saveInfoButton).click();
	}
	
	public void scroolToAddress() {
		WebElement element = driver.findElement(optionalTitle);
		scrollTo(element);
		waitForLoad();
	}
	
	public void scroolToReq() {
		WebElement element = driver.findElement(requiredTitle);
		scrollTo(element);
		waitForLoad();
	}
	
	public void scroolToCard() {		
		WebElement element = driver.findElement(cardInformationTitle);
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
	
	public void verifyProfileIsUpdate() {
		
		String alertWrapper = driver.findElement(alert).getText();
		
		if(alertWrapper.indexOf("info updated") != -1) {
			Assert.assertEquals(alertWrapper, profileUpdate, profileIsntUpdateProperly);
			}
		else if(alertWrapper.indexOf("No changes") != -1) {
			Assert.assertEquals(alertWrapper, noChanges, noChangesOnProfile);			
		}
	}	
	
	public void verifyProfilePageTitle() {
		String title = driver.findElement(profileTitle).getText();
		Assert.assertEquals(title, expectedProfileTitle, messageProfileTitle);
	}
	
	public String verifyRequiredForm() {
		String title = driver.findElement(requiredTitle).getText();
		return title;
	}
	
	public String verifyCardForm() {
		String title = driver.findElement(cardInformationTitle).getText();
		return title;
	}
	
	public String verifyAddresForm() {
		String title = driver.findElement(optionalTitle).getText();
		return title;
	}	
}