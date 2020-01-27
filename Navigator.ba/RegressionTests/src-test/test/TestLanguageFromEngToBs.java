package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import helper.Browser;
import helper.OpenNavigatorPage;
import page.ChangeLanguage;

public class TestLanguageFromEngToBs {
	
	private String browser = "chrome";
	private String engTitle = "Suggest features";
	
	public WebDriver driver;
	
	@BeforeClass
	public void OpenPage() {
		driver = new Browser().getBrowser(browser);
		OpenNavigatorPage open = new OpenNavigatorPage(driver);
		open.OpenPage(browser);
	}
	
	@Test
	public void ChangeFromEngToBs() {
		
		ChangeLanguage lng = new ChangeLanguage(driver);
		lng.changeToEng();
		Assert.assertTrue(lng.confirmChange().contains(engTitle));
	}
	
	@AfterClass
	public void tearDownTest() {
		OpenNavigatorPage close = new OpenNavigatorPage(driver);
		close.ClosePage();
	}
}
