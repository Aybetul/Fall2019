package com.automation.tests.day3;

import com.automation.utulities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindElementById {
    public static void main(String[] args) throws  Exception{
      WebDriver driver=  DriverFactory.createADriver("chrome");
      driver.get("http://practice.cybertekschool.com/login");
      // log way
//        WebElement login= driver.findElement(By.name("username"));
//        login.sendKeys("tomsmith");
// short way
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        Thread.sleep(3000);

        WebElement password= driver.findElement((By.name("password")));
        password.sendKeys("SuperSecretPassword");
        Thread.sleep(3000);
       driver.findElement(By.id("wooden_spoon")).click();
        Thread.sleep(3000);
        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement((By.tagName("h4"))).getText();
//        if(expected.equals(actual)){
//            System.out.println("Test passed");
//        }else{
//            System.out.println("Test failed");
//        }
        System.out.println(expected.equals(actual)?"passed":"failed");

        // let's click on the logiut button. it looks like button but it is hyper link
        //if you have couple space in the text we can use partialLinkText
        WebElement logout = driver.findElement(By.linkText("Logout"));
        String href= logout.getAttribute("href");
        String className= logout.getAttribute("class");
        System.out.println(href);
        System.out.println(className);
        Thread.sleep(3000);
        logout.click();
        // let's enter invalid credentials
        driver.findElement(By.name("username")).sendKeys("wrong");
        driver.findElement(By.name("password")).sendKeys("wrong");
        driver.findElement(By.id("wooden_spoon")).click();
        Thread.sleep(3000);

        WebElement errorMessage =driver.findElement(By.id("flash-messages"));
        System.out.println(errorMessage.getText());
        Thread.sleep(3000);







        driver.quit();
    }

}
