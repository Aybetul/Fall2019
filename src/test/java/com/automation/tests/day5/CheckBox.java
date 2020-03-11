package com.automation.tests.day5;

import com.automation.utulities.BrowserUtils;
import com.automation.utulities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBox {
    public static void main(String[] args) {
        WebDriver driver= DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");
        List<WebElement> checkBox= driver.findElements(By.tagName("input"));
        BrowserUtils.wait(2);
        for(int i=0 ; i<checkBox.size(); i++) {
            if (checkBox.get(i).isDisplayed()
                    && checkBox.get(i).isEnabled()
                    && !checkBox.get(i).isSelected()) ;
            checkBox.get(i).click();
            System.out.println("click on the box");
            BrowserUtils.wait(2);
        }

            driver.quit();
        }
}
