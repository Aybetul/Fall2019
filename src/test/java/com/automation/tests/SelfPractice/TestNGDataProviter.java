package com.automation.tests.SelfPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.http.impl.io.IdentityInputStream;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDataProviter {


@Test(description = "Verify page title", dataProvider = "testData")
    public void setup(String URL, String title){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get(URL);
        Assert.assertTrue(driver.getTitle().contains(title));
        driver.quit();

    }
    @DataProvider(name="testData")
    public Object[][] testData(){
       return new Object[][]{{"http://google.com", "Google"},
                               {"http://amazon.com", "Amazon"},
                                   {"http://etsy.com", "Etsy"}};
    }



}
