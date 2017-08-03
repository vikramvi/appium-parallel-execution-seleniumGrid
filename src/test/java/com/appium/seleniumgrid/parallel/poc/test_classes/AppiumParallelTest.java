package com.appium.seleniumgrid.parallel.poc.test_classes;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

import com.appium.seleniumgrid.parallel.poc.AppiumGridSetup;
import com.appium.testng.listeners.LocalDriverManager;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumParallelTest extends AppiumGridSetup{
    //private AndroidDriver driver;
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
    
    private static boolean isMethodCalled = true;
    private static final Object countLock = new Object();
    
    //Synchronized Blocks
    //http://tutorials.jenkov.com/java-concurrency/synchronized.html
    //https://stackoverflow.com/questions/2120248/how-to-synchronize-a-static-variable-among-threads-running-different-instances-o
    /*public void setUpMethodForSingleRunOnly(){
	try {
                	synchronized (countLock){
                        	if(isMethodCalled){
                        	    SetupSeleniumGridAndAppiumNodesTest();                       	   
                        	    System.out.println("IN setUpMethodForSingleRunOnly");
                        	    isMethodCalled = false;
                        	    return;
                        	}
                	}        	
                	System.out.println("OUT setUpMethodForSingleRunOnly");
	}catch(Exception e) {
	    e.printStackTrace();
	}
    }*/
    
//    @BeforeClass
//    @Parameters({ "appName_" })
//    public void beforeClass(String appName){
//        long id = Thread.currentThread().getId();
//        System.out.println("@BeforeClass =  Thread id is: " + id);
//        //AndroidDriverSet(appName);
//    }
       
//    @BeforeSuite
//    public synchronized void setUpSeleniumGridAndDeviceNodes() {
//	try {
//	System.out.println("@BeforeSuite");
//	////setUpMethodForSingleRunOnly();
//	//System.setOut(new PrintStream( new FileOutputStream("eclipse_console_output.txt") ));
//	}catch(Exception e) {
//	    e.printStackTrace();
//	}
//    }
    
//    @BeforeTest(alwaysRun = true)
//    //@BeforeSuite(alwaysRun = true)
//    @Parameters({ "appName_" })
//    public synchronized void AndroidDriverSet(String appName){
//	try{
//	        long id = Thread.currentThread().getId();
//	        System.out.println("@BeforeTest =  Thread id is: " + id);
//	        //setUpMethodForSingleRunOnly();
//	        ////createDriver(appName);
//	}catch(Exception e) {	  
//	        e.printStackTrace();
//	}
//    }
    
    /*public synchronized void createDriver(String applicationName) throws MalformedURLException {
        try {                
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
    }*/

    //@Test
    public void launchTest() throws InterruptedException {
        System.err.println("Thread id: " + Thread.currentThread().getId());
        Thread.sleep(10000);
    }

    //@Test(dependsOnMethods = {"launchTest"})
    @Test
    public void clickTest(){
	try{
	        System.err.println("clickTest()    Thread id: " + Thread.currentThread().getId() + "       " + LocalDriverManager.getDriver().hashCode());
	    
	        Thread.sleep(2000);
               LocalDriverManager.getDriver().findElementById("com.wunderkinder.wunderlistandroid:id/LoginButton").click();
               LocalDriverManager.getDriver().navigate().back();
               LocalDriverManager.getDriver().navigate().back();
               Thread.sleep(2000);
	}catch(Exception e){	  
	    e.printStackTrace();
	    Assert.assertTrue(false);
	}
    }
    
    @Test
    public void clickTest_2(){
	try{
	       System.err.println("clickTest_2()    Thread id: " + Thread.currentThread().getId() + "       " + LocalDriverManager.getDriver().hashCode());
	    
	        Thread.sleep(2000);
	        LocalDriverManager.getDriver().findElementById("com.wunderkinder.wunderlistandroid:id/CreateAccountButton").click();
	        LocalDriverManager.getDriver().navigate().back();
	        LocalDriverManager.getDriver().navigate().back();
               Thread.sleep(2000);               
	}catch(Exception e){	  
	    e.printStackTrace();
	    Assert.assertTrue(false);
	}
    }
    

//    @AfterTest
//    public void afterTest() {
//        long id = Thread.currentThread().getId();
//        System.out.println("@AfterTest  =  Thread id is:  " + id);
//    }
    
    //@AfterSuite
//    @AfterClass
//    public void teardown() {
//	long id = Thread.currentThread().getId();
//        System.out.println("@AfterClass  =  Thread id is:  " + id);
//        
//        if (driver != null) {
//            driver.quit();
//        }
//    }
    
}
