package com.automation.tests.SelfPractice;

import com.automation.utulities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EtsyTask {
WebDriver driver;


@BeforeMethod
    public void setup(){
      driver= DriverFactory.createDriver("chrome");

    }
@Test
public void etsy(){
    driver.get("http://etsy.com");
driver.findElement(By.xpath("//*[@id=\"gnav-search\"]/div/div[1]")).sendKeys("Handmade vase");

}



}
