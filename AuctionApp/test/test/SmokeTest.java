package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import helper.Browser;
import helper.OpenAuctionPage;
import page.Home;
import page.Login;
import page.SingleProduct;

public class SmokeTest {
	
	private String browser = "chrome";
	private String email = "gledram3@example.com";
	private String password = "Aaaaaaa1!";
	private String title_page = "LOGIN";
	private String login_message = "Login page did not load correctly.";
	private String page_assert = "Categories";
	private String home_message = "Home page did not load correctly.";
	private String expected_title = "SINGLE PRODUCT";
	private String singleProduct_message = "Single product page did not load correctly.";
	private String bidValue;
	
	public WebDriver driver;
	
	@BeforeClass
	public void OpenPage() {
		driver = new Browser().getBrowser(browser);
		OpenAuctionPage open = new OpenAuctionPage(driver);
		open.OpenPage(browser);				
	}
	
	@Test(priority = 1)
	public void LoginPage() {
		//Login and enter home page
		Login login = new Login(driver);		
		login.OpenLogin();
		Assert.assertTrue(login.LoginTitle().contains(title_page), login_message);
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
		Assert.assertTrue(home.pageTitle().contains(page_assert), home_message);
		
		//Access random item and wait page to load
		home.clickBidNow();
		product.waitToLoad();
		
		Assert.assertEquals(product.getPageTitle(), expected_title, singleProduct_message);
		
		//Determine the bid value to enter
		bidValue = product.enterBidPrice();
		
		//Verify if auction is started
		product.sendAssertNoAuction(bidValue);
		
		//If auction is started - place a bid		
		product.enterBid(bidValue);
		product.waitToLoad();
		product.clickPlaceBid(bidValue);
		
		//Verify that you are the higher bidder
		product.sendAssert(bidValue);
		product.waitToLoad(); 		
		
 	}			
	
	@AfterClass
	public void tearDownTest() {
		//Close the page
		OpenAuctionPage close = new OpenAuctionPage(driver);
		close.ClosePage();
	}	
		
}

