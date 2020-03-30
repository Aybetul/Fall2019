package com.automation.tests.Vytrack.login;

import com.automation.pages.LoginPage;
import com.automation.tests.Vytrack.AbstractTestBase;
import com.automation.utulities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class NewLoginTest extends AbstractTestBase {


    @Test
public void verifyPageTitle(){
        LoginPage loginpage=new LoginPage();
        loginpage.login();

        String expected = "Dashboard";
        String actual = Driver.getDriver().getTitle();
        Assert.assertEquals(actual, expected, "Page title is not correct!");
}
         @Test
        public void VerifyWarningMessage(){
            LoginPage loginpage=new LoginPage();
            loginpage.login("user", "123");
            Assert.assertEquals( loginpage.getWarningText(),"Invalid user name or password.");
         }




}
