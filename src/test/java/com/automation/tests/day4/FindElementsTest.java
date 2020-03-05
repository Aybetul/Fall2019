package com.automation.tests.day4;

import com.automation.utulities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FindElementsTest {
    public static void main(String[] args) throws  Exception {
     WebDriver driver=  DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        Thread.sleep(3000);
       // This is how to collect from the page
List<WebElement> links =driver.findElements(By.tagName("a"));
        for(WebElement each:links) {
            System.out.println(each.getText());
            System.out.println(each.getAttribute("href"));
            System.out.println(links.size());
        }

        links.remove(0);
        for(int i=0; i<links.size();i++){
            links.get(i).click();
        //   Thread.sleep(2000);
           driver.navigate().back(); // go back to page
            links=     driver.findElements(By.tagName("a"));
  //  driver.navigate().refresh();
}




        driver.quit();
    }
}
