package com.appium.seleniumgrid.parallel.poc.test_classes;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumSingleDeviceTest {
       private AndroidDriver driver;
    
     //make sure you can install apk from command line first on emulator
      //run selenium server hub and appium node from command line
       //then run the test case for debug purpose
       
       
    @BeforeClass   
    public void setup() throws MalformedURLException {
        try {
            //SetupSeleniumGridAndAppiumNodesTest();
 
            String directoryPath = System.getProperty("user.dir");
            
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "ANDROID");
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
            desiredCapabilities.setCapability("applicationName", "dummy_Android_1");
            desiredCapabilities.setCapability(MobileCapabilityType.APP, directoryPath + "/com.wunderkinder.wunderlistandroid.apk");
            desiredCapabilities.setCapability("appActivity", "com.wunderkinder.wunderlistandroid.activity.WLStartViewFragmentActivity");
            driver = new AndroidDriver(new URL("http://127.0.0.1:4444/wd/hub"), desiredCapabilities);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Test
    public void clickTest() {
	try{
	    Thread.sleep(5000);
	driver.findElementById("com.wunderkinder.wunderlistandroid:id/LoginButton").click();
	Thread.sleep(5000);
	}catch(Exception e){
	    e.printStackTrace();
	}
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
