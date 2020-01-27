package test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import helper.AuctionPage;
import helper.Browser;
import pages.MyAccountBecomeSeller;
import pages.Home;
import pages.Login;
import pages.MyAccountSeller;

public class TestBecomeSeller {
	
	private String browser = "chrome";
	private String email = "sema1@gmail.com";
	private String password = "!Qq123";
	private String productName = "Profile";
	private String descriptionText = "New product.";
	private String price = "100";	
	private String address = "2 Starling Hill";
	private String country = "United States";
	private String city = "New Haven";
	private String zipcode = "06520";
	private String phone = "+38761222333";
	private String cardName = "Arnold Smith";
	private String cardNumber = "5555 5555 5555 4444";
	private String cardExpiration = "08/22";
	private String cardCVC = "123";
					
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
	
	@Test(priority = 1)
	public void StartSellingProduct() {
		
		MyAccountBecomeSeller seller = new MyAccountBecomeSeller(driver);
		
		//Open become seller page and verify page load correctly
		seller.clickMyAccountButton();
		seller.clickBecomeSellerButton();
		seller.waitForLoad();
		
		//Populate fields in first step
		seller.clickStartSellerButton();
		seller.scrollToDetailinformation();
		seller.enterProductName(productName);
		seller.enterSelectCategory();
		seller.enterSelectSubcategory();
		seller.enterSelectBrand();
		seller.enterSelectColor();
		seller.enterSelectMaterial();
		seller.scrollToDescription();
		seller.enterDescription(descriptionText);
		seller.uploadPictures();
		seller.scrollToNextButton();
		seller.clickNextButton();
		
		//Populate fields in second step
		seller.waitForLoad();
		Assert.assertTrue(seller.getSecondStepTitle().contains("SET PRICES"), "Second step of posting product does not load correctly.");
		seller.scrollToSetPrices();
		seller.enterProductPrice(price);
		seller.enterStartDate();
		seller.enterEndDate();
		seller.clickNextButtonOnSetPrice();
		
		//Populate fields in third step
		seller.waitForLoad();
		Assert.assertTrue(seller.getThirdStepTitle().contains("LOCATION & SHIPPING"), "Third step of posting product does not load correctly.");
		seller.scrollToLocationAndShiping();
		seller.enterAddress(address);
		seller.enterCountry(country);
		seller.enterCity(city);
		seller.enterZipcode(zipcode);
		seller.enterPhone(phone);
		seller.scrollToCardInformation();
		seller.enterCardName(cardName);
		seller.enterCardNumber(cardNumber);
		seller.enterCardExperationYear(cardExpiration);
		seller.enterCVC(cardCVC);
		seller.clickDoneButton();
		Assert.assertTrue(seller.getCongratsMessage().contains("Product successfully added"), "Product is not posted correctly.");
		seller.waitForLoad();		
	}
	
	@Test(priority = 2)
	public void CheckSetProduct() {
		MyAccountSeller product = new MyAccountSeller(driver);
		
		//Open seller form and verify that product is on the list of active products
		product.waitForLoad();
		product.clickSeller();
		Assert.assertTrue(product.getSellerPageTittle().contains("SELLER"), "Seller page does not load correctly.");
		product.scrollActiveProducts();
		product.selectProductAndClickView(productName);
		product.waitForLoad();
		Assert.assertEquals(product.verifyProductAuction(), productName, "Auction for product with" + productName + "does not load correctly.");
	}
	
	@AfterClass
	public void Close() {
		System.out.println(this.getClass().getSimpleName() + "is finished and window is closing up.");
		//Close the page
		AuctionPage page = new AuctionPage(driver);
		page.ClosePage();		
	}	
}