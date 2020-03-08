package com.automation.tests.day6;

import com.automation.utulities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByText {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver= new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement simpleDropdown = driver.findElement(By.id("dropdown"));
        Select selectSimpleDropDown =new Select(simpleDropdown);

        selectSimpleDropDown.selectByVisibleText("Option 1");
        BrowserUtils.wait(2);
       selectSimpleDropDown.selectByVisibleText("Option 2");
       BrowserUtils.wait(2);

       //select Date of Birth
      Select selectByYear= new Select(driver.findElement(By.id("year"))) ;
        Select selectByMonth= new Select(driver.findElement(By.id("month"))) ;
        Select selectByDay= new Select(driver.findElement(By.id("day"))) ;
         selectByYear.selectByVisibleText("1984");
        selectByMonth.selectByVisibleText("March");
         selectByDay.selectByVisibleText("24");

         //Select all months
     //   .getOption() turns all options from drop down
        List<WebElement> months= selectByMonth.getOptions();
        for(WebElement each:months){
            selectByMonth.selectByVisibleText(each.getText()); // we found the each month name is and select it
            BrowserUtils.wait(1);
        }

        //  select one state
Select stateSelect= new Select(driver.findElement(By.id("state")));
        stateSelect.selectByVisibleText("California");
       List<WebElement> states = stateSelect.getOptions();


       String selected= stateSelect.getFirstSelectedOption().getText(); // returns what is currently selected
        System.out.println(selected.equals("California")?"Passed": "Failed");

        //  select all state and print it
        for(WebElement  eachState : states){
            stateSelect.selectByVisibleText(eachState.getText());
            BrowserUtils.wait(1);
            System.out.println(eachState.getText());
        }

        BrowserUtils.wait(2);

    driver.quit();

    }
}
