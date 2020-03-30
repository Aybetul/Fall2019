package com.automation.tests.day12;

import com.automation.utulities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebOrders {
   WebDriver driver;
WebDriverWait wait;

   @BeforeMethod
   public void setup(){
       driver= DriverFactory.createDriver("chrome");
       wait= new WebDriverWait(driver,10);
     driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders");
driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test", Keys.ENTER);

   }
@Test
   public void checkBoxTest() {
    driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
    List<WebElement> el = driver.findElements(By.cssSelector("input[type='checkbox"));
    for (int i = 0; i < el.size(); i++) {
        Assert.assertTrue(el.get(i).isSelected());

    }
}
    /**
     * go to web orders page
     * verify that Steve Johns zip code is 21233
     * Then update his ip code to 20002
     * Then verify that zip code is 20002
     */

    @Test
    public void ZipcodeTest(){
        String zip=  driver.findElement(By.xpath("//table//tr[4]//td[9]")).getText();
        Assert.assertEquals(zip,"21233");
        driver.findElement(By.xpath("//table//tr[4]//td[13]")).click();

        driver.findElement(By.xpath("(//input[@type='image'])[3]")).click();
        WebElement zipcode=driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));
        zipcode.clear();
        zipcode.sendKeys("20002");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='20002']")).getText(),"20002");

   }











    @AfterMethod
   public void teardown(){
       driver.quit();
   }




}
