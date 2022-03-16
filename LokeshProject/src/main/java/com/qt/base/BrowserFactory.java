package com.qt.base;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class BrowserFactory {
	public static WebDriver driver;
	private static Logger logger = LogManager.getLogger(BrowserFactory.class);

	public static void openBrowser(String browserType) throws MalformedURLException {

		if (browserType.toLowerCase().equals("chrome")) {
			System.setProperty("webdriver.chrome.silentOutput", "true");
			System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("profile.default_content_setting_values.notifications", 2);
			chromePrefs.put("safebrowsing.enabled", true);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", chromePrefs);
			options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			driver = new ChromeDriver(options);
		}
	}

	public static WebDriver createWebDriver(String browserName) {
		try {
			openBrowser(browserName);
			logger.info("Driver Instance Created");
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	public static void destroyDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
		System.gc();
	}
}
