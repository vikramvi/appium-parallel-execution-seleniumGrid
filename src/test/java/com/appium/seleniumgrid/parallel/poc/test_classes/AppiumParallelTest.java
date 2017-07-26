package com.appium.seleniumgrid.parallel.poc.test_classes;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import com.appium.seleniumgrid.parallel.poc.AppiumGridSetup;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumParallelTest extends AppiumGridSetup{
    private AndroidDriver driver;
    private String applicationName;

    /*@Factory(dataProvider = "parallelDp")
    public AppiumParallelTest(String applicationName) {
        this.applicationName = applicationName;
    }

    @DataProvider(name = "parallelDp")
    public static Object[][] parallelDp() {
        return new Object[][] {
                {"dummy_Android_1"},
                {"dummy_Android_2"}
        };
    }*/

    //@BeforeClass
    @BeforeTest(alwaysRun = true)
    @Parameters({ "appName_" })
    public void AndroidDriverSet(String appName){
	try{
	        setup(appName);
	}catch (MalformedURLException e) {	  
	        e.printStackTrace();
	}
    }
    
    public void setup(String applicationName) throws MalformedURLException {
        try {
            //SetupSeleniumGridAndAppiumNodesTest();
            String directoryPath = System.getProperty("user.dir");
            
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "ANDROID");
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
            desiredCapabilities.setCapability("applicationName", applicationName);
            desiredCapabilities.setCapability(MobileCapabilityType.APP, directoryPath + "/com.wunderkinder.wunderlistandroid.apk");           
            desiredCapabilities.setCapability("appActivity", "com.wunderkinder.wunderlistandroid.activity.WLStartViewFragmentActivity");
            //desiredCapabilities.setCapability("--local-timezone", true);
                        
            driver = new AndroidDriver(new URL("http://127.0.0.1:4444/wd/hub"), desiredCapabilities);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //@Test
    public void launchTest() throws InterruptedException {
        System.err.println("Thread id: " + Thread.currentThread().getId());
        Thread.sleep(10000);
    }

    //@Test(dependsOnMethods = {"launchTest"})
    @Test
    public void clickTest(){
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
