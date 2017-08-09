package com.wunderkinder.wunderlistandroid.cucumber.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.concurrent.TimeUnit;

//import com.wunderkinder.wunderlistandroid.utils.Helpers;

public class WLLandingPage{
    
    //-------------------------------------------------------------------------------------------
    //Mobile Elements Identifiers
    //-------------------------------------------------------------------------------------------
    
    @AndroidFindBy(id="com.wunderkinder.wunderlistandroid:id/LoginButton")
    MobileElement WLSignInButton;
    
    @AndroidFindBy(id="com.wunderkinder.wunderlistandroid:id/header_title_textview")
    MobileElement WLSignInScreenTitle;
    
    //Cross platform testing example for Android & iOS using Appium
    //https://blog.jayway.com/2016/06/30/cross-platform-testing-example-android-ios-using-appium/
    //https://github.com/appium/java-client/issues/52#issuecomment-49777944  WebElement, RemoteWebElement, MobileElement
    
    //-------------------------------------------------------------------------------------------
    //Methods to do actions in this Page Object 
    //-------------------------------------------------------------------------------------------
    protected final AppiumDriver driver;
    
    public WLLandingPage(AppiumDriver driver){
	this.driver = driver;
	PageFactory.initElements(new AppiumFieldDecorator(driver, 15, TimeUnit.SECONDS), this);
    }
    
    public boolean gotoSignInScreen(){
	if(WLSignInButton.isDisplayed()){
	    WLSignInButton.click();
	}
	
	if(WLSignInScreenTitle.isDisplayed()){
	    return true;
	}else{
	    return false;
	}
    }
              
}
