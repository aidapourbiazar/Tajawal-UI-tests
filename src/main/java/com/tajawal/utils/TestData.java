package com.tajawal.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 * 
 * The class has random data I need
 * @author aida
 *
 */
public class TestData {


	private static String randomElement;
	private static String randomToElement;

	public static String FromInputList() {
	    java.util.Random rand = new Random();
	    List<String> givenList = Arrays.asList("DXB", "AUH", "SHJ", "JED", "RUH");
	 
	    int numberOfElements = 4;

	    for (int i = 0; i < numberOfElements; i++) {
	        int randomIndex = rand.nextInt(givenList.size());
	  randomElement = givenList.get(randomIndex);
	    }
	 
	    return randomElement;
	}

	public static String ToInputList() {
	    java.util.Random rand = new Random();
	    List<String> givenList = Arrays.asList("AMM", "CAI", "DEL", "KHI", "PAR");
	   
	    int numberOfElements = 4;
	// String randomElement = null;
	    for (int i = 0; i < numberOfElements; i++) {
	        int randomIndex = rand.nextInt(givenList.size());
	   randomToElement = givenList.get(randomIndex);
	    }
	   
	    return randomToElement;
	}

	
	


}
