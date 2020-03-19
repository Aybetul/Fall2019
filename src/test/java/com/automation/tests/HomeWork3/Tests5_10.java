package com.automation.tests.HomeWork3;

import com.automation.utulities.BrowserUtils;
import com.automation.utulities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



    public class Tests5_10 {
    private WebDriver driver;
    private By emailBy= By.id("email");
    private By pageBy= By.linkText("Sign Up For Mailing List");
    private By fullnameBy=By.cssSelector("[name='full_name']");
    private By emailBy2= By.cssSelector("[type='email']");
     private By summitBy= By.name("wooden_spoon");
    private By messBy=By.name("signup_message");
    private By emailMessBy=By.xpath("//*[@id='schranka']/tr[1]/td[1]");
    private By emailFromBy= By.id("odesilatel");
    private By messFromBy= By.id("predmet");

//test case 7
    private By uploadBy= By.linkText("File Upload");
    private By uploadBtnBy=By.id("file-submit");
    private By uploadBoxBy=By.id("file-upload");

    //TesCase 8
    private By autoBy=By.linkText("Autocomplete");
    private By autoBoxBy=By.id("myCountry");
     private By resultBy= By.id("result");

    // Test Case 9
    private By StatusBy= By.linkText("Status Codes");


   @Test(description = "Message Verification", dataProvider ="testData" )
    public void TestCase9_12(String clickOn, String expected){
    driver.findElement(StatusBy).click();
        driver.findElement(By.linkText(clickOn)).click();
        String actual =   driver.findElement(By.tagName("p")).getText();
         Assert.assertTrue(actual.contains(expected));
    }
   @DataProvider(name = "testData")
    public Object[][] testData(){
        return new Object[][]{{"200", "This page returned a 200 status code"},
                              {"301","This page returned a 301 status code"},
                              {"404","This page returned a 404 status code"},
                              {"500","This page returned a 500 status code"}
        };
    }





    @Test(description = "Verify that following message is displayed: You selected: United States of America”")
      public void TestCase8(){
        driver.findElement(autoBy).click();
        driver.findElement(autoBoxBy).sendKeys("United States of America");
        driver.findElement(By.cssSelector("[value='Submit']")).click();
        BrowserUtils.wait(3);
       String  actualText = driver.findElement(resultBy).getText();
        String expectedText="You selected: United States of America";

       BrowserUtils.wait(3);
       Assert.assertEquals(actualText,expectedText);
}




   @Test(description = "upload the file")
   public void TestCase7(){
    driver.findElement(uploadBy).click();
    String filePath= System.getProperty("user.dir")+"/pom.xml";
    driver.findElement(uploadBoxBy).sendKeys(filePath);
    driver.findElement(uploadBtnBy).click();
}




    @Test(description = "Sign up for Mailing List")
    public void TestCase6(){
    driver.get("https://www.tempmailaddress.com/");
    String email= driver.findElement(emailBy).getText();
     System.out.println(email);
     driver.navigate().back();
     driver.findElement(pageBy).click();
     driver.findElement(fullnameBy).sendKeys("Nyra Smith");
     BrowserUtils.wait(3);
     driver.findElement(emailBy2).sendKeys(email);
     driver.findElement(summitBy).click();
     String expectedMess="Thank you for signing up. Click the button below to return to the home page.";
     String actualMess=driver.findElement(messBy).getText();
     Assert.assertEquals(expectedMess,actualMess);
     driver.get("https://www.tempmailaddress.com/");
     BrowserUtils.wait(5);

     // Verify that you’ve received an email from
     WebElement verifyEmail=driver.findElement(emailMessBy);
     Assert.assertTrue(verifyEmail.isDisplayed());
     BrowserUtils.wait(5);

    // Click on that email to open it.
     driver.findElement(By.xpath("//tr[@class='hidden-xs hidden-sm klikaciRadek newMail']")).click();

     // Verify that email is from: “do-not-reply@practice.cybertekschool.com”
     String actualEmailAddress=driver.findElement(emailFromBy).getText();
     String expectedEmailAddress="do-not-reply@practice.cybertekschool.com";
      Assert.assertEquals(actualEmailAddress,expectedEmailAddress);

    // Verify that subject is: “Thanks for subscribing to practice.cybertekschool.com!”
     String actualSubject=driver.findElement(messFromBy).getText();
     String expectedSubject="Thanks for subscribing to practice.cybertekschool.com!";
     Assert.assertEquals(actualSubject,expectedSubject);
 }

    @BeforeMethod
    public void setup(){
        driver= DriverFactory.createDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.manage().window().maximize();
    }



   @AfterMethod
  public void teardown() {
    driver.quit();
  }
}
