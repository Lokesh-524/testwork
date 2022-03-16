package com.qt.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.qt.base.BaseInitialiser;
import com.qt.pages.CartPage;
import com.qt.pages.HomePage;
import com.qt.pages.WishlistPage;

import io.cucumber.java.en.*;

public class QualitestSteps extends BaseInitialiser {
	public static Logger log = LogManager.getLogger(QualitestSteps.class);
	HomePage hp = new HomePage(driver);
	WishlistPage wp = new WishlistPage(driver);
	CartPage cp = new CartPage(driver);

	@Given("user login to demo page")
	public void user_login_to_demo_page() {
		String url = "https://testscriptdemo.com/";
		driver.get(url);
		Hooks.writeToReport("Url open successfully: " + url);
	}

	@When("^user add (\\d+) differnt products to 'My Wish' list$")
	public void userAddDifferntProductsToMyWishList(int pCount) throws Throwable {
		hp.addProducts();
		hp.clickWishlist();
	}

	@Then("^verify added products in wishlist table$")
	public void verifyAddedProductsInWishlistTable() {
		wp.verifyWishlisht();
	}

	@And("^add lowest price product to 'My Cart'$")
	public void addLowestPriceProductToMyCart() {
		wp.verifyLowPrice();
	}

	@And("^verify 'My Cart' item$")
	public void verifyMyCartItem() {
		cp.verifyCart();
	}
}
