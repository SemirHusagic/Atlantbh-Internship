package helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class OpenNavigatorPage {

	public WebDriver driver;
	
	public OpenNavigatorPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void OpenPage(String browser) {
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);      

		driver.get("http://navigator.ba/#/categories");
	    driver.manage().window().maximize();
	}
	
	public void ClosePage() {
		driver.close();
		driver.quit();
		
	}
}
