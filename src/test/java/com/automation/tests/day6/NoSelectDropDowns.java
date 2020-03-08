package com.automation.tests.day6;

import com.automation.utulities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class NoSelectDropDowns {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver= new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);
        driver.findElement(By.id("dropdownMenuLink")).click();
        BrowserUtils.wait(2);

        driver.findElement(By.linkText("Amazon")).click();


List<WebElement> links = driver.findElements(By.className("dropdown-item"));
for(WebElement eachLink: links){
    System.out.println("eachLink.getText() = " + eachLink.getText()+eachLink.getAttribute("href"));
    BrowserUtils.wait(2);
}

        BrowserUtils.wait(2);
        driver.quit();
    }
}
