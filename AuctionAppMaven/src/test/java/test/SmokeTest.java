package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.apache.commons.io.FileUtils;


import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import helper.Browser;
import helper.AuctionPage;
import pages.Home;
import pages.Login;
import pages.SingleProduct;

public class SmokeTest {
	
	private String browser = "chrome";
	private String email = "sema3@gmail.com";
	private String password = "!Qq123";
	private String bidValue;
	
	public WebDriver driver;
	
	@BeforeClass
	public void OpenPage() {
		System.out.println("Started method " + this.getClass().getSimpleName() + ".");
		driver = new Browser().getBrowser(browser);
		AuctionPage open = new AuctionPage(driver);
		open.OpenPage();				
	}
	
	@Test(priority = 1)
	public void LoginPage() {
		//Login and enter home page
		System.out.println("Enter email, password and login");
		Login login = new Login(driver);	
		
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File("/Users/Shared/Jenkins/Home/workspace/ss.png");
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		login.openLogin();
//		login.loginTitle();
		System.out.println("login naslov");
//		login.scroolToLogin();
		System.out.println("skrolano do naslova");
		login.enterEmail(email);
		System.out.println("unesen mail");
		login.enterPassword(password);
		System.out.println("unesen pas");
		login.waitForLoad();
		login.clickLogin();
	}
	
	@Test(priority = 2)
	public void HomePage() {		

		Home home = new Home(driver);
		SingleProduct product = new SingleProduct(driver);

		System.out.println("Verifying home page is load.");
		//Wait 3 seconds for page to load
		home.waitForLoad();
		System.out.println("stranica home se ucitala sad treba da klikne bid now");
		
		//Confirm that page is loaded
//		home.homePageTitle();
		
		//Access random item and wait page to load
		home.clickBidNow();
		System.out.println("Open product and make bid.");
		product.waitToLoad();
		System.out.println("ceka da se ucita i sad verifikuje ");
		product.verifySingleProductPage();
		
		//Determine the bid value to enter
		bidValue = product.enterBidPrice();
		System.out.println("detektuje koju ce unijet");
		
		//If auction is started - place a bid		
		product.enterBid(bidValue);
		System.out.println("unio cijenu");
		product.waitToLoad();
		System.out.println("Placing a bid.");
		product.clickPlaceBid();
		
		//Verify that you are the higher bidder
		product.sendAssert();
		product.waitToLoad(); 	
 	}			
	
	@AfterClass
	public void tearDownTest() {
		System.out.println(this.getClass().getSimpleName() + "is finished and window is closing up.");
		//Close the page
		AuctionPage close = new AuctionPage(driver);
		close.ClosePage();
	}			
}