package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
	
	public static WebDriver driver;
	
	public WebDriver getBrowser (String browserType) {
		
	switch(browserType) {
			
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
			ChromeOptions opt = new ChromeOptions();
			opt.setExperimentalOption("w3c", false);
			return driver = new ChromeDriver(opt);
			
			
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "driver/geckodriver");
			return driver = new FirefoxDriver();
			
		default:
			return driver = new ChromeDriver();
		}
	}
}