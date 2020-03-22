package com.automation.tests.day12;

import com.automation.utulities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExpicitWait {
 WebDriver driver;

 @BeforeMethod
 public void setup() {
     driver = DriverFactory.createDriver("chrome");
 }
 @Test
  public void waitforTitle(){
    driver.get("http://google.com");
      WebDriverWait wait= new WebDriverWait(driver, 10);
      wait.until(ExpectedConditions.titleIs("Google"));
driver.navigate().to("http://amazon.com");
wait.until(ExpectedConditions.titleContains("Amazon"));



 }
 @Test
public void ExplicitWait(){
     driver.get("http://practice.cybertekschool.com/dynamic_loading/2");
     WebDriverWait wait= new WebDriverWait(driver, 10);
     WebElement btn=  driver.findElement(By.tagName("button"));
     wait.until((ExpectedConditions.elementToBeClickable(btn)));
     btn.click();
}


@AfterMethod
    public void teardown(){
     driver.quit();
}

}
