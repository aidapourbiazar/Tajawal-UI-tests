package com.tajawal.tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tajawal.base.BaseTest;
import com.tajawal.pages.HomePage;

import com.tajawal.pages.ResultPage;
import com.tajawal.pages.TravellersPage;
import com.tajawal.utils.GenerateTestData;
import com.tajawal.utils.JsonTravellersMapper;

/**
 * 
 * @author aida
 */

public class FlightSearchTests extends BaseTest {

	private JsonTravellersMapper travellersdata;

	GenerateTestData testData = new GenerateTestData();

	@BeforeMethod(alwaysRun = true, enabled = true)
	@Override
	public void setup() throws Exception {
		super.setup();
		home = new HomePage(driverUtil);
		travellersdata = JsonTravellersMapper.get("src/test/resources/travellersContact.json");
	}

	@DataProvider
	public Object[][] languages() {
		return new Object[][] { { "en", "tajawal" } };// , {"en", "almosafer"}};
	}

	@Test(dataProvider = "languages")
	public void firstScenario(String language, String url) throws Exception {

		initializeTest(language, url);

		initProperties(language);
		ResultPage result = home.searchFlight(GenerateTestData.FromInputList(), GenerateTestData.ToInputList());

		result.selectShortStop();
		if (result.getShortStopText().contains("direct")) {
			Assert.assertEquals(result.getResultStopTypes(), getValue("directFlight"));
		} else if (result.getShortStopText().contains("1 stop")) {
			Assert.assertEquals(result.getResultStopTypes(), getValue("oneStop"));
		}
		TravellersPage traveller = result.selectFlight();
		traveller.fillContactForm(travellersdata.getTitle(), travellersdata.getFirstname(),
				travellersdata.getLastname(), travellersdata.getEmail(), travellersdata.getPhoneNumber());
		driverUtil.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		traveller.goToPayment();
		traveller.verifyTravellersformPresent();

	}

	@Test(dataProvider = "languages")
	public void secondScenario(String language, String url) throws Exception {

		initializeTest(language, url);
		initProperties(language);
		ResultPage result = home.searchFlight(GenerateTestData.FromInputList(), GenerateTestData.ToInputList());
		Thread.sleep(3000);
		result.sortPrice();
		Assert.assertEquals(result.getMinPrice(), result.getCheapestPriceValue());

	}
}
