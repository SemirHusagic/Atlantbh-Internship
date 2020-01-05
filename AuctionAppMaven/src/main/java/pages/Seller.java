package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Seller {
	
	By sellerButton = By.xpath("/html[1]/body[1]/app-root[1]/app-profile[1]/ul[1]/li[2]/a[1]");
	By activeProductButton = By.xpath("/html[1]/body[1]/app-root[1]/app-profile[1]/app-seller[1]/section[1]/ul[1]/li[1]/p[1]");
	By soldProductButton = By.xpath("/html[1]/body[1]/app-root[1]/app-profile[1]/app-seller[1]/section[1]/ul[1]/li[2]/p[1]");
//	By = By.xpath("");
//	By = By.xpath("");
//	By = By.xpath("");
//	By = By.xpath("");
//	By = By.xpath("");
//	By = By.xpath("");
//	By = By.xpath("");
//	By = By.xpath("");
//	By = By.xpath("");
	
	public WebDriver driver;
	
	public Seller(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickSeller() {
		driver.findElement(sellerButton).click();
//		WebElement button = driver.findElement(sellerButton);
//		WebDriverWait wait = new WebDriverWait(driver, 1);
//        wait.until(ExpectedConditions.elementToBeClickable(button));
	}
	
	public void findProduct(String product) {
		WebElement element = driver.findElement(By.xpath("//td[contains(text(),'"+ product +"')]"));
		scrollTo(element);
		waitForLoad();
		
	}
	//ako proizvod XY odgovara tom redu onda klikni na element view
	//ako ime proizvoda XY odgovara stringu XY
	
	public void selectRow(String productName) {
		List<WebElement> rows = driver.findElements(By.xpath("//body//tbody//tr"));
		
		for(int i=1; i<=rows.size(); i++) {
			String product = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-profile[1]/app-seller[1]/section[1]/app-table[1]/section[1]/table[1]/tbody[1]/tr["+ i +"]/td[2]")).getText();
			
			if(product.compareTo(productName) == 0) {
				WebElement element = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-profile[1]/app-seller[1]/section[1]/app-table[1]/section[1]/table[1]/tbody[1]/tr["+ i +"]/td[2]"));
				scrollToProduct(element);
				waitForLoad();
				driver.findElement(By.xpath("//tr["+ i +"]//td[8]//a[1]")).click();
			}
				
		}
	}
	
	
//	public String rowNo(String value)
//	{
//	   WebElement table =driver.findElement(By.id("tableId"));
//	   WebElement tbody=table.findElement(By.tagName("tbody"));
//	   List<WebElement> rows=tbody.findElements(By.tagName("tr"));
//	   ArrayList<String> ListOdIds=new ArrayList<>();
//	   String rowNo="";
//	   for(int i=0;i<rows.size();i++)
//	   {
//	     WebElement row = tbody.findElement(By.xpath("//table[@id='tableId']/tbody/tr["+(i+1)+"]"));
//	     if(row.getText().trim().contains(value))
//	     {
//	        rowNo=Integer.toString(i+1); 
//	            break;
//	     }
//
//	   }
//
//	   return rowNo;
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void scrollToCardInformation() {
		WebElement element = driver.findElement(activeProductButton);
		scrollTo(element);
		waitForLoad();
	}
	
	public void waitForLoad() {
		Actions action = new Actions(driver);
		action.pause(java.time.Duration.ofSeconds(2)).perform();
	}
	public void scrollTo(WebElement element) {		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}	
	
	
	public void scrollToProduct(WebElement element) {		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}	
	

}