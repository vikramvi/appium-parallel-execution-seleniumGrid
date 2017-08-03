package com.appium.testng.listeners;

import io.appium.java_client.android.AndroidDriver;

public class LocalDriverManager {
    private static ThreadLocal<AndroidDriver> androidDriver = new ThreadLocal<AndroidDriver>();
    
    public static AndroidDriver getDriver() {
	return androidDriver.get();
    }
    
    static void setAndroidDriver(AndroidDriver driver) {
	androidDriver.set(driver);
    }
    
}
