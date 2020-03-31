package com.automation.tests.Homework4;

import com.automation.utulities.BrowserUtils;
import com.automation.utulities.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class AmazonTest {
WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= DriverFactory.createDriver("chrome");
        driver.get("http://amazon.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
@Test(description = "verify that options in the All departments dropdown are NOT sorted alphabetically")
public void TestCase4(){
        String actual=  driver.findElement(By.cssSelector("[class='nav-search-label']")).getText();
      Assert.assertEquals(actual,"All");

      List<WebElement> options =driver.findElements(By.xpath("//select[@aria-describedby='searchDropdownDescription']//option"));
     List<String> optionsStr=  BrowserUtils.TextFromWebElement(options);
    SortedSet<String> optionSet=new TreeSet(optionsStr);
    System.out.println(optionsStr);
    System.out.println(optionSet);
    Assert.assertFalse(optionsStr.equals(optionSet));

    }



@Test(description = "Amazon title verification")
    public void TestCase5(){
     driver.get(" https://www.amazon.com/gp/site-directory")  ;
        List<WebElement> options =driver.findElements(By.xpath("//select[@aria-describedby='searchDropdownDescription']//option"));
        List<String> optionsStr=  BrowserUtils.TextFromWebElement(options);

        List <WebElement> directory=driver.findElements(By.tagName("h2"));
        List<String> directoryStr= BrowserUtils.TextFromWebElement(directory);
        System.out.println(optionsStr.size()+ " "+directoryStr.size());
    for(String each:directoryStr){
      Assert.assertTrue( optionsStr.contains(each));
    }
    }
//1. go to https://amazon.com
// 2. search for "wooden spoon"
// 3. click search
//4. remember the name and the price of a random result
//5. click on that random result
//6. verify default quantity of items is 1
//  7. verify that the name and the price is the same as the one from step 5
//  8. verify button "Add to Cart" is visible
@Test(description = " search for \"wooden spoon\"")
public void TestCase8(){
        //search for "wooden spoon"
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon");
        // click search
     driver.findElement(By.xpath("//input[@type='submit']")).click();
     //list all of the result
     List<WebElement> woodenSpoon= driver.findElements(By.xpath("//a[@class='a-link-normal a-text-normal']"));
     System.out.println(woodenSpoon.size());
     //find price list
     List<WebElement> priceLst= driver.findElements(By.xpath("//span[@class='a-price']"));

     //Select random
     Random rand= new Random();
     int index= rand.nextInt(woodenSpoon.size());

     String randomPrice=priceLst.get(index).getText();
    String randResult=woodenSpoon.get(index).getText();
    System.out.println(randResult);
    woodenSpoon.get(index).click();

    // verify default quantity of items is 1
     WebElement qtyBtn= driver.findElement(By.xpath("(//span[@class='a-dropdown-prompt'])[1]"));
     Assert.assertEquals(qtyBtn.getText(),"1");

    // verify that the name and the price is the same as the one from step 5
    String title= driver.findElement(By.id("productTitle")).getText();
     Assert.assertEquals(title,randResult);
     //Verify prices are match
//    JavascriptExecutor js = (JavascriptExecutor)driver;
//    String a = js.executeScript("return document.getElementsByClassName(\"a-offscreen\")[" + x +"].innerText").toString();
     String price=driver.findElement(By.id("price_inside_buybox")).getText();
    String[] p= price.split(".");
    System.out.println(p.toString());
     Assert.assertEquals(randomPrice,price);

   //8. verify button "Add to Cart" is visible
    Assert.assertTrue( driver.findElement(By.id("wishListMainButton-announce")).isDisplayed());
}
    @Test(description="Testcase8")
    public void cart(){
        driver.get("https://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon");
        driver.findElement(By.xpath("//span[@id='nav-search-submit-text']/following-sibling::input")).click();
        List<WebElement> price = driver.findElements(By.xpath("//span[@class='a-price']/span[@class='a-offscreen']"));
        int x = new Random().nextInt(price.size());
        x = x==0?1:x;
        String originName = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])["+x+"]")).getText();
        String originPrice = "$" +
                driver.findElement(By.xpath("(//span[@class='a-price']/span[2]/span[2])["+x+"]")).getText() +"."+
                driver.findElement(By.xpath("(//span[@class='a-price']/span[2]/span[3])["+x+"]")).getText();
        driver.findElement(By.xpath("(//span[@class='a-price-fraction'])["+x+"]")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Qty:']/following-sibling::span")).getText(), "1");
        Assert.assertEquals(driver.findElement(By.id("productTitle")).getText(), originName);
        Assert.assertEquals(driver.findElement(By.id("price_inside_buybox")).getText(), originPrice);
        Assert.assertTrue(driver.findElement(By.id("add-to-cart-button")).isDisplayed());
    }



//   1. go to https://amazon.com
//   2. search for "wooden spoon"
//   3. click search
//4. remember name first result that has prime label
//5. select Prime checkbox on the left
//6. verify that name first result that has prime label is same as step 4
//            7. check the last checkbox under Brand on the left
//8. verify that name first result that has prime label is different
    @Test
public void TestCase9(){
        //search for "wooden spoon"
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon");
        // click search
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        //list all of the result
        List<WebElement> woodenSpoon= driver.findElements(By.xpath("//a[@class='a-link-normal a-text-normal']"));

        System.out.println(BrowserUtils.TextFromWebElement(woodenSpoon));

        String firstPrimeMember= driver.findElement(By.xpath("//i[@aria-label='Amazon Prime']/../../../../../..//h2[1]")).getText();
        System.out.println(firstPrimeMember);

       driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[1]")).click();
       String firstPrimeMember2= driver.findElement(By.xpath("//i[@aria-label='Amazon Prime']/../../../../../..//h2[1]")).getText();
        Assert.assertEquals(firstPrimeMember,firstPrimeMember2);

        driver.findElement(By.xpath("//span[text()='Folkulture']")).click();
        String firstPrimeMember3= driver.findElement(By.xpath("//i[@aria-label='Amazon Prime']/../../../../../..//h2[1]")).getText();
        Assert.assertNotEquals(firstPrimeMember,firstPrimeMember3);

}

   // go to https://amazon.com
    // 2.search for "wooden spoon"
    // 3.remember all Brand names on the left
    // 4.select Prime checkbox on the left
    // 5.verify that same Brand names are still displayed
@Test
public void TestCase10(){
    //search for "wooden spoon"
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon");
    // click search
    driver.findElement(By.xpath("//input[@type='submit']")).click();
    BrowserUtils.wait(2);
    // Find brands on ths left
    List<WebElement> lstBeforeClick= driver.findElements(By.xpath("//div[@id='brandsRefinements']//ul/li/span/a/span"));
    List<String> strBeforeClick=BrowserUtils.TextFromWebElement(lstBeforeClick);
    System.out.println(strBeforeClick);

     //clicks prime check box
    driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[1]")).click();
    BrowserUtils.wait(2);

    //Find brands on ths left
    List<WebElement> lstAfterClick= driver.findElements(By.xpath("//div[@id='brandsRefinements']//ul/li/span/a/span"));
    List<String> strAfterClick=BrowserUtils.TextFromWebElement(lstBeforeClick);
    System.out.println(strAfterClick);
    //Verify if the lists are same
    Assert.assertEquals(strBeforeClick,strAfterClick);

}
    /**
     * CHEAP SPOONS
     * 1.go to https://amazon.com
     * 2.search for "wooden spoon"
     * 3.click on Price option Under $25 on the left
     * 4.verify that all results are cheaper than $25
     */

        @Test
        public void test() {
            driver.get("https://amazon.com");
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon", Keys.ENTER);
            driver.findElement(By.linkText("Under $25")).click();
            //we collect only dollar values from the price of every item
            List<WebElement> prices = driver.findElements(By.className("a-price-whole"));
            //we convert collection of web elements into collection of strings
            List<String> pricesText = BrowserUtils.TextFromWebElement(prices);
            System.out.println(pricesText);
            for (String price : pricesText) {
                //we convert every price as a string into integer
                int priceConverted = Integer.parseInt(price);
                //checking if the price of every item is under 25
                Assert.assertTrue(priceConverted < 25);
            }

        }





    @AfterMethod
    public void teardown (){
        driver.quit();
    }




}
