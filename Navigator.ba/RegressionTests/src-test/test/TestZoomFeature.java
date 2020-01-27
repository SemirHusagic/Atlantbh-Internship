package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import helper.Browser;
import helper.OpenNavigatorPage;
import page.ZoomIn_ZoomOut;


public class TestZoomFeature {
	
	private String browser = "chrome";
	
	public WebDriver driver;
	
	@BeforeClass
	public void OpenPage() {	
		driver = new Browser().getBrowser(browser);
		OpenNavigatorPage open = new OpenNavigatorPage(driver);
		open.OpenPage(browser);
	}
	
	@Test(priority = 0)
	public void ZoomInMap() {		
		
		ZoomIn_ZoomOut zoom = new ZoomIn_ZoomOut(driver);
		zoom.ZoomIn();		
	}
	
	@Test(priority = 1)
	public void ZoomOutMap() {		
		
		ZoomIn_ZoomOut zoom = new ZoomIn_ZoomOut(driver);
		zoom.ZoomOut();	
	}
	
	@AfterClass
	public void tearDownTest() {
		OpenNavigatorPage close = new OpenNavigatorPage(driver);
		close.ClosePage();
	}
}