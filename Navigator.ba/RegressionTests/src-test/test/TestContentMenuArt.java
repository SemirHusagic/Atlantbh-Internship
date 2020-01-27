package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import helper.Browser;
import helper.OpenNavigatorPage;
import page.SearchOption;

public class TestContentMenuArt {	
	
	private String browser = "chrome";
	private String art = "PS4 klub ArenA";
	
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
		search.openArt();
		Assert.assertTrue(search.confirmArtName().contains(art));
	}
	
	@AfterClass
	public void tearDownTest() {
		OpenNavigatorPage close = new OpenNavigatorPage(driver);
		close.ClosePage();
	}	
	
}
