package com.automation.pages;

import com.automation.utulities.BrowserUtils;
import com.automation.utulities.ConfigurationReader;
import com.automation.utulities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {


    @FindBy(id="prependedInput")
    private WebElement userName;

    @FindBy(id="prependedInput2")
    private WebElement password;

    @FindBy (id="_submit")
    private WebElement login;

    @FindBy(linkText="Forgot your password?")
    private WebElement forgotPassword;

    @FindBy(css="[class='alert alert-error']")
    private WebElement warningMessage;

    //this is constructor
    //to connect our web driver , page class and page factory
    // page factory-> use @FindBy annotations
    //page factory ->helps to find the element easier
     public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);


    }
   // this is for specific users
    public void login(String usernameValue, String passwordValue){
    userName.sendKeys(usernameValue);
    password.sendKeys(passwordValue,Keys.ENTER);
    BrowserUtils.waitForPageToLoad(10);
    BrowserUtils.wait(3);
  //  login.click();
  }

      // This is for default user
      //We over loaded the Login
       public void login(){
        userName.sendKeys(ConfigurationReader.getProperty("store_manager"));
        password.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.wait(3);
        //login.click();
    }

       //returns warning message for invalid credentials
        public String getWarningText(){
         return warningMessage.getText();
 }




}
