package com.automation.tests.day5;

import com.automation.utulities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RadioButton {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver= new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        BrowserUtils.wait(3);
        driver.manage().window().maximize();
        //<input type="radio">
        List<WebElement> buttons=driver.findElements(By.tagName("input"));
        for(WebElement each: buttons) {
            // this method will return if button already selected
          boolean isSelected=  each.isSelected();
            System.out.println(each.getAttribute("id")+"is selected "+ isSelected);
            if (each.isEnabled()) {
                each.click();
                System.out.println("clicked on :"+each.getAttribute("id"));
                BrowserUtils.wait(2);
            }else{
                System.out.println("Button is disabled: "+each.getAttribute("id"));
            }
        //    driver.quit();  .NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?
        }
        driver.quit();
    }
}
