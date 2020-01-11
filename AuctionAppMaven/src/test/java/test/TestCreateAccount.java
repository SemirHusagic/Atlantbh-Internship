package test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;

import helper.Browser;
import helper.AuctionPage;
import pages.CreateAnAccount;
import pages.Login;

public class TestCreateAccount {
	
	private String browser = "chrome";
	private String first_name = "Gal";
	private String last_name = "Ledram";
	private String email = "ldmgal15@example.com";
	private String password = "Ng%JFK0j";
	private String confirm_password ="Ng%JFK0j";
	
	public WebDriver driver;
	
	@BeforeClass
	public void OpenPage() {
		System.out.println("Started method " + this.getClass().getSimpleName() + ".");
		driver = new Browser().getBrowser(browser);
		AuctionPage page = new AuctionPage(driver);
		page.OpenPage();
	}
	
	@Test
	public void CreateAccount() {
		
		CreateAnAccount account = new CreateAnAccount(driver);
		Login login = new Login(driver);
		
		//Open register page 
		account.waitForLoad();
		account.openCreateAnAccount();
		
		//Confirm that page is loaded
		Assert.assertEquals(account.getRegisterTitle(), "REGISTER", "Page did not load correctly.");

		//Populate register fields
		account.enterFirstName(first_name);
		account.enterLastName(last_name);
		account.enterEmal(email);
		account.enterPassword(password);
		account.enterConfirmPassword(confirm_password);
		account.scroolPage();
		account.waitForLoad();
		account.waitForElement();
		account.clickRegisterButton();
		
		//Verify that login page is displayed
		account.waitForLoad();
		login.loginTitle();
		System.out.println(this.getClass().getSimpleName() + "is finished and window is closing up.");
	}
	
	@AfterClass
	public void closeTest() {
		//Close the page
		AuctionPage close = new AuctionPage(driver);
		close.ClosePage();
	}	
}