package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;

import helper.Browser;
import helper.AuctionPage;
import pages.Home;
import pages.Login;
import pages.SingleProduct;

public class SmokeTest {
	
	private String browser = "chrome";
	private String email = "sema1@gmail.com";
	private String password = "!Qq123";
	private String bidValue;
	
	public WebDriver driver;
	
	@BeforeClass
	public void OpenPage() {
		driver = new Browser().getBrowser(browser);
		AuctionPage open = new AuctionPage(driver);
		open.OpenPage();				
	}
	
	@Test(priority = 1)
	public void LoginPage() {
		//Login and enter home page
		Login login = new Login(driver);		
		login.openLogin();
		login.loginTitle();
		login.scroolToLogin();
		login.enterEmail(email);
		login.enterPassword(password);
		login.clickLogin();
	}
	
	@Test(priority = 2)
	public void HomePage() {		
		
		Home home = new Home(driver);
		SingleProduct product = new SingleProduct(driver);
		
		//Wait 3 seconds for page to load
		home.waitForLoad();
		
		//Confirm that page is loaded
		home.homePageTitle();
		
		//Access random item and wait page to load
		home.clickBidNow();
		product.waitToLoad();
		
		product.getPageTitle();
		
		//Determine the bid value to enter
		bidValue = product.enterBidPrice();
		
		//If auction is started - place a bid		
		product.enterBid(bidValue);
		product.waitToLoad();
		product.clickPlaceBid(bidValue);
		
		//Verify that you are the higher bidder
		product.sendAssert();
		product.waitToLoad(); 
		
		
 	}			
	
	@AfterClass
	public void tearDownTest() {
		//Close the page
		AuctionPage close = new AuctionPage(driver);
		close.ClosePage();
	}	
		
}