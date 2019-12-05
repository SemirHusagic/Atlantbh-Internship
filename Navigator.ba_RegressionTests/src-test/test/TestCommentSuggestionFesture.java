package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import helper.OpenNavigatorPage;

import helper.Browser;
import page.SuggestFeatures;

 public class TestCommentSuggestionFesture {
	
	private String comment = "komentar";
	private String browser = "chrome";
	
	public WebDriver driver;
	
	@BeforeTest
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
	}
	
	@AfterTest
	public void tearDownTest() {
		OpenNavigatorPage close = new OpenNavigatorPage(driver);
		close.ClosePage();
	}	
}