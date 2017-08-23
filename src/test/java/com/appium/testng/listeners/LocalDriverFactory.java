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
                  
                  
                  //WebDriver vs RemoteWebDriver
                  //https://groups.google.com/forum/#!topic/webdriver/4h7YWWOQ60M
                  // RemoteWebDriver > AppiumDriver > AndroidDriver / iOSDriver
                   //https://discuss.appium.io/t/appiumdriver-or-android-ios-driver-mobileelement-webelement/14489/2
                  //"...For WebDriver nodes, you will need to use the RemoteWebDriver and the DesiredCapabilities object...."
                  //https://github.com/SeleniumHQ/selenium/wiki/Grid2
                  //How to start an AppiumDriver when the server is launched remotely or locally
                  //https://github.com/appium/appium-dotnet-driver/wiki/How-to-start-an-AppiumDriver-when-the-server-is-launched-remotely-or-locally
                   driver = new AndroidDriver(new URL("http://192.168.2.48:4444/wd/hub"), desiredCapabilities);
                   
        	  return driver;
	 }catch(Exception e) {
	     e.printStackTrace();
	     return null;
	 }
     }
}
