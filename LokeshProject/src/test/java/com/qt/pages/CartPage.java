package com.qt.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qt.steps.Hooks;
import com.qt.utilities.DriverUtility;

public class CartPage {

	public static Logger log = LogManager.getLogger(CartPage.class);
	WebDriver driver;

	@FindBy(xpath = "(//*[@class='header-cart'])[1]")
	private WebElement btn_myCart;

	@FindBy(xpath = "//*[contains(@class,'wishlist_table')]//tbody")
	private WebElement tb_myWishlist;

	@FindBy(xpath = "//*[contains(@class,'shop_table')]//tbody/tr/td[3]/a")
	private WebElement val_pdtName;

	@FindBy(xpath = "//*[contains(@class,'shop_table')]//tbody/tr/td[4]//bdi")
	private WebElement val_pdtPrice;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyCart() {
		try {
			DriverUtility.waitForSpecificTime(2);
			btn_myCart.click();
			DriverUtility.waitForSpecificTime(1);
			String pName = val_pdtName.getText();
			String pPrice = val_pdtPrice.getText();
			Hooks.writeToReport("Cart Product details.\nProduct Name: " + pName + "\n Product Price: " + pPrice);
			Hooks.takeScreenshot();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
