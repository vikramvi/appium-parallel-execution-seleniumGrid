package com.appium.testng.listeners;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

public class LocalDriverFactory {
     static AndroidDriver createInstance(String applicationName) {
	 try {
        	  AndroidDriver driver = null;
                  String directoryPath = System.getProperty("user.dir");
                  
                  DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                  desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "ANDROID");
                  desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
                  desiredCapabilities.setCapability("applicationName", applicationName);
                  desiredCapabilities.setCapability(MobileCapabilityType.APP, directoryPath + "/com.wunderkinder.wunderlistandroid.apk");           
                  desiredCapabilities.setCapability("appActivity", "com.wunderkinder.wunderlistandroid.activity.WLStartViewFragmentActivity");
                  //desiredCapabilities.setCapability("--local-timezone", true);
                              
                   driver = new AndroidDriver(new URL("http://127.0.0.1:4444/wd/hub"), desiredCapabilities);
                   
        	  return driver;
	 }catch(Exception e) {
	     e.printStackTrace();
	     return null;
	 }
     }
}
