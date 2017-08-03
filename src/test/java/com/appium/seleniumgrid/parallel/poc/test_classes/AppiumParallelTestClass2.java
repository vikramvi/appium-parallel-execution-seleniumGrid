package com.appium.seleniumgrid.parallel.poc.test_classes;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.appium.seleniumgrid.parallel.poc.AppiumGridSetup;
import com.appium.testng.listeners.LocalDriverManager;

public class AppiumParallelTestClass2 extends AppiumGridSetup{
   
    @Test
    public void clickTest2_1(){
	try{
	        System.err.println("clickTest2_1()  Thread id: " + Thread.currentThread().getId() + "       " + LocalDriverManager.getDriver().hashCode() );
	        Thread.sleep(2000);
	        LocalDriverManager.getDriver().findElementById("com.wunderkinder.wunderlistandroid:id/LoginButton").click();
	        LocalDriverManager.getDriver().navigate().back();
	        LocalDriverManager.getDriver().navigate().back();
	        LocalDriverManager.getDriver().findElementById("com.wunderkinder.wunderlistandroid:id/LoginButton").click();
	        LocalDriverManager.getDriver().navigate().back();
	        LocalDriverManager.getDriver().navigate().back();
	        LocalDriverManager.getDriver().findElementById("com.wunderkinder.wunderlistandroid:id/LoginButton").click();
	        LocalDriverManager.getDriver().navigate().back();
	        LocalDriverManager.getDriver().navigate().back();
               Thread.sleep(2000);
	}catch(Exception e){
	    e.printStackTrace();
	    System.err.println("clickTest2_1()  Thread id: " + Thread.currentThread().getId());
	    Assert.assertTrue(false);
	}
    }
}
