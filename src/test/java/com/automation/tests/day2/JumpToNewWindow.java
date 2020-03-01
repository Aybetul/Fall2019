package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumpToNewWindow {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(3000);
        // every window had id, we called window handel
        /// base on the handle we switch the windows
        String windowhandle = driver.getWindowHandle(); // return id currently open
        System.out.println("Before switch" + driver.getCurrentUrl());


        //  this part will return all currently open windows
        Set<String> windowhandels = driver.getWindowHandles();
        System.out.println(windowhandels);
        for (String windowID : windowhandels) {
            if (!windowID.equals(windowhandle)) {
                driver.switchTo().window(windowID);
            }
        }
        System.out.println("After switch " + driver.getCurrentUrl());
       // driver.close();
        driver.quit();
    }

    public static void swichToWindowBaseOnTitle(String pageTitle, WebDriver driver) {
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            driver.switchTo().window(window);
            if (driver.getTitle().equals(pageTitle)) {
break;
            }
        }
    }
}