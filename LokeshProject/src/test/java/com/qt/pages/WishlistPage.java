package com.qt.pages;

import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qt.steps.Hooks;

public class WishlistPage {
	public static Logger log = LogManager.getLogger(WishlistPage.class);
	WebDriver driver;

	@FindBy(xpath = "//*[contains(@class,'wishlist_table')]//tbody")
	private WebElement tb_myWishlist;

	@FindBy(xpath = "//*[contains(@class,'wishlist_table')]//tbody/tr[1]//td[contains(@class,'product-price')]/span/bdi")
	private WebElement val_p1Price;

	@FindBy(xpath = "//*[contains(@class,'wishlist_table')]//tbody/tr[2]//td[contains(@class,'product-price')]/ins//span/bdi")
	private WebElement val_p2Price;

	@FindBy(xpath = "//*[contains(@class,'wishlist_table')]//tbody/tr[3]//td[contains(@class,'product-price')]/ins//span/bdi")
	private WebElement val_p3Price;

	@FindBy(xpath = "//*[contains(@class,'wishlist_table')]//tbody/tr[4]//td[contains(@class,'product-price')]//span/bdi")
	private WebElement val_p4Price;	

	public WishlistPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyWishlisht() {
		try {
			int prds = tb_myWishlist.findElements(By.tagName("tr")).size();
			if (prds == 4) {
				Hooks.writeToReport("All the four products are displayed in 'My Wishlist' table");
				Hooks.takeScreenshot();
			} else {
				log.info("FAIL: All the four products are not displayed in 'My Wishlist' table");
				Assert.fail("FAIL: All the four products are not displayed in 'My Wishlist' table");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyLowPrice() {
		try {
			double[] vals = new double[4];
			vals[0] = Double.parseDouble((val_p1Price.getText()).substring(1));
			vals[1] = Double.parseDouble((val_p2Price.getText()).substring(1));
			vals[2] = Double.parseDouble((val_p3Price.getText()).substring(1));
			vals[3] = Double.parseDouble((val_p4Price.getText()).substring(1));
			Arrays.sort(vals);
			double min = vals[0];
			String xp = "(//bdi[contains(text(),'" + min + "')])[1]/parent::*/../../following-sibling::td[2]/a";
			driver.findElement(By.xpath(xp)).click();
			Hooks.writeToReport("Lowest Price item added to 'My Cart' successfully\nMin value of product: " + min);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
