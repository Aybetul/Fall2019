package com.automation.tests.Vytrack.Activities;

import com.automation.utulities.BrowserUtils;
import com.automation.utulities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

public class CallPageTests {
  private  WebDriver driver;
    private String username = "storemanager85";
    private String password = "UserUser123";
    private Actions actions;
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private By activities = By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");
private By logBtnBy= By.cssSelector("a[title='Log call']");
private By calenderBtnBy=By.cssSelector("a[title='Create Calendar event']");
@BeforeMethod
    public void setUp(){
      driver= DriverFactory.createDriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();
        actions =new Actions(driver);
        BrowserUtils.wait(3);
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(3);
       actions.moveToElement(driver.findElement(activities)).perform(); // hover over activities
        BrowserUtils.wait(5);

    }
//    Scenario: Verify for store manager
//    Login as story manager
//    Go to Activities --> Calls
//    Verify that Log Call button is displayed
@Test (description = "Verify that Log Call button is displayed")
    public void logCall(){
        driver.findElement(By.linkText("Calls")).click();
    WebElement callbtn= driver.findElement(logBtnBy);
    BrowserUtils.wait(5);
        Assert.assertTrue(callbtn.isDisplayed());
   }




        public void tearDown() {
    driver.quit();
}



}
