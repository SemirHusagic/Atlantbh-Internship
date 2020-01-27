package newproject;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



public class SmokeTest {
	static WebDriver driver;
	
	public static void moveMarkerLeft(String pixels)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementsByClassName('leaflet-marker-icon')[0].style.marginLeft = \"-" + pixels + "\"");
	}
	
	 public static void main(String[] args) throws InterruptedException {
	        
		 System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
	        
	        //open the web app
	        driver.get("http://navigator.ba/#/categories");  	       	 	        
	        driver.manage().window().maximize();	               	        
	              
	        //open window
	        WebElement createplace = driver.findElement(By.xpath("//span[contains(text(),'Kreiraj objekat')]"));
	        Actions action = new Actions(driver);
	        action.moveToElement(createplace);
	        action.click();
	        action.perform();
	        Thread.sleep(2000);	        	        
	        
	        //typing the text
	        WebElement Name = driver.findElement(By.id("poi_name"));
	        		Name.sendKeys("Milky");
        
	        //add category	 
	        
	        WebElement addcategory = driver.findElement(By.xpath("//button[@class='ember-view btn btn-small']"));	        
	        action.moveToElement(addcategory).click().perform();
	        
	        WebElement dropdown1 = driver.findElement(By.xpath("//div[@class='span3']//select"));
	        Select selectElement = new Select (dropdown1);
	        selectElement.selectByValue("5");
	        action.click();
	        
	        WebElement dropdown2 = driver.findElement(By.xpath("//div[3]//select[1]"));
	        Select selectElement1 = new Select (dropdown2);
	        selectElement1.selectByValue("52");
	        action.click();
	        
	        WebElement dropdown3 = driver.findElement(By.xpath("//div[@class='span4']//select"));
	        Select selectElement2 = new Select (dropdown3);
	        selectElement2.selectByValue("51");
	        action.click();
       
	        //move marker	
//	        moveMarkerLeft("120px");    
      
	        //scroll down and click on cerate	        
	        WebElement createButton = driver.findElement(By.xpath("//button[@class='btn btn-success']"));
	        WebElement slideBar = driver.findElement(By.xpath("//div[@class='mCSB_dragger']"));
	        action.clickAndHold(slideBar).moveToElement(createButton).release().build().perform();
	        action.moveToElement(createButton).click().perform();
	        
	        action.pause(java.time.Duration.ofSeconds(15)).perform();	        
	        driver.navigate().refresh();
	        
	        //search for created object	        
	        WebElement Trazi = driver.findElement(By.xpath("//input[@class='ember-view ember-text-field tt-query']"));
	        action.moveToElement(Trazi).sendKeys("Milky").perform();
	        WebElement searchButton = driver.findElement(By.xpath("//span[@class='iconav-search']"));
	        action.moveToElement(searchButton).click().perform();
	        WebElement suggest = driver.findElement(By.xpath("//li[4]"));
	        action.moveToElement(suggest).click(suggest).perform();  
	        
	        action.pause(java.time.Duration.ofSeconds(15)).perform();
	        
	        //close window	        
	        driver.close();		
      
	 }	       

}