package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import helper.Browser;
import helper.OpenNavigatorPage;
import page.CreatePlace;

public class TestCreateObjectFeature {
		
	private String browser = "chrome";
	private String name = "Dell";
	private String city = "Sarajevo";
	private String zipcode = "71000";
	private String expected_error = "Forma sadrži nevalidne podatke. Molimo ispravite i pokušajte ponovo";
	
	public WebDriver driver;
	
	@BeforeClass
	public void OpenPage() {	
		driver = new Browser().getBrowser(browser);
		OpenNavigatorPage open = new OpenNavigatorPage(driver);
		open.OpenPage(browser);
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
		Assert.assertEquals(place.errorMessage(), expected_error, "Error texts are not matching! ");
	}
	
	@AfterClass
	public void tearDownTest() {
		OpenNavigatorPage close = new OpenNavigatorPage(driver);
		close.ClosePage();
	}		
}
