package com.qt.testrunners;

import java.io.File;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.qt.utilities.PropHolder;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/feature", glue = "com.qt.steps", plugin = {
		"junit:target/cucumber-report.xml",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, tags = "@REG")

public class BaseRunner extends AbstractTestNGCucumberTests {
	private static Logger logger = LogManager.getLogger(BaseRunner.class);

	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}

	@Parameters({ "browserName", "environment" })
	@BeforeTest
	public void setEnvDetails(@Optional("Chrome") String browserName, @Optional("qa") String environment) {
		// Delete existing screenshots
		String dir = System.getProperty("user.dir") + "\\Reports\\Screenshots";
		File file = new File(dir);
		for (File f : file.listFiles()) {
			if (f.getName().endsWith(".png")) {
				f.delete();
			}
		}
		logger.info("Existing Report Cleared");
		PropHolder.setEnvironment(environment);
		PropHolder.setBrowserName(browserName);
		//ConfigHelper.getInstance();
		logger.info("Environment Setup Successful. Browser: " + browserName + ", Environment: " + environment);
	}
}
