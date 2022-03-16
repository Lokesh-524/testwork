package com.qt.steps;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.qt.base.BaseInitialiser;
import com.qt.base.BrowserFactory;
import com.qt.utilities.PropHolder;

import io.cucumber.java.*;

public class Hooks extends BaseInitialiser {
	private static Logger logger = LogManager.getLogger(Hooks.class);
	public static Scenario sc;

	@Before
	public void beforeScenario(Scenario scenario) throws IOException {
		String browserName = PropHolder.getBrowserName();
		driver = BrowserFactory.createWebDriver(browserName);
		logger.info("************* Scenario: " + scenario.getName() + ": Started *************");		
		sc = scenario;
	}

	@After
	public void afterScenario(Scenario scenario) throws Exception {
		if (scenario.isFailed()) {
			takeScreenshot();
		}
		BrowserFactory.destroyDriver();
		logger.info("Browser Closed");
		logger.info("__________________________________________________________________________________________\n");
	}

	public static void takeScreenshot() {
		String screenshotName = sc.getName().replaceAll(" ", "");
		byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		sc.attach(sourcePath, "image/png", screenshotName);
		logger.info("Screen captured and added to report...");
	}

	public static void writeToReport(String msg) {
		logger.info(msg);
		ExtentCucumberAdapter.addTestStepLog(msg);
	}
}
