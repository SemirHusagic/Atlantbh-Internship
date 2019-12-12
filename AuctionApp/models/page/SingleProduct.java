package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class SingleProduct {
	
	private String auctionNoStarted = "Auction not started, as expected.";
	private String bidPassed = "Congrats! You are the highest bider";
	private String bidFail = "Bid did not succeed.";	
	private String alreadyBid = "You are already highest bidder";

	
	public WebDriver driver;
	
	By enterBidField = By.xpath("//input[@placeholder='Enter bid']");
	By placeBidButton = By.xpath("//button[@class='bid-button']");
	By highestPriceDivPath = By.xpath("//p[contains(text(),'Highest bid:')]");
	By detailsDivPath = By.xpath("//div[@class='details']");
	By currentDivPath = By.xpath("//div[@class='current-bid']");
	By pageTitle = By.xpath("//span[contains(text(),'single product')]");	
	By startsIn = By.xpath("//div[@class='current-bid']");
	By congrats = By.xpath("//p[contains(text(),'Congrats! You are the highest bider')]");
	By alert = By.xpath("//div[@class='alert-wrapper']");
	
	
	public SingleProduct(WebDriver driver) {
		this.driver = driver;
	}
	
	public void waitToLoad() {
		Actions action = new Actions(driver);
		action.pause(java.time.Duration.ofSeconds(3)).perform();
	}
	
	public void enterBid(String price) {
		if(price != "Auction not started.") {
			driver.findElement(enterBidField).sendKeys(price);
		}
			
	}
	
	public void clickPlaceBid(String price) {
		if(price != "Auction not started.")
			driver.findElement(placeBidButton).click();
	}
	
	public String getPageTitle() {
		String title = driver.findElement(pageTitle).getText();
		return title;
	}
	
	
	public String getHighestPriceDiv() {
		return driver.findElement(highestPriceDivPath).getText();
	}
	
	public String getDetailsDiv() {
		return driver.findElement(detailsDivPath).getText();
	}
	
	public String getCurrentDiv() {
		return driver.findElement(currentDivPath).getText();
	}
	
	public String parsePrice(String s) {
		//parse the first double value after the '$' sign
		String value = "";
		
		for(int i=0; i < s.length(); i++) {
			if(s.charAt(i) == '$') {
				i++;
				while(s.charAt(i) != '.') {
					value += s.charAt(i);
					i++;
				}
				for(int j = i; j < i+3; j++)
					value += s.charAt(j);
				break;
			}
		}
		return value;

	}

	public String enterBidPrice() {
		String currentBidDiv = getCurrentDiv();
		
		//If auction is not started yet, do not do anything
 		if(currentBidDiv.indexOf("Starts in") != -1) return "Auction not started.";
 		else {
 			//Auction started
 			String detailsDiv = getDetailsDiv();
 			String highestPriceDiv = getHighestPriceDiv();
 			
 			//Parse Start From price and Highest Bid price
 			String sf = parsePrice(detailsDiv);
 			String hb = parsePrice(highestPriceDiv);
 			
 			//Cast/change type from String to Double
 			double startFromPrice = Double.parseDouble(sf);
 			double highestBidPrice = Double.parseDouble(hb);
 			
 			double finalBid;
 			
 			//Return next bid value
 			if(highestBidPrice == 0.00) finalBid = startFromPrice + 10.0;
 			else finalBid = highestBidPrice + 10.0;
 			
 			String finalBidStr = Double.toString(finalBid);
 			finalBidStr = finalBidStr.replace('.', ',');
 			
 			return finalBidStr;
 		}
	}
	
	public void sendAssertNoAuction(String status) {
		if(status == "Auction not started.") {
			String noBidButton = driver.findElement(startsIn).getText();
			Assert.assertTrue(noBidButton.contains("Starts in:"), auctionNoStarted);
		}
	}
	
	public void sendAssert(String status) {
		if(status != "Auction not started."){
			String alertWrapper = driver.findElement(alert).getText();
			if(alertWrapper.indexOf(bidPassed) == -1) {
				String successBid = driver.findElement(congrats).getText();
				Assert.assertEquals(successBid, bidPassed, bidFail);
			}
			else if(alertWrapper.indexOf(alreadyBid) == -1) {
				Assert.assertEquals(alert, alreadyBid, bidFail);
			}
				
			
			
		}
	}
	
}

