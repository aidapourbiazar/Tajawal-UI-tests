package com.tajawal.utils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
 * 
 * The class has all common methods which are used in all different pages
 * @author aida
 *
 */
public class DriverUtil {

	private WebDriver driver;
	

	public DriverUtil(WebDriver newDriver) {

		this.driver = newDriver;

	}

	public void maximizeBrowser() throws Exception {
		try {
			driver.manage().window().maximize();
		} catch (Exception e) {
			throw e;
		}

	}
	
	public void quitBrowser() throws Exception {
		try {
			driver.close();
		} catch (Exception e) {
			throw e;
		}

	}

	public void goToUrl(String url) throws Exception {
		try {
			driver.get(url);
		} catch (Exception e) {

			throw e;
		}
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public void input(By locator, String inputData) {
		
	      driver.findElement(locator).sendKeys(inputData);;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public String getPageTitle() throws Exception {
		String title = driver.getTitle();
		return title;

	}

	
	
	
	
	public void waitForElementToBeVisible(By locator, int timeout) {
		
		WebDriverWait wait = new WebDriverWait(driver, timeout); 
	    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}
		
	public List<WebElement> getElements(By locator) {		
			
			List<WebElement> elements = this.driver.findElements(locator);
			return elements;
	
	}


	public String getUrl(){		
			String url = this.driver.getCurrentUrl().trim();
			return url;
	
	}
	
	
}

