package com.qt.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qt.steps.Hooks;
import com.qt.utilities.DriverUtility;

public class HomePage {
	public static Logger log = LogManager.getLogger(HomePage.class);
	WebDriver driver;

	@FindBy(xpath = "(//li[contains(@class,'product type')])[1]//*[@data-title='Add to wishlist']")
	private WebElement lnk_p1wishlist;

	@FindBy(xpath = "(//li[contains(@class,'product type')])[2]//*[@data-title='Add to wishlist']")
	private WebElement lnk_p2wishlist;

	@FindBy(xpath = "(//li[contains(@class,'product type')])[3]//*[@data-title='Add to wishlist']")
	private WebElement lnk_p3wishlist;

	@FindBy(xpath = "(//li[contains(@class,'product type')])[4]//*[@data-title='Add to wishlist']")
	private WebElement lnk_p4wishlist;

	@FindBy(xpath = "(//*[@class='header-wishlist'])[1]")
	private WebElement btn_wishlist;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void addProducts() {
		try {
			DriverUtility.waitForSpecificTime(1);
			DriverUtility.waitForElementClickable(lnk_p1wishlist);
			lnk_p1wishlist.click();
			DriverUtility.waitForSpecificTime(2);
			DriverUtility.waitForElementClickable(lnk_p2wishlist);
			lnk_p2wishlist.click();
			DriverUtility.waitForSpecificTime(2);
			DriverUtility.waitForElementClickable(lnk_p3wishlist);
			lnk_p3wishlist.click();
			DriverUtility.waitForSpecificTime(2);
			DriverUtility.waitForElementClickable(lnk_p4wishlist);
			lnk_p4wishlist.click();
			Hooks.writeToReport("Four different products added to wishlist successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickWishlist() {
		try {
			btn_wishlist.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
