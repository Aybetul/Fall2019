package com.automation.tests.day10;

import com.automation.utulities.BrowserUtils;
import com.automation.utulities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;


public class ActionTest {
 private  WebDriver driver;
private Actions actions;



    @BeforeMethod
   public void setup(){
       driver= DriverFactory.createDriver("chrome");
     actions= new Actions(driver);
    }

    @Test
    public void hoverOnImage(){
        driver.get("http://practice.cybertekschool.com/hovers");
        BrowserUtils.wait(3);
        WebElement img1=driver.findElement(By.xpath("(//img)[1]"));
        WebElement img2=driver.findElement(By.xpath("(//img)[2]"));
        WebElement img3=driver.findElement(By.xpath("(//img)[3]"));
        actions.moveToElement(img1).pause(1000).moveToElement(img2).pause(1000).moveToElement(img3).build().perform();
        BrowserUtils.wait(2);

        //hover over on the img1
        //Verify that "name: user1 visible
        actions.moveToElement(img1).perform();
        WebElement imgText1 = driver.findElement(By.xpath("//h5[text()='name: user1']"));
        Assert.assertTrue(imgText1.isDisplayed());

        //Verify that "name: user2 visible
        actions.moveToElement(img2).perform();
        WebElement imgText2 = driver.findElement(By.xpath("//h5[text()='name: user2']"));
        Assert.assertTrue(imgText2.isDisplayed());

        //Verify that "name: user3 visible
        actions.moveToElement(img3).perform();
        WebElement imgText3 = driver.findElement(By.xpath("//h5[text()='name: user3']"));
        Assert.assertTrue(imgText3.isDisplayed());
    }

    @Test
    public void JqueryMenuTest(){
     driver.get("http://practice.cybertekschool.com/jqueryui/menu#");
        WebElement enable =driver.findElement(By.id("ui-id-3"));
       WebElement downloads= driver.findElement(By.id("ui-id-4"));
       WebElement PDF= driver.findElement(By.id("ui-id-5"));
       actions.moveToElement(enable).pause(1000).moveToElement(downloads).pause(1000).click(PDF).build().perform();
    }

        @Test
        public void dragAndDrop(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        BrowserUtils.wait(2);
        WebElement dragable= driver.findElement(By.id("draggable"));
        WebElement bigCircle=driver.findElement(By.id("droptarget"));
        actions.dragAndDrop(dragable,bigCircle).perform();

        //Verify that you moved it
        String expected ="You did great!";
        String actual=bigCircle.getText();
        Assert.assertEquals(expected,actual);
    }
    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(3);
      //  driver.quit();
    }
}
