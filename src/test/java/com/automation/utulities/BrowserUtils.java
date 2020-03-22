package com.automation.utulities;

import org.openqa.selenium.WebElement;

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
     textValues.add(each.getText()) ;
  }
  return textValues;
}

}
