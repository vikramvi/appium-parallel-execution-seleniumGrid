package com.wunderkinder.wunderlistandroid.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.appium.seleniumgrid.parallel.poc.AppiumGridSetup;

//@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources/WunderlistAndroid.feature"}, strict = false, format = { "pretty","json:target/cucumber.json" }, tags = { "~@ignore" })
public class WLSignIn extends AbstractTestNGCucumberTests{
    //private AndroidDriver driver;
    protected AppiumGridSetup gridObject = null;
        
    public void WLSignSetObject(){
	System.out.println("WLSign");
	setGridObjectDriver(gridObject);
    }
    
    @BeforeClass
    public void launchAppiumServer() throws MalformedURLException {
	try {          	   	    
        	    gridObject = new AppiumGridSetup();
        	    gridObject.SetupSeleniumGridAndAppiumNodesTest();
        	    	    
        	    System.out.println(gridObject.hashCode());            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void createMobileDriver(AppiumGridSetup gridObjectMethodParameter) {
	try{
        	  //?? gridObject is resetting to null, need to find out why
        	  gridObject = gridObjectMethodParameter;
        	    
                  String directoryPath = System.getProperty("user.dir");
                  
                  DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                  desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "ANDROID");
                  desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
                  desiredCapabilities.setCapability("applicationName", "dummy_Android_1");
                  desiredCapabilities.setCapability(MobileCapabilityType.APP, directoryPath + "/com.wunderkinder.wunderlistandroid.apk");
                  desiredCapabilities.setCapability("appActivity", "com.wunderkinder.wunderlistandroid.activity.WLStartViewFragmentActivity");
                  gridObject.driver = new AndroidDriver(new URL("http://127.0.0.1:4444/wd/hub"), desiredCapabilities);
                  
                  System.out.println(gridObject.driver.hashCode());
	}catch(Exception e) {
	    e.printStackTrace();
	}
    }
    
    //https://stackoverflow.com/questions/45559950/run-as-testng-is-not-shown-for-class-extending-abstracttestngcucumbertests
    //@Test(enabled=false)
    //public void dummyTestMethod() {}
    
    //@BeforeMethod
    public AndroidDriver getGridObjectDriver() {
	return gridObject.driver;
    }
    
    public void setGridObjectDriver(AppiumGridSetup appiumGridObject ) {
	this.gridObject=appiumGridObject;
    }
    
    @AfterClass
    public void killAppiumServer() throws IOException {
	//AppiumServerController.stopDriver();
	//AppiumServerController.stopAppiumServer();
	////if (driver != null) {
            ////driver.quit();
        ////}
    }
    
}
