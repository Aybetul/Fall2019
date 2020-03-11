package com.automation.tests.day7;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;

public class TestNgDemo {
    @BeforeSuite
    public void beforeSuit(){
        System.out.println("Before Suit");
    }
@BeforeTest
public void beforeTest(){
    System.out.println("Before Test");
}
    @BeforeClass
    public void  beforeClass(){
        System.out.println("Before class");
    }
@BeforeMethod
    public void  beforeMethod(){
        System.out.println("Before method");
    }
@Test(priority = 2)
    public  void test1(){
       String word= "java" ;
       String word2= "java";
        System.out.println("test 1");
        Assert.assertEquals(word,word2);
    }
@Test(priority = 3)
    public  void test2(){
        String word= "javascript" ;
        String word2= "javascript";
        System.out.println("test 2");
        Assert.assertEquals(word, word2);
    }
@Test(priority = 1)
    public  void test3(){
        Assert.assertTrue(7   >4);
        System.out.println("test 3");
        throw new SkipException("just skipped");  // this one skips the test
    }

    @AfterClass
    public void  afterClass(){
        System.out.println("After class");
    }
    @AfterMethod
    public void  afterMethod(){
        System.out.println("After method");
    }
    @AfterTest
    public void AfterTest(){
        System.out.println("After Test ");
    }
    @AfterSuite
    public void afterSuit(){
        System.out.println("After suit");
    }
}
