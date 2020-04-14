package com.automation.tests.SelfPractice;

import com.automation.utulities.Driver;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OfficeExcelPractice {
    WebDriver driver;
    Workbook workbook;
    Sheet  workSheet;
    FileInputStream   fileInputStream;
    FileOutputStream fileOutputStream;


    @BeforeMethod
    public void setUp() throws IOException {
        driver= Driver.getDriver();
        fileInputStream = new FileInputStream("Countries.xlsx"); // path to excel file
        workbook = WorkbookFactory.create(fileInputStream);
        workSheet = workbook.getSheet("Countries");
    }
    @Test
    public void test(){
        int count =workSheet.getPhysicalNumberOfRows();
        System.out.println("count "+ count);
        for (int i = 1; i <count ; i++) {
            Row currentRow = workSheet.getRow(i);
            String execute = currentRow.getCell(0).toString();
            System.out.println("execute = " + execute);
            if(  execute.equals("y") ){
                //execute the test
                String country = currentRow.getCell(1).toString();
                String capital = currentRow.getCell(2).toString();
                driver.get("https://wikipedia.org");
                driver.findElement(By.id("searchInput")).sendKeys(country+ Keys.ENTER);
                String actual = driver.findElement(By.xpath("//th[starts-with(text(),'Capital')]/following-sibling::td/a")).getText();
            }else{
                continue;
            }
        }
    }
    /*
    //th[starts-with(text(),'Capital')]   give me a th element that starts text with Capital
    //th[starts-with(text(),'Capital')]/..//td   find the th element that starts with text Capital
                                                 then go back to parent
                                                 then come to child td
    //th[starts-with(text(),'Capital')]/following-sibling::td/a   find the th element that starts with text Capital
                                                                 then find following sibling td / a
     */
    @AfterMethod
    public void tearDown(){
    }


}
