package com.automation.tests.day5;

import com.automation.utulities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.compress.compressors.brotli.BrotliUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploading {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/upload");
     BrowserUtils.wait(2);
        WebElement upload= driver.findElement(By.id("file-upload")) ;
String filePath= System.getProperty("user.dir")+"/pom.xml";
       // String filePath2= System.getProperty("user.dir")+"";
        System.out.println(filePath);
upload.sendKeys(filePath);
driver.findElement(By.id("file-submit")).click();
driver.quit();

    }
}
