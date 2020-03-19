package com.automation.tests.SelfPractice;

import com.automation.utulities.BrowserUtils;
import com.automation.utulities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class OfficeHours {
    private WebDriver driver;
    private String url="https://qa3.vytrack.com/user/login";
    private String username = "storemanager85";   //   valid username
    private String password = "UserUser123";      //   valid password
    private By usernameBy=By.id("prependedInput");
    private By passwordBy=By.id("prependedInput2");
    private By clickLogin=By.id("_submit");
    @BeforeMethod
    protected void setup(){
        driver= DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    protected void login(){
        driver.get(url);
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(clickLogin).submit();
    }
    @Test
    protected void createContact(){
        login();
        WebElement contactLink=driver.findElement(By.xpath("//span[.='Contacts']/following-sibling::a"));
        contactLink.click();
        BrowserUtils.wait(5);
        WebElement creatingContact=driver.findElement(By.linkText("Create Contact"));
        creatingContact.click();
        String currentTitle=driver.getTitle();
        Assert.assertEquals(currentTitle,"Create Contact - Contacts - Customers");
        HashMap<String,String> contact1= new HashMap<>();
        contact1.put("First Name","John");
        contact1.put("Last Name","Smith");
        contact1.put("Phone", "901-616-13-99");
        contact1.put("Street", "400 Main Street");
        contact1.put("City", "Tyson");
        contact1.put("State", "VA");
        contact1.put("Zip Code", "22102");
       contact1.put("Country", "United States");
        contact1.put("Sales Group", "true");

        WebElement first_name = driver.findElement(By.xpath("(//input[@data-name = 'field__first-name'])[1]"));
        WebElement last_name = driver.findElement(By.xpath("(//input[@data-name = 'field__last-name'])[1]"));
        WebElement phone = driver.findElement(By.name("oro_contact_form[phones][0][phone]"));
        WebElement street = driver.findElement(By.name("oro_contact_form[addresses][0][street]"));









    }
}
