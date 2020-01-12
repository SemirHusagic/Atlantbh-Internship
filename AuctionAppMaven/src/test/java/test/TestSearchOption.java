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
import pages.Shop;
import pages.SingleProduct;

public class TestSearchOption {
	
	private String browser = "chrome";
	private String email = "sema1@gmail.com";
	private String password = "!Qq123";
	private String productName;
	
	public WebDriver driver;
	
	@BeforeClass
	public void OpenPage() {	
		System.out.println("Started method " + this.getClass().getSimpleName() + ".");
		driver = new Browser().getBrowser(browser);
		AuctionPage page = new AuctionPage(driver);
		page.OpenPage();
	}
	
	@BeforeClass
	public void UserLogin() {
		
		Login login = new Login(driver);
		Home home = new Home(driver);
		
		//Login and enter home page
		login.openLogin();
		login.loginTitle();
		login.enterEmail(email);
		login.enterPassword(password);
		login.clickLogin();
		home.waitForLoad();			
	}
	
	@Test
	public void SearchOption() {
		Home home = new Home(driver);
		SingleProduct product = new SingleProduct(driver);
		Shop shop = new Shop(driver);
		
		//Open Home and verify that page is loaded
		home.waitForLoad();
		home.homePageTitle();
				
		//Access random item and wait page to load
		home.clickBidNow();
		product.waitToLoad();
		
		//Get product name, search it and verify that product is found
		productName = product.getProductName();
		System.out.println(productName);
		shop.populateSearchBar(productName);
		shop.clickSearchButton();
		shop.scrollToShopTitle();
		Assert.assertTrue(shop.verifyProductIsFind().contains(productName), "Products names are not matching.");
	}
	
	@AfterClass
	public void closeTest() {
		System.out.println(this.getClass().getSimpleName() + "is finished and window is closing up.");
		//Close the page
		AuctionPage close = new AuctionPage(driver);
		close.ClosePage();
	}
}
