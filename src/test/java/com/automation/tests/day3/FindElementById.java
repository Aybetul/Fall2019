package com.automation.tests.day3;

import com.automation.utulities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindElementById {
    public static void main(String[] args) throws  Exception{
      WebDriver driver=  DriverFactory.createADriver("chrome");
      driver.get("http://practice.cybertekschool.com/login");
      // log way
//        WebElement login= driver.findElement(By.name("username"));
//        login.sendKeys("tomsmith");
// short way
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        Thread.sleep(3000);

        WebElement password= driver.findElement((By.name("password")));
        password.sendKeys("SuperSecretPassword");
        Thread.sleep(3000);
       driver.findElement(By.id("wooden_spoon")).click();
        Thread.sleep(3000);
      driver.quit();
    }
}
