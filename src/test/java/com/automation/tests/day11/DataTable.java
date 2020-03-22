package com.automation.tests.day11;

import com.automation.utulities.BrowserUtils;
import com.automation.utulities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class DataTable {
    WebDriver driver;

@BeforeMethod
   public void DataTable(){
    WebDriverManager.chromedriver().version("79").setup();
    ChromeOptions chromeOptions= new ChromeOptions();
    chromeOptions.setHeadless(false);  //  to turn browser without GUI. Mekes browser invisible so it is faster
       driver= new ChromeDriver(chromeOptions);
       driver.get("http://practice.cybertekschool.com/tables");
       driver.manage().window().maximize();


   }
@Test
public void Email(){
    WebElement email= driver.findElement(By.xpath("//table[@id='table1']//tbody//tr[1]//td[3]"));
    String actual= email.getText();
    Assert.assertEquals(actual,"jsmith@gmail.com");
}
@Test
public void getColumnNames(){
    List<WebElement> columnNames=driver.findElements(By.xpath("//table[1]//th"));
    for (WebElement each : columnNames) {
        System.out.println(each.getText()); // this part only for  printing


        List<String> expected = Arrays.asList("Last Name", "First Name", "Email", "Due", "Web Site", "Action");
         Assert.assertEquals(BrowserUtils.TextFromWebElement(columnNames),expected);  // we use the method that we created
    }
}
    @Test(description = "Fatih's code to find headers ")
    public void tryTable() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/tables");
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//thead//tr//th"));
        List<String> result = headers.stream().map(x -> x.getText()).collect(Collectors.toList());
        System.out.println(result);
    }
@Test
public void verifyRowsCount(){
 List<WebElement> rows=    driver.findElements(By.xpath("//table[1]//tbody//tr"));
  //  System.out.println(rows);
    Assert.assertEquals(rows.size(),4);
}

@Test
public void getSpecificColumn(){
    // Coulmn with links
    List<WebElement> links= driver.findElements(By.xpath("//table[1]//tbody//tr//rtd[5]"));
    System.out.println(BrowserUtils.TextFromWebElement(links));

}
    /**
     * Go to tables example page
     * Delete record with jsmith@gmail.com email
     * verify that number of rows is equals to 3
     * verify that jsmith@gmail.com doesn't exists any more in the table
     */
    @Test
    public void deleteRowTest() {
        String xpath = "//table[1]//td[text()='jsmith@gmail.com']/..//a[text()='delete']";
        driver.findElement(By.xpath(xpath)).click();
        BrowserUtils.wait(3);
        //get count of rows
        int rowCount = driver.findElements(By.xpath("//table[1]//tbody//tr")).size();
        Assert.assertEquals(rowCount, 3);
        Assert.assertTrue(driver.findElements(By.xpath("//table[1]//td[text()='jsmith@gmail.com']")).isEmpty());

    }
    @Test(description = "returns  column  index according to column name" )
public void getColumnIndexByName(){
   String columnName="Email";
   List<WebElement> columnNames= driver.findElements(By.xpath("//table[2]//th"));
   int index=0;
        for (int i = 0; i <columnNames.size() ; i++) {
            String actualColumnName = columnNames.get(i).getText();
            System.out.println(String.format("Column name: %s, position %s", actualColumnName, i));

            if(columnNames.get(i).getText().equals(columnName)) ;
           index=1+i;
           break;
        }
     Assert.assertEquals(index,3);
    }

    @Test(description = "find elemet according to row and column number")
public void getSpecificCell(){
 int row=3;
 int column=5;
 String expected="http://www.jdoe.com";

 String xpath="//table[1]//tbody//tr["+row+"]//td["+column+"]";
 WebElement cell= driver.findElement(By.xpath(xpath));

 Assert.assertEquals(cell.getText(),expected);
}




 @AfterMethod
public void teardown(){
    driver.quit();
    }
}
