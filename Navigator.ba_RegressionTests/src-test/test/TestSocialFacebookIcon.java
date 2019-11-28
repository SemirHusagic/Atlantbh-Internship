package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.SocialBar;

public class TestSocialFacebookIcon {

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
	public void FacebookIcon() {
		
		SocialBar facebook = new SocialBar(driver);
		
		facebook.opetFacebook();
	}
	
	@AfterTest
	public void tearDownTest() {
		driver.close();
		driver.quit();
	}
}