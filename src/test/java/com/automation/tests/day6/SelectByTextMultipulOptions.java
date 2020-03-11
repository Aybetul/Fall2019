package com.automation.tests.day6;

import com.automation.utulities.BrowserUtils;
import com.automation.utulities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByTextMultipulOptions {
    public static void main(String[] args) {
      WebDriver driver= DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);
        Select languagesSelect= new Select(driver.findElement(By.name("Languages")));
       boolean isMultiple=  languagesSelect.isMultiple();
        System.out.println("isMultiple = " + isMultiple);

        //Select multiple options
           languagesSelect.selectByVisibleText("Java");
        languagesSelect.selectByVisibleText("Python");
        languagesSelect.selectByVisibleText("JavaScript");

        // Test verification
        String expected="JavaJavaScriptPython";
        String actual="";
        List<WebElement> selectedLanguages=languagesSelect.getAllSelectedOptions();
        for(WebElement each:selectedLanguages){
        actual+= each.getText();
        }
        System.out.println(expected.equals(actual)?"Passed":"Failed");

        // deselect the options
        languagesSelect.deselectByVisibleText("Java");
        languagesSelect.deselectAll();




    }
}
