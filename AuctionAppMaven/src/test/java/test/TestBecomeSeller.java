package test;

import org.testng.annotations.Test;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import helper.AuctionPage;
import helper.Browser;
import pages.BecomeSeller;
import pages.Home;
import pages.Login;
import pages.Seller;

public class TestBecomeSeller {
	
	private String browser = "chrome";
	private String email = "qa@email.com";
	private String password = "Aaaaaaa1!";
	private String productName = "Profile";
	private String descriptionText = "New product.";
	private String price = "100";
	private String startDate = "1/2/2020";
	private String endDate = "1/3/2020";
	
	private String address = "2 Starling Hill";
	private String country = "United States";
	private String city = "New Haven";
	private String zipcode = "06520";
	private String phone = "+38761222333";
	private String cardName = "Arnold Smith";
	private String cardNumber = "5105105105105100";
	private String cardYear = "2020";
	private String cardMonth = "8";
	private String cardCVC = "1223";
					
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
		
		//login on AucctionApp
		login.openLogin();
		login.loginTitle();
		login.enterEmail(email);
		login.enterPassword(password);
		login.clickLogin();
		home.waitForLoad();		
	}
	
	@Test(priority = 1)
	public void StartSellingProduct() {
		
		BecomeSeller seller = new BecomeSeller(driver);
		
		seller.clickMyAccountButton();
		seller.clickBecomeSellerButton();
		seller.waitForLoad();
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
		seller.waitForLoad();
		seller.scrollToSetPrices();
		seller.enterProductPrice(price);
		seller.enterStartDate(startDate);
		seller.enterEndDate(endDate);
		seller.clickNextButtonOnSetPrice();
		seller.scrollToLocationAndShiping();
		seller.enterAddress(address);
		seller.enterCountry(country);
		seller.enterCity(city);
		seller.enterZipcode(zipcode);
		seller.enterPhone(phone);
		seller.scrollToCardInformation();
		seller.enterCardName(cardName);
		seller.enterCardNumber(cardNumber);
		seller.enterCardExperationYear(cardYear, cardMonth);
		seller.enterCVC(cardCVC);
		seller.clickDoneButton();
		seller.waitForLoad();		
	}
	
	@Test(priority = 2)
	public void CheckSetProduct() {
		Seller product = new Seller(driver);
		
		product.waitForLoad();
		product.clickSeller();
		product.scrollToCardInformation();
		product.selectRow(productName);
		
	}
	
	@AfterSuite
	public void Close() {
		AuctionPage page = new AuctionPage(driver);
		page.ClosePage();
		
	}

}