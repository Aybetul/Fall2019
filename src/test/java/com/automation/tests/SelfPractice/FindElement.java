package com.automation.tests.SelfPractice;

import com.automation.utulities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.util.List;
import java.util.Set;

public class FindElement {
    public static void main(String[] args)throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
 // WebDriver driver= DriverFactory.createADriver("chrome");

       driver.get("https://amazon.com");
        Thread.sleep(2000);
       driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Multi vitamin", Keys.ENTER);
        Thread.sleep(2000);
       driver.findElement(By.name("landingImage")).click();
       Thread.sleep(2000);
        System.out.println(driver.getTitle());
        driver.quit();




    }
}
