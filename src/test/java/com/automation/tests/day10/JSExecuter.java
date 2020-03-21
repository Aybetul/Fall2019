package com.automation.tests.day10;

import com.automation.utulities.BrowserUtils;
import com.automation.utulities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecuter {
 //  private WebDriver driver;  // if we cast it to JsExecuter
private RemoteWebDriver driver;
   @BeforeMethod
   public void setup(){
      // driver= DriverFactory.createDriver("chrome");  //if we cast it to JsExecuter
       WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
   }
    @AfterMethod
   public void teardown(){
       driver.quit();
   }


@Test(description = "Scrolll down ")
public void scrollTest(){
       driver.get("http://practice.cybertekschool.com/infinite_scroll");


    //   JavascriptExecutor js=(JavascriptExecutor) driver;   //if we cast it to JsExecuter

       // scroll down 250 pixel
       //x,y coordinates
    for(int i= 0; i<10; i++) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,250)");
        BrowserUtils.wait(3);
    }
   }
@Test(description = "scrolldown till evement is visible")
public void scrollToElement (){
       driver.get("http://practice.cybertekschool.com/");
               driver.manage().window().maximize();
    WebElement link = driver.findElement(By.linkText("WYSIWYG Editor"));
    driver.executeScript("arguments[0].scrollIntoView(true)",link);
}


}
