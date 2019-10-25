package com.tajawal.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.tajawal.utils.DriverUtil;
import com.tajawal.utils.GenerateTestData;

/**
 * The class constructs Home page elements needed for tests
 * @author aida
 *
 */
public class HomePage {
	private DriverUtil driverUtil;

private By FromSearch = By.xpath("//input[@data-testid = 'FlightSearchBox__FromAirportInput']");


private By ToSearch = By.xpath("//input[@data-testid = 'FlightSearchBox__ToAirportInput']");

private By option1Search = By.xpath("//li[@data-testid = 'FlightSearchBox__AirportOption1']");

private By searchButton = By.xpath("//button[@data-testid = 'FlightSearchBox__SearchButton']");
private String attNameDataId = "data-testid";

	public HomePage(DriverUtil driverUtil) throws Exception {
		this.driverUtil = driverUtil;

	}

	/**
	 * 
	 * @return ResultPage
	 * @throws Exception
	 */
	public ResultPage searchFlight(String SearchFrom,String ToInput) throws Exception {
		
		SearchFrom(SearchFrom);

		driverUtil.getDriver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		
		chooseflightOption();
		driverUtil.getDriver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
	
	
		searchTo(ToInput);
		driverUtil.getDriver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
	
	
		chooseflightOption();
		driverUtil.getDriver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;

		clickSubmit();

		return new ResultPage(driverUtil);
	}

	private void clickSubmit() {
		driverUtil.getElement(searchButton).click();	
	}

	public void SearchFrom(String fromInput) {

		driverUtil.getElement(FromSearch).sendKeys(fromInput);		
	}
	public void searchTo(String toInput) {
		driverUtil.getElement(ToSearch).sendKeys(toInput);
		
	}
	public void chooseflightOption() {
		driverUtil.getElement(option1Search).click();
		
	}
	
	
	
	
}

