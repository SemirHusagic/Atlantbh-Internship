package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangeLanguage {

	WebDriver driver;
	
	By eng = By.xpath("//a[@class='btn-en gaEvent']");
	By bs = By.xpath("//a[@class='btn-bs gaEvent']");
	By detect_eng = By.xpath("//ul[@class='navigation left']//li[2]");
	
	
	public ChangeLanguage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void changeToEng() {
		driver.findElement(eng).click();
	}
	
	public void changeToBs() {
		driver.findElement(bs).click();
	}
	public String confirmChange() {
		String titleOnEng = driver.findElement(detect_eng).getText();
		return titleOnEng;
	}
	
	
}
