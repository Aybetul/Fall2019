package com.automation.tests.day6;

import com.automation.utulities.BrowserUtils;
import com.automation.utulities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Alert {
    public static void main(String[] args) {
    WebDriver driver= DriverFactory.createDriver("chrome");
    driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(2);
    List<WebElement> alerts= driver.findElements(By.tagName("button"));
    // fist alert
    alerts.get(0).click();
        BrowserUtils.wait(2);
        String  textMessage= driver.switchTo().alert().getText(); // give the alert text
        System.out.println("textMessage = " + textMessage);
        driver.switchTo().alert().accept(); // switch  to alert and click the ok
String expected= "You successfully clicked an alert";
String actual= driver.findElement(By.id("result")).getText();
        System.out.println(actual.equals(expected)?"Passed":"Failed");
        System.out.println("expected = " + expected);
        System.out.println("actual = " + actual);
        BrowserUtils.wait(2);


      //second alert
      alerts.get(1).click();
      driver.switchTo().alert().dismiss();  // clicks on the cancel
        String expected1= "You clicked: Cancel";
        String actual1= driver.findElement(By.id("result")).getText();
        System.out.println(actual1.equals(expected1)?"Passed":"Failed");
        System.out.println("expected1 = " + expected1);
        System.out.println("actual1 = " + actual1);

        BrowserUtils.wait(2);
        // third alert
        alerts.get(2).click();
        driver.switchTo().alert().sendKeys("Hello world");
        BrowserUtils.wait(2);
        driver.switchTo(). alert().accept();
        String expected2= "You entered: Hello world";
        String actual2= driver.findElement(By.id("result")).getText();
        System.out.println(actual2.equals(expected2)?"Passed":"Failed");
        System.out.println("expected2 = " + expected2);




    driver.quit();
    }
}
