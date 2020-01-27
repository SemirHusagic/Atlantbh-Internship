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
import pages.ProductCategories;

public class TestProductCategories {
	
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
		home.waitForLoad();			
	}
	
	@Test
	public void Categories() {
		
		ProductCategories categories = new ProductCategories(driver);

		categories.clickOnShopButton();
		categories.waitForLoad();
		
		//In category Fashion open all subcategories
		categories.clickFashion();
		categories.clickJeans();
		Assert.assertTrue(categories.getTitle().contains("JEANS"), "Jeans category is not displayed correctly.");
		categories.clickVintage();
		Assert.assertTrue(categories.getTitle().contains("VINTAGE"), "Vintage category is not displayed correctly.");
		categories.close();
		
		//In category Accessories open all subcategories
		categories.clickAccessories();
		categories.clickWomenAccessories();
		Assert.assertTrue(categories.getTitle().contains("WOMEN'S ACCESSORIES"), "Women Accessories category is not displayed correctly.");
		categories.clickAccessories();
		
		//In category Jewelry open all subcategories
		categories.clickJewelry();
		categories.clickWristwatches();
		Assert.assertTrue(categories.getTitle().contains("WRISTWATCHES"), "Wristwatches category is not displayed correctly.");
		categories.clickJewelry();
		
		//In category Shoes open all subcategories
		categories.clickShoes();
		categories.clickSneakers();
		Assert.assertTrue(categories.getTitle().contains("SNEAKERS"), "Sneakers category is not displayed correctly.");
		categories.clickShoes();
		
		//In category Sportware open all subcategories
		categories.clickSportware();
		categories.clickSweatshirts();
		Assert.assertTrue(categories.getTitle().contains("SWEATSHIRTS"), "Seatshirts category is not displayed correctly.");
		categories.clickSportware();
		
		//In category Home open all subcategories
		categories.clickHome();
		categories.clickLamps();
		Assert.assertTrue(categories.getTitle().contains("LAMPS"), "Lamps category is not displayed correctly.");
		categories.clickHome();
		
		//In category Electronics open all subcategories
		categories.clickElectronics();
		categories.clickCamera();
		Assert.assertTrue(categories.getTitle().contains("CAMERA"), "Camera category is not displayed correctly.");
		categories.clickElectronics();
		
		//In category Mobile open all subcategories
		categories.clickMobile();
		categories.clickPhones();
		Assert.assertTrue(categories.getTitle().contains("PHONES"), "Phones category is not displayed correctly.");
		categories.clickMobile();
		
		//In category Computer open all subcategories
		categories.clickComputer();
		categories.clickLaptops();
		Assert.assertTrue(categories.getTitle().contains("LAPTOPS"), "Laptops category is not displayed correctly.");
		categories.clickComputer();
	}
	
	@AfterClass
	public void closeTest() {
		System.out.println(this.getClass().getSimpleName() + "is finished and window is closing up.");
		//Close the page
		AuctionPage close = new AuctionPage(driver);
		close.ClosePage();
	}
}