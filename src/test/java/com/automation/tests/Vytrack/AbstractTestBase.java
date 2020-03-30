package com.automation.tests.Vytrack;

import com.automation.utulities.ConfigurationReader;
import com.automation.utulities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



public abstract class AbstractTestBase {
    protected WebDriverWait  wait;
    protected Actions actions;


     //Driver.getDriver().get(URL);
     //We instantiate webDriver (=new className) in Driver class under utilities package.
    //getDriver();  method will return us driver object that comes from driver class.
    //call the static getDriver() method through the classNAme
    //By doing this; we will know that we are always calling the same driver
    @BeforeMethod
    public void setup(){
        String URL= ConfigurationReader.getProperty("qa1");
        Driver.getDriver().get(URL);
        Driver.getDriver().manage().window().maximize();
        wait=new WebDriverWait(Driver.getDriver(), 15);
        actions=new Actions(Driver.getDriver()) ;

    }

    @AfterMethod
    public void teardown(){
      Driver.closeDriver();
    }






}
