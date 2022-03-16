package com.qt.utilities;

public class PropHolder {
	private static String browserName;
	private static String environment;

	public static String getEnvironment() {
		return environment;
	}

	public static void setEnvironment(String env) {
		environment = env;
	}

	public static String getBrowserName() {
		return browserName;
	}

	public static void setBrowserName(String browser) {
		browserName = browser;
	}
}
