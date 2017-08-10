package com.appium.testng.listeners;

import io.appium.java_client.android.AndroidDriver;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;

import org.testng.ITestResult;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import com.appium.seleniumgrid.parallel.poc.AppiumGridSetup;

//https://rationaleemotions.wordpress.com/2013/07/31/parallel-webdriver-executions-using-testng/
public class DriverListener extends AppiumGridSetup implements IInvokedMethodListener, ISuiteListener{

    @Override
    public void onStart(ISuite suite) {
	System.out.println("START suite  " + suite.getName());
	SetupSeleniumGridAndAppiumNodesTest();
    }
    
    @Override
    public void onFinish(ISuite suite) {
	System.out.println("FINISH suite  " + suite.getName());
    }
    
    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
	System.out.println("INSIDE beforeInvocation ");
	if (method.isTestMethod()) {
	     String applicationName = method.getTestMethod().getXmlTest().getLocalParameters().get("appName_");
	     AndroidDriver driver = LocalDriverFactory.createInstance(applicationName);
	     System.err.println("beforeInvocation  Thread id: " + Thread.currentThread().getId() + "       " + driver.hashCode());
	     LocalDriverManager.setAndroidDriver(driver);
	}
    }
    
    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
	System.out.println("INSIDE afterInvocation");
        if (method.isTestMethod()) {
            AndroidDriver driver = LocalDriverManager.getDriver();
            if (driver != null) {
                driver.quit();
            }
        }
    }
    
    
    
}
