package com.automation.tests.day4;

import com.automation.utulities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class VerifyThatElementGone {
    public static void main(String[] args)throws  Exception {
      WebDriver driver=  DriverFactory.createADriver("chrome");
     driver.get("http://practice.cybertekschool.com/multiple_buttons");
Thread.sleep(2000);
driver.findElement(By.id("disappearing_button")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElements(By.id("disappearing_button")).size()==0?"Test passed ":"Test failed"); // we could use isEmpty() also

   //  List <WebElement> button =driver.findElements(By.class("h3"));
     driver.quit();
    }
}
