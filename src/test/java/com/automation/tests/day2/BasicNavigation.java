package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BasicNavigation {
    public static void main(String[] args) {
// to start selenium script we need
        // setup webdriver(browser driver) and craete webdriver object
        WebDriverManager.chromedriver().setup();
      RemoteWebDriver driver= new ChromeDriver();
        // in selenium every thing starts with webdriver interface
     //    WebDriver dr= new SafariDriver(); Polimorohizim
        driver.get("http://google.com"); // to open web driver

    }
}
