package com.tajawal.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.tajawal.utils.DriverUtil;


/**
 * The class constructs Second result page elements needed for tests
 * @author aida
 */
public class TravellersPage {
	
	private DriverUtil driverUtil;
	
	private By phoneNUmer=By.name("contact.phoneNumber");
	private By firstName =By.name("contact.firstName");
	private By lastName = By.name("contact.lastName");
	private By emailAddress =By.name("contact.email");
	private By selectTitle =By.name("travellers.0.title");
	private By continueButton = By.xpath("//button[@data-testid ='FlightPAX__ContinueToPaymentButton']");
	private By firstNameError = By.xpath("//div[@data-testid ='FlightPAX__Adult1__FirstNameErrorLabel");
	private By lastNameError = By.xpath("//div[@data-testid ='FlightPAX__Adult1__LastNameErrorLabel");
    private By travellersIdForm = By.id("travellerDetailsForm");
	public TravellersPage(DriverUtil driverUtil) throws Exception {
		this.driverUtil = driverUtil;
		driverUtil.waitForElementToBeVisible(selectTitle, 30);

	}

	public void fillContactForm(String Title, String firstName, String lastName,String emailAddress, String phone) {
	selectTitle(Title);
	putFirstName(firstName);
	putLastName(lastName);
	putEmailAddress(emailAddress);
	putPhoneNumber(phone);
		
	}

	public void selectTitle(String title) {
		WebElement month_dropdown = driverUtil.getElement(selectTitle);
		Select month=new Select(month_dropdown);
		 
		List<WebElement> dropdown=month.getOptions();
		 
		 for(int i=0;i<dropdown.size();i++){
		 
				 if (dropdown.get(i).getText().equalsIgnoreCase(title)) 
					 dropdown.get(i).click();
		 
		 }
		
	}

	public void putLastName(String lastname) {
		driverUtil.getElement(lastName).sendKeys(lastname);

	}

	public void putPhoneNumber(String phone) {
		driverUtil.getElement(phoneNUmer).sendKeys(phone);
		
	}

	public void putEmailAddress(String email) {
		driverUtil.getElement(emailAddress).sendKeys(email);
		
	}

	public void putFirstName(String firstname) {
		driverUtil.getElement(firstName).sendKeys(firstname);
		
	}
	
	public void goToPayment()  {
		driverUtil.getElement(continueButton).click();
		
	}
	

	public boolean verifyFirstNameWarningPresent() {
	    try {
	    	driverUtil.getElement(firstNameError);
	        return true;
	    } catch (org.openqa.selenium.NoSuchElementException e) {
	        return false;
	    }
	}

	public boolean verifylastNameWarningPresent() {
	    try {
	    	driverUtil.getElement(lastNameError);
	        return true;
	    } catch (org.openqa.selenium.NoSuchElementException e) {
	        return false;
	    }
	}
	
	public String verifyUrlTravellersPage() {
	    
	    	String url = driverUtil.getUrl();
	   return url;
	}

	public void verifyTravellersformPresent() {
		driverUtil.waitForElementToBeVisible(travellersIdForm, 10);

		
	}
	


	}
	
	
