package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import helper.Browser;
import helper.OpenNavigatorPage;
import page.SearchOption;

public class TestContentMenuAccommodation {
	
	private String browser = "chrome";
	
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
	}	
	
	@AfterClass
	public void tearDownTest() {
		OpenNavigatorPage close = new OpenNavigatorPage(driver);
		close.ClosePage();
	}	
	


}
