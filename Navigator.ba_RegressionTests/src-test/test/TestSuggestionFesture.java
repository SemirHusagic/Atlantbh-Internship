package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import helper.Browser;
import helper.OpenNavigatorPage;
import page.SuggestFeatures;

public class TestSuggestionFesture {
	
	private String name = "Muamer";
	private String email = "asdfg@hotmail.com";
	private String comment  = "komentar";
	private String browser = "chrome";
	
	public WebDriver driver;
	
	@BeforeClass
	public void OpenPage() {
		driver = new Browser().getBrowser(browser);
		OpenNavigatorPage open = new OpenNavigatorPage(driver);
		open.OpenPage(browser);
	}

	@Test
	public void SuggestFeature() {
		
		SuggestFeatures suggest = new SuggestFeatures(driver);		
		suggest.opetSuggestFeatures();
		suggest.enterNameAndSurname(name);
		suggest.enterEmail(email);
		suggest.enterComment(comment);
		suggest.markGreenCheck();
		suggest.clickSendButton();
	}
	
	@AfterClass
	public void tearDownTest() {
		OpenNavigatorPage close = new OpenNavigatorPage(driver);
		close.ClosePage();
	}	
}