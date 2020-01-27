package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import helper.Browser;
import helper.OpenNavigatorPage;
import page.SocialBar;

public class TestSocialFacebookIcon {
	
	private String browser = "chrome";
	private String expected_title = "Navigator | Mapa Sarajeva";
	private String error_message = "Either Facebook did not load correctly or the title is not correct.  ";

	public WebDriver driver;
	
	@BeforeClass
	public void OpenPage() {		
		driver = new Browser().getBrowser(browser);
		OpenNavigatorPage open = new OpenNavigatorPage(driver);
		open.OpenPage(browser);
	}
	
	@Test
	public void FacebookIcon() {
		
		SocialBar facebook = new SocialBar(driver);		
		facebook.opetFacebook();

		Assert.assertEquals(facebook.navigatorFacebookTitle(), expected_title, error_message);
	}
	
	@AfterClass
	public void tearDownTest() {
		OpenNavigatorPage close = new OpenNavigatorPage(driver);
		close.ClosePage();
	}
}