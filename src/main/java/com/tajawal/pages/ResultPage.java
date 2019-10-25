package com.tajawal.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.tajawal.utils.DriverUtil;
/**
 * The class constructs result page elements needed for tests
 * @author aida
 */
public class ResultPage {

	private DriverUtil driverUtil;

	private By searchResult = By.className("search-result-leg-card");
	private String directStop = "stop-0";

	private By formLabel = By.className("form-check-label");
	private By primaryButton = By.xpath("//button[contains(@class,'btn-primary')]");
	private By resultStop = By.xpath("//span[@data-testid = 'FlightSearchResult__Itinerary1__Leg1__StopsLabel']");
	

	private By sortDropdown = By.xpath("//*[@id=\"root\"]/div[2]/div[1]/div[3]/div[2]/div[2]/div[2]/div/div/button");
	
	private By cheapestPrice = By.id("sortBy-price:asc");
	
	private By cheapestPriceValue = By.xpath("//*[@id=\"root\"]/div[2]/div[1]/div[3]/div[3]/div/div/div/div[2]/div/div/div[1]/div[2]");

	private By MinPricelabel = By.xpath("//div[contains(@data-testid,'PriceLabel')]");	
	
	public ResultPage(DriverUtil driverUtil) throws Exception {
		this.driverUtil = driverUtil;
		driverUtil.waitForElementToBeVisible(searchResult, 40);
	}

	
	
	public void selectShortStop() throws Exception {

		driverUtil.getElement(formLabel).click();

	}

	public TravellersPage selectFlight() throws Exception {
	
		driverUtil.getElement(primaryButton).click();
	
	return new TravellersPage(driverUtil);
	}
	
	
	
	public String getShortStopText() throws Exception {
	
		return driverUtil.getElement(formLabel).getText();

	}
	
	public String getResultStopTypes() throws Exception {
		
		return driverUtil.getElement(resultStop).getText();

	}
	

	public void sortPrice() throws Exception {
		getSortDropdown().click();
		driverUtil.waitForElementToBeVisible(searchResult, 30);
		verifyCheapestPrice();
	}
	
	public WebElement getSortDropdown() throws Exception {

		return driverUtil.getElement(sortDropdown);

	}
	
	
	public  boolean verifyCheapestPrice() throws Exception {
			
			return driverUtil.getElement(cheapestPrice).isSelected();

		}
		
      public  int getCheapestPriceValue() throws Exception {
    	  driverUtil.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return Integer.valueOf(driverUtil.getElement(cheapestPriceValue).getText().replaceAll("[,]", ""));

		}


	
      public int getMinPrice() {		
			
			List<WebElement> elements = driverUtil.getDriver().findElements(MinPricelabel);
			List<String> priceList = new ArrayList<String>();
		
			for(WebElement element : elements){
			
		priceList.add(element.getText().replaceAll("[,]", ""));
			System.out.println(element.getText().replaceAll("[,]", ""));
			    }
			
			
			 int minValue =Integer.valueOf(priceList.get(0));
			for(int i=0 ; i<priceList.size()-1 ; i++)
				{
			    if(Integer.valueOf(priceList.get(i)) >= Integer.valueOf(priceList.get(i+1))){
			    	minValue =Integer.valueOf(priceList.get(i+1));
			    }
			
				}
			return minValue;
	
	}

	
	
	
      

	}
	
	
