package com.automation.utulities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {

   public static void wait(int seconds){
       try{
           Thread.sleep(1000*seconds);
       }catch (InterruptedException e){
           e.printStackTrace();
       }
   }
public static  List<String> TextFromWebElement(List<WebElement> elements){
  List <String> textValues= new ArrayList<>();
  for(WebElement each: elements){
      if(!each.getText().isEmpty())
     textValues.add(each.getText()) ;
  }
  return textValues;
}
    /**
     * waits for backgrounds processes on the browser to complete
     *
     * @param timeOutInSeconds
     */
    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOutInSeconds);
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }
    /**
     * Clicks on an element using JavaScript
     *
     * @param element
     */
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    /**
     * Scroll to element using JavaScript
     *
     * @param element
     */
    public static void scrollTo(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     *
     * @param name screen shot name
     * @return path to the screenshot
     */
    public static String getScreenShot(String name){
        String path =System.getProperty("user.dir")+"/test-output/screenshots/"+name+".png";
// since out reference type is a WebDriver
        // we cannot see methods from TakesScreenShot interface
        // that'' why we do casting
        TakesScreenshot takesScreenShot=(TakesScreenshot)Driver.getDriver();
        File source=takesScreenShot.getScreenshotAs(OutputType.FILE);// screen shot itself
        File destination= new File((path)); // where screen shots will be saved
        try {
            FileUtils.copyFile(source, destination); // copy screen shot to the previously place
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  path;
}


}
