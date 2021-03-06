package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;

import helper.Browser;
import helper.AuctionPage;
import pages.Home;
import pages.Login;
import pages.Shop;

public class TestSortingProducts {
	
	private String browser = "chrome";
	private String email = "sema1@gmail.com";
	private String password = "!Qq123";
	
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
//		login.loginTitle();
		login.enterEmail(email);
		login.enterPassword(password);
		login.clickLogin();
		
		//Verify that home page is displayed and open Shop
		home.waitForLoad();
		home.homePageTitle();
		home.clickOnShopButton();		
	}
	
	@Test
	public void TestCase20() {
		
		Shop shop = new Shop(driver);
		
		//Open shop page and sort product by price descending
		shop.waitForLoad();
		shop.verifyShopIsOpen();
		shop.clickDeafultSorting();
		shop.clickPriceDescending();
		shop.waitForLoad();
		shop.comperPricesAndVerifySorting();
	}
	
	@Test
	public void TestCase21() {
		Shop shop = new Shop(driver);
		
		//Sort product by time descending
		shop.clickOnShopButton();
		shop.verifyShopIsOpen();
		shop.waitForLoad();
		shop.clickDeafultSorting();
		shop.clickTimeDescending();
		shop.waitForLoad();
		shop.verifyTimeSorting();
	}
	
	@AfterClass
	public void closeTest() {
		System.out.println(this.getClass().getSimpleName() + "is finished and window is closing up.");
		//Close the page
		AuctionPage close = new AuctionPage(driver);
		close.ClosePage();
	}
}