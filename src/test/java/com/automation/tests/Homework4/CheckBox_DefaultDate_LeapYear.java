package com.automation.tests.Homework4;

import com.automation.utulities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CheckBox_DefaultDate_LeapYear {
    private WebDriver driver;
    //TestCase 2
  By yearBy= By.id("year");
  By monthBy=By.id("month");
  By dayBy= By.id("day");



  // 1 .go tohttp://practice.cybertekschool.com/dropdown
    // 2.select a random year under Select your date of birth
    // 3.select month January
    // 4.verify that days dropdown has current number of days
    // 5.repeat steps 3, 4 for all the months

    @Test(description =" Verify if LeapYear ")
    public void TestCase3() {
    driver.get("http://practice.cybertekschool.com/dropdown");
    // List<WebElement> years=driver.findElements(By.xpath("//select[@id='year']//option"));
    // System.out.println(years.size());
    // select random year
    for (int i = 0; i <12; i++) {
        Random rand = new Random();
        int yearIndex = rand.nextInt(100);
        Select yearSelect = new Select(driver.findElement(yearBy));
        yearSelect.selectByIndex(yearIndex);

        Select monthSelect = new Select(driver.findElement(monthBy));
        monthSelect.selectByIndex(i);
        // System.out.println(monthSelect.getFirstSelectedOption().getText());
       // Select daySelect = new Select(driver.findElement(dayBy));
        List<WebElement> days=driver.findElements(By.xpath("//select[@id='day']//option"));

       //   System.out.println(days.size());
        if(monthSelect.getFirstSelectedOption().getText().equals("February")&&days.size()==29){
          //  System.out.println("LEAP YEAR!!!!");
            Assert.assertTrue(true);
        }


   }

}







        @BeforeMethod
         public void setup(){
        driver= DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

      }
       @Test
       public void testCase1(){
       driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox ");
       List<WebElement > checkBox= driver.findElements(By.tagName("label"));
        int count =0;
        for (int i = 0; i <20 ; i++) {
           Random rand = new Random();
           int randomBox= rand.nextInt(5);
           WebElement current= checkBox.get(randomBox);
           current.click();
            System.out.println(current.getText());
           if(current.getText().equals("Friday")){
               count++;
               if(count==3)
                   break;
           }
           current.click();

        }
    }
    @Test(description = "Verify  Default Date")
     public void testCase2(){
        driver.get("http://practice.cybertekschool.com/dropdown");
    Select year= new Select(driver.findElement(yearBy));
    String currentYear= year.getFirstSelectedOption().getText();

    Select mount= new Select(driver.findElement(monthBy));
    String currentMonth= mount.getFirstSelectedOption().getText();

    Select day= new Select(driver.findElement(dayBy));
    String currentDay= day.getFirstSelectedOption().getText();

    LocalDate ld=LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MMMM-dd");
    String actual= currentYear+"-"+currentMonth+"-"+currentDay;


    Assert.assertEquals(actual,formatter.format(ld));

}

    @AfterMethod
   public void teardown (){
        driver.quit();
    }


}
