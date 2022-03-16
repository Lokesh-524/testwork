package com.qt.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qt.base.BrowserFactory;

public class DriverUtility extends BrowserFactory {

	public static void waitForElementClickable(WebElement element) {
		try {
			webdriverwait().until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static WebDriverWait webdriverwait() {
		return new WebDriverWait(driver, 30);
	}

	public static void waitForSpecificTime(double numOfSec) {
		try {
			Thread.sleep((long) (numOfSec * 1000));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
