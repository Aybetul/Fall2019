package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
    public static void main(String[] args) throws  Exception
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("http://google.com");
        Thread.sleep(2000);
        // BY.name("q") --> name="q" this is one of the selenium locator , this q finds the input box
        WebElement search = driver.findElement(By.name("q"));
        //when we find the element use sendKeys() methods
        //Keys.ENTER --> this is like keyboard
        search.sendKeys("Java", Keys.ENTER);
        Thread.sleep(2000);
// the News in here from google page (news , images, map......)
        WebElement news = driver.findElement(By.linkText("News"));
        news.click();
        Thread.sleep(3000);
        driver.quit();
    }
}
