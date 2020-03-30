package com.automation.tests.SelfPractice;

import com.automation.utulities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class OfficeHoursFrames {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= DriverFactory.createDriver("chrome");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void test(){
        driver.get("http://practice.cybertekschool.com/nested_frames");
        driver.switchTo().frame("frame-top");
        List<WebElement> frameList = driver.findElements(By.xpath("//frame"));
        /*
            we have stored all frames webelements inside the list
            1. Loop through list
            2. swithch to each frame
                a. get test from body
                b. switch to parent
         */
        for (WebElement each : frameList){
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.switchTo().frame(each);
            String bodyText = driver.findElement(By.tagName("body")).getText();
            System.out.println("bodyText   "+bodyText);
            driver.switchTo().parentFrame();

        }
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.name("frame bottom")));
        driver.quit();
    }
}
