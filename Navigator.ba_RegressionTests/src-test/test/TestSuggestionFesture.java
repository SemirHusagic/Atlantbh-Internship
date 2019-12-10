package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
	private String expected_message = "Hvala na poruci! Potrudit ćemo se da što prije reagujemo.";
	private String error_message = "Message texts are not matching! ";
	
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
		Assert.assertEquals(suggest.successMessage(), expected_message, error_message);
	}
	
	@AfterClass
	public void tearDownTest() {
		OpenNavigatorPage close = new OpenNavigatorPage(driver);
		close.ClosePage();
	}	
}