package com.automation.tests.SelfPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FinElementLinkText {
    public static void main(String[] args) {
    //     when ever we see <a it is link text
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("_blank")).click();
        driver.findElement(By.partialLinkText(" checkbox 1")).click();
        driver.findElement(By.partialLinkText(" checkbox 2")).click();


       //driver.quit();
    }
}
