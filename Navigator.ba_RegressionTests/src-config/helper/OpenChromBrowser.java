//package helper;
//
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class OpenChromBrowser {
//
//	public WebDriver driver;
//	
//	public void WebSiteOpen() {
//		
//	System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
//	driver = new ChromeDriver();
//	driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);      
//    driver.get("http://navigator.ba/#/categories");
//    driver.manage().window().maximize();
//	}
//	
//	public OpenChromBrowser(WebDriver driver) {
//		this.driver = driver;
//	}
//	public WebDriver getDriver() {
//		return this.driver
//	}
//}
