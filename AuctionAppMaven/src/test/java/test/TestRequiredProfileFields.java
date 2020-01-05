package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import helper.AuctionPage;
import helper.Browser;
import pages.Home;
import pages.Login;
import pages.MyAccountProfile;

public class TestRequiredProfileFields {
	
	private String browser = "chrome";
	private String email = "rfrederickc@email.com";
	private String password = "Aaaaaaa1!";
	private String firstName = "Raffaello";
	private String lastName = "Frederick";
	private String gender = "Male";	
	//enter date of birth in format e.g. 23.Feb.1993
	private String year = "1995";
	private String month = "Oct";
	private String day = "11";
	//enter phone number in format e.g. +38761222333
	private String phoneNumber = "+38761101202";
	private String newEmail = "rfrederickc@hao123.com";
	
	public WebDriver driver;
	
	@BeforeSuite
	public void OpenPage() {
		driver = new Browser().getBrowser(browser);
		AuctionPage page = new AuctionPage(driver);
		page.OpenPage();
	}
	
	@BeforeClass
	public void UserLogin() {
		Login login = new Login(driver);
		Home home = new Home(driver);
		
		login.openLogin();
		login.loginTitle();
		login.enterEmail(email);
		login.enterPassword(password);
		login.clickLogin();
		
		home.waitForLoad();
		home.homePageTitle();		
	}

	@Test
	public void ProfileRequiredFields() {
		
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
		
		//save info and verify profile update
		account.scroolToAddress();
		account.clickSaveButton();
		account.waitForLoad();
		account.saveButtonAsster();
	}
	
	@AfterSuite
	public void ClosePage() {
		AuctionPage page = new AuctionPage(driver);
		page.ClosePage();
	}
}