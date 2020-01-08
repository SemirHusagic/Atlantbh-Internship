package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;

import helper.AuctionPage;
import helper.Browser;
import pages.Home;
import pages.Login;
import pages.MyAccountProfile;

public class TestAllProfileFieldsWithInvalidInputs {
	
	private String browser = "chrome";
	private String email = "sema50@gmail.com";
	private String password = "!Qq123";
	
//	private String firstName = "a";
//	private String lastName = "a";
	
	//enter phone number in format e.g. +38761222333
	private String phoneNumber = "a";
	private String newEmail = "f";
//	private String cardNumber = "a";
	
//	private String cardCVC = "1";
	
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
	public void InvalidRequiredField() {
		MyAccountProfile account = new MyAccountProfile(driver);
		
		//open My account page
		account.clickMyAccountButton();
		account.clickProfile();
		account.waitForLoad();
		account.verifyProfilePageTitle();
		
		account.scroolToReq();
		account.enterFirstName100();
		account.enterLastName100();
		account.enterPhoneNumber(phoneNumber);
		account.enterEmail(newEmail);
		
	}
	
//	@Test
//	public void OpenProfile() {
//		MyAccountProfile account = new MyAccountProfile(driver);
//		
//		//open My account page
//		account.clickMyAccountButton();
//		account.clickProfile();
//		account.waitForLoad();
//		account.verifyProfilePageTitle();
//		
//		//focus on required form and populate all fields
//		account.scroolToReq();
////		account.enterFirstName(firstName);
//		account.enterFirstName100();
//		account.waitForLoad();
//		
//
//		//assert
//		account.enterLastName(lastName);
//		account.waitForLoad();
//
//		//assert
//		account.enterPhoneNumber(phoneNumber);
//		account.waitForLoad();
//
//		//assert
//		account.enterEmail(newEmail);
//		account.waitForLoad();
//		account.waitForLoad();
//
//
//		//assert
//		
//		//focus on card information form and populate all fields
//		account.scroolToCard();
//		account.enterCardNumber(cardNumber);
//		account.waitForLoad();
//
//		account.enterCVC(cardCVC);
//		account.waitForLoad();
//
//		
//		//focus on address form and populate all fields
//		account.scroolToAddress();
//		
//		
//		//save info and verify profile update
////		account.clickSaveButton();
//		account.waitForLoad();
////		account.saveButtonAsster();
//	}

	@AfterClass
	public void Close() {
		AuctionPage page = new AuctionPage(driver);
		page.ClosePage();
		
	}

}

