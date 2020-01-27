package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ZoomIn_ZoomOut {
	
	WebDriver driver;
	
	By zoomin = By.xpath("//a[@class='leaflet-control-zoom-in']");
	By zoomout = By.xpath("//a[@class='leaflet-control-zoom-out']");
	
	public ZoomIn_ZoomOut(WebDriver driver) {
		this.driver = driver;
	}
	
	public void ZoomIn() {
		driver.findElement(zoomin);
		Actions action = new Actions(driver);
		action.doubleClick();
	}
	public void ZoomOut() {
		driver.findElement(zoomout);
		Actions action = new Actions(driver);
		action.doubleClick();
	}

}
