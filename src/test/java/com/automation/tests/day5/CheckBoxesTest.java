package com.automation.tests.day5;

import com.automation.utulities.BrowserUtils;
import com.automation.utulities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxesTest {
    public static void main(String[] args) {
      checkBox();


    }
    // verify that your first box is not selected and second is selected
    public static  void checkBox(){
        WebDriver driver= DriverFactory.createDriver("chrome");
      driver.get("http://practice.cybertekschool.com/checkboxes");
        List<WebElement> checkBox= driver.findElements(By.tagName("input"));
        BrowserUtils.wait(2);
        System.out.println(!checkBox.get(0).isSelected() &&checkBox.get(1).isSelected()? " Passed ": "failed ");

        // we will click the first box and verify it
        WebElement box1=checkBox.get(0);
        box1.click();
        BrowserUtils.wait(2);
        if (box1.isSelected()) {
            System.out.println("passed and  box # 1 is selected");
        }else{
            System.out.println("passed and box # 1 is not  selected");
        }
        driver.quit();
    }

    }





