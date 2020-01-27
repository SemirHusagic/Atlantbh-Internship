package helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class AuctionPage {
		
	public WebDriver driver;
	
	public AuctionPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void OpenPage() {
		
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		driver.get("https://auction-webapp.herokuapp.com/home");
		driver.manage().window().maximize();
	}
	
	public void ClosePage() {
		driver.close();
		driver.quit();
	}

}