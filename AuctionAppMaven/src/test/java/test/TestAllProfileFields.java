package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;

import helper.Browser;
import helper.AuctionPage;
import pages.Home;
import pages.Login;
import pages.MyAccountProfile;

public class TestAllProfileFields {
	
	private String browser = "chrome";
	private String email = "sema50@gmail.com";
	private String password = "!Qq123";
	private String firstName = "Arnold";
	private String lastName = "Smith";
	private String gender = "Male";	
	//enter date of birth in format e.g. 23.Feb.1993
	private String year = "1989";
	private String month = "Sep";
	private String day = "24";
	//enter phone number in format e.g. +38761222333
	private String phoneNumber = "+38761000111";
	private String newEmail = "qa@email.com";
	private String cardName = "Arnold Smith";
	private String cardNumber = "5105105105105100";
	private String cardYear = "2020";
	private String cardMonth = "8";
	private String cardCVC = "1223";
	private String street = "2 Starling Hill";
	private String city = "New Haven";
	private String zipcode = "06520";
	private String state = "Connecticut";
	private String country = "United States";
	
	public WebDriver driver;
	
	@BeforeClass
	public void OpenPage() {		
		driver = new Browser().getBrowser(browser); 
		AuctionPage page = new AuctionPage(driver);
		page.OpenPage();
	}
	
	@BeforeMethod
	public void UserLogin() {		
		Login login = new Login(driver);
		Home home = new Home(driver);
		
		//login on AucctionApp
		login.openLogin();
		login.loginTitle();
		login.enterEmail(email);
		login.enterPassword(password);
		login.clickLogin();
		home.waitForLoad();		
	}
	
	@Test
	public void OpenProfile() {
		MyAccountProfile account = new MyAccountProfile(driver);
		
		//open My account page
		account.clickMyAccountButton();
		account.clickProfile();
		account.waitForLoad();
		account.verifyProfilePageTitle();
		
		//focus on required form and populate all fields
		account.scroolToReq();
		account.enterFirstName(firstName);
		account.enterLastName(lastName);
		account.enterGender(gender);
		account.enterBirthYear(year, month, day);
		account.enterPhoneNumber(phoneNumber);
		account.enterEmail(newEmail);
		
		//focus on card information form and populate all fields
		account.scroolToCard();
		account.enterCardName(cardName);
		account.enterCardNumber(cardNumber);
		account.enterCardExperationYear(cardYear, cardMonth);
		account.enterCVC(cardCVC);
		
		//focus on address form and populate all fields
		account.scroolToAddress();
		account.enterStreet(street);
		account.enterCity(city);
		account.enterZipcode(zipcode);
		account.enterState(state);
		account.enterCountry(country);
		
		//save info and verify profile update
		account.clickSaveButton();
		account.waitForLoad();
		account.saveButtonAsster();
	}

	@AfterClass
	public void Close() {
		AuctionPage page = new AuctionPage(driver);
		page.ClosePage();
		
	}
}

