package helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class OpenAuctionPage {
	
	public WebDriver driver;
	
	public OpenAuctionPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void OpenPage(String browser) {
		
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		driver.get("https://auction-webapp.herokuapp.com/shop");
		driver.manage().window().maximize();
	}
	
	public void ClosePage() {
		driver.close();
		driver.quit();
	}

}
