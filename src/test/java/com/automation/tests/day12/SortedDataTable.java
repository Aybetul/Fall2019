package com.automation.tests.day12;

import com.automation.utulities.BrowserUtils;
import com.automation.utulities.DriverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SortedDataTable {
WebDriver driver;

    /**
     * Go to http://practice.cybertekschool.com/tables
     * Click on "Last name" column name
     * Verify that table is sorted by last name in alphabetic order.
     *
     * The Java String compareTo() method is used for comparing two strings lexicographically.
     * Each character of both the strings is converted into a Unicode value for comparison.
     * If both the strings are equal then this method returns 0 else it returns positive or negative value.
     * The result is positive if the first string is lexicographically greater than
     * the second string else the result would be negative.
     *
     *  This method is coming from Comparable interface.
     *  If you want ot be able to sort collection of some class
     *  you need to implement this interface
     *  and override compareTo method
     *
     "a".compareTo("b") = -1
     61 - 62 = -1
     a is before b
     "a".compareTo("a")
     61 - 61 = 0
     0 means 2 strings are equals
     *
     */
    @Test
    public void test() {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        //click on column name
        driver.findElement(By.xpath("//table[1]//*[text()='Last Name']")).click();
        BrowserUtils.wait(2);
        //collect all values from the first column
        List<WebElement> column = driver.findElements(By.xpath("//table[1]//tbody//td[1]"));
        for (int i = 0; i < column.size() - 1; i++) {
            //take a string
            String value = column.get(i).getText();
            //take a following string
            String nextValue = column.get(i + 1).getText();

            System.out.println(value.compareTo(nextValue));

            //if difference is negative - order value is before nextValue in alphabetic order
            //if difference is positive - order value is after nextValue in alphabetic order
            //if difference is 0 - value and nextValue are equals
            Assert.assertTrue(value.compareTo(nextValue) <= 0);
        }
        driver.quit();
    }




    @Test
    public void lastName(){
        List<WebElement> lst=driver.findElements(By.xpath("//table[1]//tr//td[1]"));

        List<String> list2= BrowserUtils.TextFromWebElement(lst);
        List<String> listCopy=list2;
        Collections.sort(listCopy);
        driver.findElement(By.xpath("//table[1]//span[text()='Last Name']")).click();
        Assert.assertEquals(list2,listCopy);
    }

    @Test(testName = "Verify the LastNames are sorted after click",description = "http://practice.cybertekschool.com/tables")
    void tc3() {
        driver.findElement(By.xpath("//table[1]//th[1]")).click();
        List<WebElement> names = driver.findElements(By.xpath("//table[1]//tbody//tr//td[1]"));
        List<String> names1 = names.stream().map(WebElement::getText).collect(Collectors.toList());
        SortedSet<String> sorted = new TreeSet<>(names1);
        Assert.assertEquals(names1, sorted);
    }
    







}
