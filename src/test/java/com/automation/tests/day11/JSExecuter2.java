package com.automation.tests.day11;

import com.automation.utulities.BrowserUtils;
import com.automation.utulities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class JSExecuter2 {

  private WebDriver driver;
  @BeforeMethod
  public void setup(){
      driver= DriverFactory.createDriver("chrome");
      driver.get("http://practice.cybertekschool.com/");
      driver.manage().window().maximize();
  }
  @Test
public void verifyTitle(){
String expectedTitle="Practice";
    JavascriptExecutor js=(JavascriptExecutor) driver;

    String actualTitle=  js.executeScript("return document.title").toString(); //this javascript code
 // String actualTitle= (String) js.executeScript("return document.title");
      Assert.assertEquals(actualTitle,expectedTitle);
}
@Test
public void clickOn(){
WebElement link= driver.findElement(By.linkText("Multiple Buttons"));
//link.click();
JavascriptExecutor js= (JavascriptExecutor) driver;
js.executeScript("argument[0].click()", link);

WebElement button6= driver.findElement(By.id("disappearing_button"));
js.executeScript("argument[0].click", button6);
BrowserUtils.wait(2);

WebElement result= driver.findElement(By.id("result"));
Assert.assertEquals(result.getText(),"Now it's gone!");

}
@Test
public void clickAll(){
    JavascriptExecutor js= (JavascriptExecutor) driver;
List<WebElement> all= driver.findElements(By.tagName("a"));
    for(int i=1; i<all.size();i++){
        js.executeScript("arguments[0].click()",all.get(i),all);
       // js.executeScript("arguments[0].click()",all.get(i));
        BrowserUtils.wait(1);
        driver.navigate().back();
    }

//    WebElement a=driver.findElement(By.linkText("Multiple Windows"));
//    WebElement b= driver.findElement(By.linkText("Nested Frames"));
//    js.executeScript("arguments[1].click()", a,b);

}
@Test
public void textInputTest(){
driver.findElement(By.linkText("Form Authentication"))  .click();
BrowserUtils.wait(2);
    WebElement username = driver.findElement(By.name("username"));
    WebElement password = driver.findElement(By.name("password"));
    WebElement loginbtn = driver.findElement(By.id("wooden_spoon"));
    JavascriptExecutor js = (JavascriptExecutor) driver;
    //to get text from input box - read attribute "value"
    //to enter text - set attribute "value"
    //.setAttribute ('value','text') -enter some text
    js.executeScript("arguments[0].setAttribute('value', 'tomsmith')" , username);
    js.executeScript("arguments[0].setAttribute('value', 'SuperSecretPassword')", password);
    js.executeScript("arguments[0].click()", loginbtn);
    BrowserUtils.wait(5);
    String expected ="Welcome to the Secure Area. When you are done click logout below.";
    String subheader = js.executeScript("return document.getElementsByClassName('subheader')[0].textContent")
            .toString();
    Assert.assertEquals(subheader,expected);
}


    @Test(description = "http://practice.cybertekschool.com/, click on all the pages")
    void Test1() {
        //List<WebElement> all = driver.findElements(By.xpath("//ul/li/a[not(contains(text(), \"Home\"))]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 1; i <= 48; i++) {
            js.executeScript("document.getElementsByTagName(\"a\")[" + i + "].click()");
            driver.navigate().back();
        }
    }




@Test
public void scrollToElement(){
      WebElement link= driver.findElement(By.linkText("Cybertek School"));
      JavascriptExecutor js= (JavascriptExecutor) driver;
      js.executeScript("arguments[0].scrollIntoView(true)", link);
      Assert.assertTrue(link.isDisplayed());
}


@Test
public void scrollDown(){
      driver.navigate().to("http://practice.cybertekschool.com/infinite_scroll");
      JavascriptExecutor js= (JavascriptExecutor)driver;
    for (int i = 0; i <15 ; i++) {
        js.executeScript("window.scrollBy(0,1000)");
    }

}


@AfterMethod
public void teardown(){
    BrowserUtils.wait(2);
   driver.quit();
}




}
