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
import pages.SingleProduct;

public class TestPlaceBid {
	
	private String browser = "chrome";
	private String email = "sema49@gmail.com";
	private String password = "!Qq123";	
	private String bidValue;
	
	public WebDriver driver;

	
	@BeforeClass
	public void OpenPage() {
		driver = new Browser().getBrowser(browser);
		AuctionPage open = new AuctionPage(driver);
		open.OpenPage();
	}
	
	@BeforeMethod
	public void UserLogin() {
		
		Login login = new Login(driver);
		Home home = new Home(driver);
		SingleProduct product = new SingleProduct(driver);
		
		//Login and enter home page
		login.openLogin();		
		login.loginTitle();		
		login.enterEmail(email);
		login.enterPassword(password);
		login.clickLogin();
		
		//Verify that Home page is displayed
		home.waitForLoad();		
		home.homePageTitle();
		
		//Access random item and wait page to load
		home.clickBidNow();
		product.waitToLoad();		
		
		//Verify that Single product page is displayed
		product.getPageTitle();
	}
	
	@Test
	public void TestCase16() {
		
		SingleProduct product = new SingleProduct(driver);
		
		//Determine the highest value of the bid to enter
		bidValue = product.enterBidPrice();
		
		//Place a bid		
		product.enterBid(bidValue);
		product.waitToLoad();
		product.clickPlaceBid();
				
		//Verify that you are the higher bidder
		product.sendAssert();
		product.waitToLoad();
	}
	
	@Test
	public void TestCase17() {
	
		Home home = new Home(driver);
		SingleProduct product = new SingleProduct(driver);
		
		//Open Home and verify that page is loaded
		home.clickOnHomeButton();
		home.waitForLoad();
		home.homePageTitle();
				
		//Access random item and wait page to load
		home.clickBidNow();
		
		//Access random item and wait page to load
		product.waitToLoad();
		
		//Determine the lowest value of the bid to enter
		bidValue = product.enterLowerBidPrice();
		
		//Place a bid
		product.enterBid(bidValue);
		product.waitToLoad();
		product.clickPlaceBid();
		
		//Verify that you enter lower price
		product.sendAssert();
		product.waitToLoad();	
	}
	
	@Test
	public void TestCase18() {
		
		Home home = new Home(driver);
		SingleProduct product = new SingleProduct(driver);
		
		//Open Home and verify that page is loaded
		home.clickOnHomeButton();
		home.waitForLoad();
		home.homePageTitle();
						
		//Access random item and wait page to load
		home.clickBidNow();
				
		//Access random item and wait page to load
		product.waitToLoad();
		
		//Determine the lowest value of the bid to enter
		bidValue = product.enterSameBidPrice();
				
		//Place a bid
		product.enterBid(bidValue);
		product.waitToLoad();
		product.clickPlaceBid();
				
		//Verify that you enter lower price
		product.sendAssert();
		product.waitToLoad();		
	}
	@AfterClass
	public void closeTest() {
		//Close the page
		AuctionPage close = new AuctionPage(driver);
		close.ClosePage();
	}
}