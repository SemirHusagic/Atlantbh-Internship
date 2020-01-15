package test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import helper.Browser;
import helper.AuctionPage;
import pages.CreateAnAccount;
import pages.Login;

public class TestCreateAccount {
	
	private String browser = "chrome";
	private String first_name = "Gal";
	private String last_name = "Ledram";
	private String email;
	private String password = "Ng%JFK0j";
	private String confirm_password ="Ng%JFK0j";
	
	public WebDriver driver;
	
	@BeforeClass
	public void OpenPage() {
		System.out.println("Started method " + this.getClass().getSimpleName() + ".");
		Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = caps.getBrowserName();
		String browserVersion = caps.getVersion();
		System.out.println(browserName+" "+browserVersion);
		driver = new Browser().getBrowser(browser);
		AuctionPage page = new AuctionPage(driver);
		page.OpenPage();
		
	}
	
	@Test
	public void CreateAccount() {
		
		CreateAnAccount account = new CreateAnAccount(driver);
//		Login login = new Login(driver);

		//Open register page 
		account.waitForLoad();
		account.openCreateAnAccount();
		
		//Confirm that page is loaded
		Assert.assertEquals(account.getRegisterTitle(), "REGISTER", "Page did not load correctly.");

		//Populate register fields
		account.enterFirstName(first_name);
		account.enterLastName(last_name);
		email = account.randomEmail();
		account.enterEmail(email);
		account.enterPassword(password);
		account.enterConfirmPassword(confirm_password);
		account.scroolPage();
		account.waitForLoad();
		account.waitForElement();
		account.clickRegisterButton();
		
		//Verify that login page is displayed
//		account.waitForLoginForm();
//		login.scroolToLogin();
//		login.loginTitle();
//		login.enterEmail(email);
//		login.enterPassword(password);
//		login.clickLogin();
//		Assert.assertTrue(login.loginNotificationMessage().contains("You're successfully logged in"), "Registration failed, user did not login to the page."); 	
	}
	
	@AfterClass
	public void closeTest() {
		System.out.println(this.getClass().getSimpleName() + "is finished and window is closing up.");
		//Close the page
		AuctionPage close = new AuctionPage(driver);
		close.ClosePage();
	}	
}