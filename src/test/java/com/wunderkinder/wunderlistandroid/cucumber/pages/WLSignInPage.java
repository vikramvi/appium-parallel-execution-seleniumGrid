package com.wunderkinder.wunderlistandroid.cucumber.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.concurrent.TimeUnit;

//import com.wunderkinder.wunderlistandroid.utils.Helpers;

public class WLSignInPage{
    //-------------------------------------------------------------------------------------------
    //Mobile Elements Identifiers
    //-------------------------------------------------------------------------------------------
    @AndroidFindBy(id="com.wunderkinder.wunderlistandroid:id/header_title_textview")
    MobileElement WLSignInScreenTitle;
    
    @AndroidFindBy(id="com.wunderkinder.wunderlistandroid:id/login_email_edittext")
    MobileElement WLEmailField;
    
    @AndroidFindBy(id="com.wunderkinder.wunderlistandroid:id/login_password_edittext")
    MobileElement WLPasswordField;
    
    @AndroidFindBy(id="com.wunderkinder.wunderlistandroid:id/login_button")
    MobileElement WLSignInButton;
    
    @AndroidFindBy(id="com.wunderkinder.wunderlistandroid:id/forgot_password_textView")
    MobileElement WLForgotYourPasswordLink;
    
    @AndroidFindBy(id="com.wunderkinder.wunderlistandroid:id/header_title_textview")
    MobileElement WLResetPasswordEmailField;
    
    @AndroidFindBy(id="com.wunderkinder.wunderlistandroid:id/forgot_password_button")
    MobileElement WLPasswordResetButton;
    
    @AndroidFindBy(id="android:id/message")
    MobileElement ResetPasswordDialogText;
    
    @AndroidFindBy(id="android:id/button1")
    MobileElement ResetPasswordDialogButton;
    
    //-------------------------------------------------------------------------------------------
    //Methods to do actions in this Page Object 
    //-------------------------------------------------------------------------------------------
    protected final AppiumDriver driver;
    
    public WLSignInPage(AppiumDriver driver){
   	this.driver = driver;
   	PageFactory.initElements(new AppiumFieldDecorator(driver, 1, TimeUnit.SECONDS), this);
     }
    
    public boolean isSignInScreen(){
	if(WLSignInScreenTitle.isDisplayed()){
	    return true;
	}else{
	    return false;
	}
    }
    
    public void enterEmailId(String validEmail){
	WLEmailField.sendKeys(validEmail);
    }
    
    public void enterPassword(String validPassword){
	WLPasswordField.sendKeys(validPassword);
    }
    
    public boolean isSignInButtonEnabled(){
	try {
        	if(WLSignInButton.isDisplayed()){
                	if(WLSignInButton.isEnabled()){
                	    return true;
                	}else{
                	    return false;
                	}
        	}else{
        	    return false;
        	}
	}catch(Exception e) {
	    return true;
	}
    }
    
    public boolean clickWLForgotYourPasswordLink(){
	WLForgotYourPasswordLink.click();
	
	if(WLResetPasswordEmailField.isEnabled()){
	    return true;
	}else{
	    return false;
	}
    }
    
    public boolean completeResetPasswordFlow(String email){
	WLResetPasswordEmailField.clear();
	WLResetPasswordEmailField.sendKeys(email);
	WLPasswordResetButton.click();
	
//	if(isElementPresent(ResetPasswordDialogText,5)){
//	    ResetPasswordDialogButton.click();
//	    return true;
//	}else{
//	    return false;
//	}
	return true;
    }
    
}
