package com.automation.tests.day11;

import com.automation.utulities.BrowserUtils;
import com.automation.utulities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecuter2 {

  private WebDriver driver;
  @BeforeMethod
  public void setup(){
      driver= DriverFactory.createDriver("chrome");
      driver.get("http://practice.cybertekschool.com/");
      driver.manage().window().maximize();
  }
  @Test
public void verifyTitle(){
String expectedTitle="Practice";
    JavascriptExecutor js=(JavascriptExecutor) driver;

    String actualTitle=  js.executeScript("return document.title").toString(); //this javascript code
 // String actualTitle= (String) js.executeScript("return document.title");
      Assert.assertEquals(actualTitle,expectedTitle);
}
public void clickOn(){
WebElement link= driver.findElement(By.linkText("Multi Buttons"));
link.click();
JavascriptExecutor js= (JavascriptExecutor) driver;
js.executeScript("argument[0].click()", link);

}







@AfterMethod
public void teardown(){
    BrowserUtils.wait(2);
   driver.quit();
}




}
