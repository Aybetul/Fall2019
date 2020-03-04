package com.automation.tests.SelfPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Practice1_FindingElementByID {
    public static void main(String[] args)throws  Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://google.com");
    WebElement element = driver.findElement(By.id("gbqfbb"));
    //element.click();
        String actualResult= element.getAttribute("value");
        String expectedResult= "I'm Feeling Lucky";
        if(actualResult.equals(expectedResult)){
            System.out.println("Passed");
        }else{
            System.out.println("actualResult:"+actualResult);
            System.out.println("expectedResult"+expectedResult);
        }
        Thread.sleep(3000);
        driver.close();

    }
}
