package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SearchOption {
	
	public WebDriver driver;
	
	By search = By.xpath("//input[@class='ember-view ember-text-field tt-query']");
	By menu_content_list= By.xpath("//ul[@class='menu_content_list categories']");
	By sarajevoTheatres = By.xpath("//div[contains(text(),'SARAJEVO THEATRES')]");	
	By kamerni = By.xpath("//body[@class='ember-application']/div[@class='ember-view application-container']/div[@class='container-fluid full-height']/div[@class='row-fluid full-height']/div/div/div[@class='ember-view left-menu-pane list-container mCustomScrollbar _mCS_2']/div[@class='mCustomScrollBox mCS-light loading is-loaded']/div[@class='mCSB_container']/ul[@class='menu_content_list list-items']/li[3]/a[1]/div[1]/div[1]");
	By nextbike = By.xpath("//body[@class='ember-application']/div[@class='ember-view application-container']/div[@class='container-fluid full-height']/div[@class='row-fluid full-height']/div/div/div[@class='ember-view left-menu-pane categories-container mCustomScrollbar _mCS_6']/div[@class='mCustomScrollBox mCS-light loading is-loaded']/div[@class='mCSB_container']/ul[@class='menu_content_list categories']/div[2]/li[1]/a[1]/div[2]");
	By smokefree = By.xpath("//body[@class='ember-application']/div[@class='ember-view application-container']/div[@class='container-fluid full-height']/div[@class='row-fluid full-height']/div/div/div[@class='ember-view left-menu-pane categories-container mCustomScrollbar _mCS_6']/div[@class='mCustomScrollBox mCS-light loading is-loaded']/div[@class='mCSB_container']/ul[@class='menu_content_list categories']/div[3]/li[1]/a[1]/div[2]");

	By accommodation = By.xpath("//li[@class='accommodation']//div[@class='content']");
	By coffee = By.xpath("//li[@class='coffee']//div[@class='content']");
	By nightlife = By.xpath("//li[@class='nightlife']//div[@class='content']");
	By shopping = By.xpath("//li[@class='shopping']//div[@class='content']");
	By attractions = By.xpath("//li[@class='attractions']//div[@class='content']");
	By art = By.xpath("//li[@class='art']//div[@class='content']");
	By sport = By.xpath("//li[@class='sport']//div[@class='content']");
	By transport = By.xpath("//li[@class='transport']//div[@class='content']");
	By services = By.xpath("//li[@class='services']//div[@class='content']");
	By business = By.xpath("//li[@class='business']//div[@class='content']");
	By street = By.xpath("//li[@class='street']//div[@class='content']");
	By slidebar = By.xpath("//div[@class='mCSB_dragger']");
	
	public SearchOption(WebDriver driver) {
		this.driver = driver;
	}
	
	public void openAccommodation() {
		
		Actions action = new Actions(driver);
		driver.findElement(accommodation).click();
		WebElement hotel = driver.findElement(By.xpath("//div[contains(text(),'Plavi zamak')]"));
		action.moveToElement(hotel).click().perform();
	}
	
	public void openArt() {
		
		Actions action = new Actions(driver);
		WebElement arts = driver.findElement(art);
        WebElement slideBar = driver.findElement(slidebar);
		action.clickAndHold(slideBar).moveToElement(arts).release().build().perform();
		action.moveToElement(arts).click().perform();
		WebElement hotel = driver.findElement(By.xpath("//div[contains(text(),'Bilijar klub')]"));
		action.moveToElement(hotel).click().perform();
	}
	
	
	
}