package test;

import org.testng.Assert;
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

public class TestRequiredProfileFields {
	
	private String browser = "chrome";
	private String email = "sema48@gmail.com";
	private String password = "!Qq123";
	private String firstName = "Raffaello";
	private String lastName = "Frederick";
	private String gender = "Male";		
	private String year = "1995"; //enter date of birth in format e.g. 23.Feb.1993
	private String month = "Oct";
	private String day = "11";	
	private String phoneNumber = "+38761101202"; //enter phone number in format e.g. +38761222333
	private String newEmail = "semir48@gmail.com";
	
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
		Assert.assertTrue(account.verifyRequiredForm().contains("REQUIRED"), "Required form is not displayed correctly.");
		account.enterFirstName(firstName);
		account.enterLastName(lastName);
		account.enterGender(gender);
		account.enterBirthYear(year, month, day);
		account.enterPhoneNumber(phoneNumber);
		account.enterEmail(newEmail);
		
		//save info and verify profile update
		account.scroolToAddress();
		Assert.assertTrue(account.verifyAddresForm().contains("OPTIONAL"), "Addres form is not displayed correctly and save button is not visible.");
		account.clickSaveButton();
		account.waitForLoad();
		account.verifyProfileIsUpdate();
	}
	
	@AfterClass
	public void ClosePage() {
		System.out.println(this.getClass().getSimpleName() + "is finished and window is closing up.");
		//Close the page
		AuctionPage page = new AuctionPage(driver);
		page.ClosePage();
	}
}