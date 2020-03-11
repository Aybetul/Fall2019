package com.automation.tests.day3;

import com.automation.utulities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsPractice {
    public static void main(String[] args) throws Exception {

//        WebDriverManager.chromedriver().setup();
//        WebDriver driver =new ChromeDriver();
        // we create  a method to create DRIVER
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");
        Thread.sleep(3000);
        WebElement fullName=driver.findElement(By.name("full_name"));
        fullName.sendKeys("Mister Twister");
        Thread.sleep(3000);
        WebElement email= driver.findElement((By.name("email")));
        email.sendKeys("aybetul@hotmail.com");
        Thread.sleep(3000);
       WebElement signUp= driver.findElement(By.name("wooden_spoon"));
       // when you see type= "submit" we can use submit() instead o click()
       signUp.click();
        Thread.sleep(3000);
        String expected ="Thank you for signing up. Click the button below to return to the home page.";
       WebElement message = driver.findElement((By.className("subheader"))) ;

       String actual= message.getText();
        if(expected.equals(actual)){
            System.out.println("Passed");
        }else{
            System.out.println("Test Failed");
        }


        driver.quit();

    }
}
