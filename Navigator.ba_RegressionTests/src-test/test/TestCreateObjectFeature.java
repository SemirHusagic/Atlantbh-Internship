package test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.CreatePlace;

public class TestCreateObjectFeature {
	
	private String name = "Dell";
	private String city = "Sarajevo";
	private String zipcode = "71000";
	
	
	public WebDriver driver;
	
	@BeforeTest
	public void OpenPage() {	
		
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);      
	    driver.get("http://navigator.ba/#/categories");
	    driver.manage().window().maximize();
	}
	
	@Test
	public void CreatePlaceTest() {
		
		CreatePlace place = new CreatePlace(driver);
		
		place.OpenCreatePlace();
		place.enterName(name);
		place.enterCity(city);
		place.enterZipCode(zipcode);
		place.scroolCreatePlaceWindowToBottom();
		place.clickCreateButton();
	}
	
	@AfterTest
	public void tearDownTest() {
		driver.close();
		driver.quit();

	}	
	
	
}