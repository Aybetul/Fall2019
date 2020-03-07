package com.automation.tests.day5;

import com.automation.utulities.BrowserUtils;
import com.automation.utulities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonTest {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        BrowserUtils.wait(2);
        WebElement blackButton = driver.findElement(By.id("black"));
        if (blackButton.isDisplayed() && blackButton.isEnabled()) {  //isDisplayed() checks if the element is visible
            blackButton.click();
        System.out.println("clicked on the black button");
    }else {
            System.out.println("failed to click on the black button");

        }
        BrowserUtils.wait(2);
        if(blackButton.isSelected()){
            System.out.println("black button already is clicked ");
        }else{
            System.out.println("black button is not  clicked ");
        }
        driver.quit();
    }
}
