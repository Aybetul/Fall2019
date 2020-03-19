package com.automation.tests.HomeWork3;

import com.automation.utulities.BrowserUtils;
import com.automation.utulities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Tests1_5 {
   WebDriver driver;
    private By firstNameBy = By.name("firstname");
    private By lastNameBy = By.name("lastname");
    private By usernameBy = By.name("username");
    private By emailBy = By.name("email");
    private By passwordBy = By.name("password");
    private By phoneBy = By.name("phone");
    private By femaleBy = By.cssSelector("input[value='female']");
    private By dateOfBirthBy = By.name("birthday");
    private By departmentBy = By.name("department");
    private By jobTitleBy = By.name("job_title");
    private By javaBy = By.xpath("//label[text()='Java']/preceding-sibling::input");
    private By signUpBy = By.id("wooden_spoon");

    @Test(description = "Verify registration form completed message displayed")
    public void TestCase5(){
        driver.findElement(firstNameBy).sendKeys("Camila");
        driver.findElement(lastNameBy).sendKeys("Bradford");
        driver.findElement(usernameBy).sendKeys("cbradford");
        driver.findElement(emailBy).sendKeys("bradford@gmail.com");
        driver.findElement(passwordBy).sendKeys("acbbca123");
        driver.findElement(phoneBy).sendKeys("901-616-2312");

        driver.findElement(femaleBy).click();
        driver.findElement(dateOfBirthBy).sendKeys("10/12/2000");

        Select departmentSelect = new Select(driver.findElement(departmentBy));
        departmentSelect.selectByVisibleText("Department of Engineering");

        Select jobTitleSelect = new Select(driver.findElement(jobTitleBy));
        jobTitleSelect.selectByVisibleText("SDET");

        driver.findElement(javaBy).click();
        driver.findElement(signUpBy).click();

        BrowserUtils.wait(5);

        String expected = "You've successfully completed registration!";
        String actual = driver.findElement(By.tagName("p")).getText();

        Assert.assertEquals(actual, expected);
    }

    @BeforeMethod
    public void SetUp(){
       driver= DriverFactory.createDriver("chrome");
        BrowserUtils.wait(3);
        driver.get("http://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Registration Form")).click();

    }
    @Test(description = "Verify error message is displayed")
    public void TestCase1(){
        driver.findElement(By.name("birthday")).sendKeys("13/01/2010", Keys.ENTER);
        String actual =driver.findElement(By.xpath("//small[@style=\"display: block;\"]")).getText();
        System.out.println(actual);
        String expected="The date of birth is not valid";
        Assert.assertEquals(actual,expected);

    }
    @Test(description ="Verify each language box is displayed")
     public void TestCase2(){
      List<WebElement> lst=driver.findElements(By.className("[class='form-check form-check-inline']"));
      for(WebElement each:lst){
       Assert.assertTrue(each.isDisplayed());
}
}
    @Test(description ="Verify warning message is displayed for first name ")
    public void TestCase3(){
     driver.findElement(By.name("firstname")).sendKeys("m",Keys.ENTER);
     String expected= "first name must be more than 2 and less than 64 characters long";
     String actual =driver.findElement(By.xpath("//small[@data-bv-validator='stringLength'and @data-bv-for='firstname']")).getText();
     Assert.assertEquals(actual,expected);
}
       @Test(description = "Verify warning message is displayed for last name")
       public void TestCase4(){
        driver.findElement(By.name("lastname")).sendKeys("M",Keys.ENTER);
        String expected= "“The last name must be more than 2 and less than 64 characters long”";
        String actual=driver.findElement(By.xpath("//small[@data-bv-validator='stringLength'and @data-bv-for='lastname']")).getText();
        Assert.assertEquals(expected,actual);
}




    @AfterMethod
    public void TearDown(){
        driver.quit();
    }
}
