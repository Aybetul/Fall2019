package com.automation.tests.day12;

import com.automation.utulities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
 public void waitFrrVisibility(){
     driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
     WebDriverWait wait= new WebDriverWait(driver,10);
     driver.findElement(By.tagName("button")).click();

     WebElement userName= driver.findElement(By.name("username"));
     WebElement password= driver.findElement(By.name("password"));
     WebElement Summitbtn= driver.findElement(By.cssSelector("button[type='submit']"));

     wait.until(ExpectedConditions.visibilityOf(userName)).sendKeys("tomsmith");
     wait.until(ExpectedConditions.visibilityOf(password)).sendKeys("SuperSecretPassword");

     wait.until(ExpectedConditions.visibilityOf(Summitbtn)); // we can use more condition
     wait.until(ExpectedConditions.elementToBeClickable(Summitbtn)).click();

     String expected = "Welcome to the Secure Area. When you are done click logout below.";
     String actual = driver.findElement(By.className("subheader")).getText();
     Assert.assertEquals(actual, expected);

 }
 @Test
 public void elementToBeClickableTest(){
     driver.get("http://practice.cybertekschool.com/dynamic_loading/5");
     WebDriverWait wait= new WebDriverWait(driver,10);
     WebElement userName= driver.findElement(By.name("username"));
     WebElement password= driver.findElement(By.name("password"));
     WebElement SmtBtn= driver.findElement(By.cssSelector("button[type='submit']"));
     WebElement overlayScreen=driver.findElement(By.cssSelector("[class='fa fa-cog fa-spin']"));


     wait.until(ExpectedConditions.invisibilityOf(overlayScreen)); // we had to add this condition because overlay screen was te problem
     wait.until(ExpectedConditions.elementToBeClickable(SmtBtn)); // wait till Submit button is clickable

     userName.sendKeys("tomsmith");
     password.sendKeys("SuperSecretPassword");
     SmtBtn.click();

     String expected = "Welcome to the Secure Area. When you are done click logout below.";
     String actual = driver.findElement(By.className("subheader")).getText();
     Assert.assertEquals(actual, expected);

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
