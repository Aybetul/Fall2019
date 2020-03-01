package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BasicNavigation {
    public static void main(String[] args) throws Exception {
// to start selenium script we need
        // setup webdriver(browser driver) and craete webdriver object
        WebDriverManager.chromedriver().setup();
      RemoteWebDriver driver= new ChromeDriver();
        // in selenium every thing starts with webdriver interface
     //    WebDriver dr= new SafariDriver(); Polimorohizim
        driver.get("http://google.com"); // to open web driver
        Thread.sleep(3000);
        String title = driver.getTitle();// returns the <title>
        String expectedTitle= "Google";
        driver.manage().window().maximize();// max your browser
      //  driver.manage().window().fullscreen();
        if (expectedTitle.equals(title)) {

            System.out.println("TEST PASSED!");
        }else{
            System.out.println("TEST FAILED");
        }
        System.out.println("title is ..."+title);
        Thread.sleep(3000);
        driver.navigate().to("http://amazon.com");
        if(driver.getTitle().toLowerCase().contains("amazon")){

        System.out.println("TEST PASSED!");
    }else{
        System.out.println("TEST FAILED");
    }
        driver.navigate().back();
        Thread.sleep(3000);
        verifyEquals(driver.getTitle(),("Google")); // calling method checks equality
        // move forward in the browser history
        driver.navigate().forward();
        System.out.println("title :"+driver.getTitle());
        System.out.println("URL:"+driver.getCurrentUrl() );
        driver.navigate().refresh();
        Thread.sleep(3000);
        driver.close(); // close browser
    }

    public static void verifyEquals (String  args1, String args2){
        if(args1.equals(args2)){
            System.out.println("TEST PASSED!");
        }else{
            System.out.println("TEST FAILED");
        }
    }
}
