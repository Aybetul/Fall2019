package com.automation.tests.day7;

import com.automation.utulities.BrowserUtils;
import com.automation.utulities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathPractice {
    public static void main(String[] args) {
    WebDriver driver=  DriverFactory.createDriver("chrome");
    driver.get("http://practice.cybertekschool.com/login");
        WebElement inputBox= driver.findElement(By.xpath("//label[text()='Username']/following-sibling::input"));
       inputBox.sendKeys("Hello All");
        BrowserUtils.wait(2);
       driver.quit();


    }
}
