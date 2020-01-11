package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import helper.AuctionPage;
import helper.Browser;
import pages.Bid_MyAccount;
import pages.Home;
import pages.Login;
import pages.SingleProduct;

public class TestYourBids {
	
	
	private String browser = "chrome";
	private String email = "sema13@gmail.com";
	private String password = "!Qq123";
	private String bidValue;
	private String productName;
					
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
	
	@Test
	public void YourBids() {
		Bid_MyAccount bid = new Bid_MyAccount(driver);
		Home home = new Home(driver);
		SingleProduct product = new SingleProduct(driver);
		
		//Open Home and verify that page is loaded
		home.waitForLoad();
		home.homePageTitle();
				
		//Access random item and wait page to load
		home.clickBidNow();
		product.waitToLoad();
		productName = bid.getProductName();
		
		//Place a bid
		bidValue = product.enterBidPrice();
		product.enterBid(bidValue);
		product.waitToLoad();
		product.clickPlaceBid();
		product.sendAssert();
		product.waitToLoad();
		
		//Check that bid is register in your bids
		bid.openMyAccountMenu();
		bid.clickYourBids();
		bid.scrollToBidTable();
		bid.selectProductAndClickView(productName);	
		
	}
	
	@AfterClass
	public void Close() {
		AuctionPage page = new AuctionPage(driver);
		page.ClosePage();		
	}	

}
