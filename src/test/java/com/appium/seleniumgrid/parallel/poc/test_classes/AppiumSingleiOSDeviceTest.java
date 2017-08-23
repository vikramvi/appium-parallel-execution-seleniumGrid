package com.appium.seleniumgrid.parallel.poc.test_classes;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;

import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import com.appium.seleniumgrid.parallel.poc.AppiumGridSetup;

public class AppiumSingleiOSDeviceTest extends AppiumGridSetup{

    @BeforeClass
    public void setup() throws MalformedURLException {
	String directoryPath = System.getProperty("user.dir");
	
	DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
	desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
	desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 7");
	desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.3");
	desiredCapabilities.setCapability(MobileCapabilityType.APP, directoryPath + "/SIP.app");
	
	//start appium server externally before running this test case
	driverParent = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
    }
    
    @Test
    public void enterValue() {
	try {
	       Thread.sleep(5000);
	       driverParent.findElementByXPath("//XCUIElementTypeTextField").sendKeys("123");
	}catch(Exception e) {
	    e.printStackTrace();
	}
    }
    
    @AfterClass
    public void tearDown() {
	if (driverParent != null) {
            driverParent.quit();
        }
    }
    
}
