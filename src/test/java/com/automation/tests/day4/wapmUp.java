package com.automation.tests.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class wapmUp {
    public static void main(String[] args) {
//ebayTest();
//amazonTest();
wikiTest();
    }


    public static void ebayTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.ebay.com/");
        driver.findElement(By.name("_nkw")).sendKeys("java book", Keys.ENTER);
   String result = driver.findElement((By.tagName("h1"))).getText();
        System.out.println(result);
        System.out.println(result.split(" ")[0]);


                driver.quit();
    }

    public static void amazonTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
driver.get("http://amazon.com");
driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java book", Keys.ENTER);
String title = driver.getTitle();

        System.out.println(title.contains("java book")?"Test passed ":"Test failed");
driver.quit();
    }


    public static void wikiTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
driver.get("https://en.wikipedia.org/wiki/Main_Page");
driver.findElement(By.id("searchInput")).sendKeys("Selenium_(software)", Keys.ENTER); // ENTER and RETUrn does same thing
String link =driver.getCurrentUrl();
        System.out.println(link.endsWith("Selenium_(software)")?"Test passed":"Test failed");
        driver.quit();
    }

}
