package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;

import helper.AuctionPage;
import helper.Browser;
import pages.CreateAnAccount;

public class Register {
	
	private String browser = "chrome";
	private String first_name = "Gal";
	private String last_name = "Ledram";
	private String email = "gledram3@example.com";
	private String password = "Ng%JFK0j";
	private String confirmPassword = "Ng%JFK0j";
	
	public WebDriver driver;
	
	@BeforeClass
	public void OpenPage() {
		driver = new Browser().getBrowser(browser);
		AuctionPage open = new AuctionPage(driver);
		open.OpenPage();
	}
	
	@Test
	public void CreateAccount() {
		
		CreateAnAccount account = new CreateAnAccount(driver);
		
		account.openCreateAnAccount();
		account.enterFirstName(first_name);
		account.enterLastName(last_name);
		account.enterEmal(email);
		account.enterPassword(password);
		account.enterConfirmPassword(confirmPassword);
		account.scroolPage();
		account.waitForElement();
		account.clickRegisterButton();
		
	}


}
