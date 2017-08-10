package com.wunderkinder.wunderlistandroid.cucumber.steps.scenarios;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import static org.assertj.core.api.Assertions.assertThat;

import com.wunderkinder.wunderlistandroid.cucumber.pages.*;
import com.wunderkinder.wunderlistandroid.cucumber.WLSignIn;

import com.appium.seleniumgrid.parallel.poc.AppiumGridSetup;
import com.appium.testng.listeners.LocalDriverManager;

public class LandingPageScenariosSteps extends WLSignIn{

    protected WLLandingPage HomePage;
    protected WLSignInPage SignInPage;
    
    String validEmailId = "vikram@test.com";
            
    //Hooks in Cucumber
    //https://github.com/cucumber/cucumber/wiki/Hooks
    @Before
    //Why to pass Scenario object ??  
    //https://stackoverflow.com/questions/45588769/when-to-use-scenario-scenario-parameter-in-cucumber-jvm
    //accessing object from parent class directly didn't work, parent class object was always null ??
    //https://stackoverflow.com/questions/45592218/objects-created-in-parent-class-become-null-when-tried-to-access-in-child-class
    //public void setUp(Scenario scenario) throws Exception{
    public void setUp() throws Exception{
	////WLSignIn wlParent = new WLSignIn();
	////AppiumGridSetup apsObject = new AppiumGridSetup();
	
	////wlParent.createMobileDriver(apsObject);
	////System.out.println( wlParent.getGridObjectDriver() );
	
	////HomePage  =  new WLLandingPage(wlParent.getGridObjectDriver());
	////SignInPage =  new WLSignInPage(wlParent.getGridObjectDriver());
	HomePage   = new WLLandingPage(LocalDriverManager.getDriver());
	SignInPage  = new WLSignInPage(LocalDriverManager.getDriver());
    }
    
  //------- Given 
    
    @Given("^User is on Sign In Page$")
    public void gotoSignInPage(){
	assertThat( HomePage.gotoSignInScreen()).isTrue();
    }
        
    @Given("^User taps Forgot your password link$")
    public void clickForgotYourPasswordLink(){
	assertThat( SignInPage.clickWLForgotYourPasswordLink() ).isTrue();
    }
    
  //------- When
    
    @When("^User enters valid email id$")
    public void enterEmailId(){
	SignInPage.enterEmailId(validEmailId);
    }
    
    @When("^User keeps password field empty$")
    public void enterPassword(){
	SignInPage.enterPassword("");
    }
        
    @When("^User completes reset password actions$")
    public void doResetPasswordActions(){
	assertThat( SignInPage.completeResetPasswordFlow(validEmailId) ).isTrue();
    }
   //---------- Then
    
    @Then("^Sign In button remains in disabled state$")
    public void verifySignInButtonStatus(){
	assertThat( SignInPage.isSignInButtonEnabled() ).isFalse();
    }
    
    @Then("^User goes back to Sign In Page$")
    public void verifyUserIsTakenBackToLoginScreen(){
	assertThat(SignInPage.isSignInScreen() ).isTrue();
    }
        
}
