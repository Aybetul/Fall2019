package com.automation.tests.SelfPractice;
import com.automation.utulities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestData {
    WebDriver  driver;


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
driver.manage().window().maximize();
driver.get("http://practice.cybertekschool.com/tables");
    }
    @Test
    public void printAllFullNames() {
        List<String> list= new ArrayList<>();
        for (int i = 1; i <=4; i++) {
            String xpathF = "//table[1]//tbody//tr["+i+"]//td[2]";
            BrowserUtils.wait(2);
            String name=driver.findElement(By.xpath(xpathF)).getText();
            String xpathL = "//table[1]//tbody//tr["+i+"]//td[1]";
            String lastName=  driver.findElement(By.xpath(xpathL)).getText();
            String names= name+" "+lastName;
         BrowserUtils.wait(2);
           list.add(names);
        }
        System.out.println(list);
    }
@Test
    public void deleteHotmail(){
       List<WebElement> emailList= driver.findElements(By.xpath("//table[1]//tbody//tr//td[3]"));

       int i=1;
        for (WebElement each : emailList) {
            BrowserUtils.wait(2);
            if(each.getText().contains("hotmail")){
                String xpath="//table[1]//tbody//tr["+i+"]//a[2]";
       driver.findElement(By.xpath(xpath)).click();

            }
              i++;

        }




    }





}
