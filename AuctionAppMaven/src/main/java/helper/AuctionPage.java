package helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class AuctionPage {
		
	public WebDriver driver;
	
	public AuctionPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void OpenPage() {
		
		int width = 1440;
		int height = 800;
		Dimension dimension = new Dimension(width, height);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		driver.get("https://polar-lake-39918.herokuapp.com/home");
		driver.manage().window().setSize(dimension);
	}
	
	public void ClosePage() {
		driver.close();
		driver.quit();
	}

}