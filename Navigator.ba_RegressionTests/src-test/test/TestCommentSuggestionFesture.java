package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import helper.OpenNavigatorPage;

import helper.Browser;
import page.SuggestFeatures;

 public class TestCommentSuggestionFesture {
	
	private String comment = "komentar";
	private String browser = "chrome";
	private String expected_message = "Hvala na poruci! Potrudit ćemo se da što prije reagujemo.";
	
	public WebDriver driver;
	
	@BeforeClass
	public void setUp() {	
		driver = new Browser().getBrowser(browser);
		OpenNavigatorPage open = new OpenNavigatorPage(driver);
		open.OpenPage(browser);
	}

	@Test
	public void SuggestFeature() {
		
		SuggestFeatures suggest = new SuggestFeatures(driver);
		
		suggest.opetSuggestFeatures();
		suggest.enterComment(comment);
		suggest.markRedCheck();
		suggest.clickSendButton();
		Assert.assertEquals(suggest.successMessage(), expected_message, "Message texts are not matching! ");

	}
	
	@AfterClass
	public void tearDownTest() {
		OpenNavigatorPage close = new OpenNavigatorPage(driver);
		close.ClosePage();
	}	
}