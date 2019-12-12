package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import helper.Browser;
import helper.OpenAuctionPage;
import page.CreateAnAccount;

public class Register {
	
	private String browser = "chrome";
	private String first_name = "Gal";
	private String last_name = "Ledram";
	private String email = "gledram3@example.com";
	private String password = "Ng%JFK0j";
	
	public WebDriver driver;
	
	@BeforeClass
	public void OpenPage() {
		driver = new Browser().getBrowser(browser);
		OpenAuctionPage open = new OpenAuctionPage(driver);
		open.OpenPage(browser);
	}
	
	@Test
	public void CreateAccount() {
		
		CreateAnAccount account = new CreateAnAccount(driver);
		
		account.openCreateAnAccount();
		account.enterFirstName(first_name);
		account.enterLastName(last_name);
		account.enterEmal(email);
		account.enterPassword(password);
		account.scroolPage();
		account.waitForElement();
		account.clickRegisterButton();
		
	}

}
