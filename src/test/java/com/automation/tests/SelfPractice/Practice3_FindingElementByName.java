package com.automation.tests.SelfPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice3_FindingElementByName {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        WebElement button2= driver.findElement(By.name("button2"));
        button2.click();
      //  button2.getText();
        System.out.println(button2.getText());
        WebElement result = driver.findElement(By.id("result"));
        System.out.println(result);
    }
}
