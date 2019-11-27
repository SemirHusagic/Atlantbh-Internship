package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.ZoomIn_ZoomOut;


public class TestZoomFeature {
	
public WebDriver driver;
	
	@BeforeTest
	public void OpenPage() {	
	
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);      
		driver.get("http://navigator.ba/#/categories");
		driver.manage().window().maximize();
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
	
	@AfterTest
	public void tearDownTest() {
		driver.close();
		driver.quit();
	}


}
