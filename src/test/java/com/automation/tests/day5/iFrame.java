package com.automation.tests.day5;

import com.automation.utulities.BrowserUtils;
import com.automation.utulities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class iFrame {
    public static void main(String[] args) {
        WebDriver driver= DriverFactory.createADriver("chrome") ;
        driver.get("http://practice.cybertekschool.com/iframe");
        BrowserUtils.wait(2);
        driver.switchTo().frame("mce_0_ifr");
        WebElement textInput= driver.findElement(By.id("tinymce"));
       BrowserUtils.wait(2);
        System.out.println(textInput.getText()); // will show in the out put "Your content goes here."
        BrowserUtils.wait(2);
        textInput.clear(); // to clear the txt
        textInput.sendKeys("Hello, World ");
        BrowserUtils.wait(2);
driver.switchTo().defaultContent();
WebElement heading = driver.findElement(By.tagName("h3"));
        System.out.println(heading.getText());
        driver.quit();
    }
}
