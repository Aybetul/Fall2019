package com.automation.tests.Homework4;

import com.automation.utulities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCase6_7 {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    //1. go to https://www.w3schools.com/
    // 2. find all the elements in the page with the tag a
    //3. for each of those elements, if it is displayed on the page, print the text and the href of that
     //    element.
    @Test
    public void TeatCase6() {
        driver.get(" https://www.w3schools.com/");
        List<WebElement> lst = driver.findElements(By.tagName("a"));
        for (WebElement each : lst) {
            if (each.isDisplayed()) {
                System.out.println(each.getText());
                System.out.println(each.getAttribute("href"));
            }
        }
    }
     //   1.  go to https://www.selenium.dev/documentation/en/
     //   2. find all the elements in the page with the tag a
    //    3. verify that all the links are valid
    @Test
    public void TestCase7(){
      driver.get("https://www.selenium.dev/documentation/en/");
      List<WebElement> lst= driver.findElements(By.tagName("a"));
      lst.forEach(e-> System.out.println(e.getAttribute("href")));
      for(WebElement each:lst)
        Assert.assertFalse( each.getAttribute("href").isEmpty());
    }

    @Test(description = "TestCase7")
    public void valid_links(){
        driver.get("https://www.selenium.dev/documentation/en/");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for(int i=0; i<links.size(); i++){
            String href = links.get(i).getAttribute("href");
            try {
                URL url = new URL(href);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setConnectTimeout(3000);
                httpURLConnection.connect();
                Assert.assertEquals(httpURLConnection.getResponseCode(), 200);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @AfterMethod
    public void teardown (){
        driver.quit();
    }

}
