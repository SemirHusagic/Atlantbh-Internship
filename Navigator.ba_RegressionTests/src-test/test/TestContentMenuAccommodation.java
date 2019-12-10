package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import helper.Browser;
import helper.OpenNavigatorPage;
import page.SearchOption;

public class TestContentMenuAccommodation {
	
	private String browser = "chrome";
	private String placeName = "Plavi";
	
	public WebDriver driver;
	
	@BeforeClass
	public void OpenPage() {	
		driver = new Browser().getBrowser(browser);
		OpenNavigatorPage open = new OpenNavigatorPage(driver);
		open.OpenPage(browser);
	}
	
	@Test
	public void Accommodation() {
		
		SearchOption search = new SearchOption(driver);
		search.openAccommodation();
		Assert.assertTrue(search.confirmPlaceName().contains(placeName));
	}	
	
	@AfterClass
	public void tearDownTest() {
		OpenNavigatorPage close = new OpenNavigatorPage(driver);
		close.ClosePage();
	}	
	


}
