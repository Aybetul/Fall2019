package com.automation.tests.SelfPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Practice4_FindingElementByClass {
    public static void main(String[] args) throws  Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com");
    Thread.sleep(3000);
    List<WebElement> list = driver.findElements(By.className("list-group-item"));
    for(WebElement each: list ){
        System.out.println(each.getText());
    }

        System.out.println(list.size());
    driver.close();
    }
}
