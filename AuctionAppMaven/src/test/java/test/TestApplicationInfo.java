package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import helper.AuctionPage;
import helper.Browser;
import pages.Home;
import pages.Login;

public class TestApplicationInfo {	
	
	private String browser = "chrome";
	private String email = "sema1@gmail.com";
	private String password = "!Qq123";
					
	public WebDriver driver;
	
	@BeforeClass
	public void OpenPage() {
		System.out.println("Started method " + this.getClass().getSimpleName() + ".");
		//Open browser and navigate to Auctionapp page
		driver = new Browser().getBrowser(browser); 
		AuctionPage page = new AuctionPage(driver);
		page.OpenPage();
	}
	
	@BeforeClass
	public void UserLogin() {		
		Login login = new Login(driver);
		Home home = new Home(driver);
		
		//Login on AucctionApp
		login.openLogin();
		login.loginTitle();
		login.enterEmail(email);
		login.enterPassword(password);
		login.clickLogin();
		home.waitForLoad();		
	}	
	
	@Test(priority = 0)
	public void AboutUs() {
		Home home = new Home(driver);
		
		//Scroll to the bottom and open About Us info
		home.waitForLoad();
		home.scrollToBottom();
		home.openAboutUs();
		Assert.assertTrue(home.aboutUsTitle().contains("About Us"), "About Us page does not load correctly.");
	}
	
	@Test(priority = 1)
	public void TermsAndConditions() {
		Home home = new Home(driver);
		
		//Scroll to the bottom and open Terms and Conditions info
		home.clickOnHomeButton();
		home.waitForLoad();
		home.scrollToBottom();		
		home.openTermsAndConditions();
		Assert.assertTrue(home.termsAndConditionsTitle().contains("Terms and Conditions"), "Terms and Conditions page does not load correctly.");
	}
	
	@Test(priority = 2)
	public void PrivacyAndPolicy() {
		Home home = new Home(driver);
		
		//Scroll to the bottom and open Privacy and Policy info
		home.clickOnHomeButton();
		home.waitForLoad();
		home.scrollToBottom();
		home.openPrivacyAndPolicy();
		Assert.assertTrue(home.privacyAndPolicyTitle().contains("Privacy and Policy"), "Privacy and Policy page does not load correctly.");
	}
	
	@AfterClass
	public void Close() {
		System.out.println(this.getClass().getSimpleName() + "is finished and window is closing up.");
		//Close the page
		AuctionPage page = new AuctionPage(driver);
		page.ClosePage();		
	}	
}