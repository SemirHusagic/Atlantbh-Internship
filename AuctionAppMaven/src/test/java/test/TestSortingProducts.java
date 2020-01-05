package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import helper.Browser;
import helper.AuctionPage;
import pages.Home;
import pages.Login;
import pages.Shop;

public class TestSortingProducts {
	
	private String browser = "chrome";
	private String email = "mail@email.com";
	private String password = "Aaaaaaa1!";
	
	public WebDriver driver;
	
	@BeforeSuite
	public void OpenPage() {		
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
		
		//Verify that home page is displayed and open Shop
		home.waitForLoad();
		home.homePageTitle();
		home.clickOnShopButton();		
	}
	
	@Test
	public void TestCase20() {
		
		Shop shop = new Shop(driver);
		
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
		
		shop.clickOnShopButton();
		shop.verifyShopIsOpen();
		shop.waitForLoad();
		shop.clickDeafultSorting();
		shop.clickTimeDescending();
		shop.waitForLoad();
		shop.verifyTimeSorting();
	}
	
	@AfterSuite
	public void closeTest() {
		AuctionPage close = new AuctionPage(driver);
		close.ClosePage();
	}

}