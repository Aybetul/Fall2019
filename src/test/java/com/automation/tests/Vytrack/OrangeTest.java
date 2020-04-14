package com.automation.tests.Vytrack;

import com.automation.pages.Orange.OrangeLoginPage;
import com.automation.utulities.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class OrangeTest  extends AbstractTestBase{
private WebDriver driver;
    /**
     * Go to https://opensource-demo.orangehrmlive.com/
     * Login with this credentials  (Username : Admin | Password : admin123)
     * Click admin module
     * Click add
     * fill out the blanks and save.
     * Verify your information on the list
     *
     *
     */
@Test
    public void addUserAndVerify(){

        test=report.createTest("Verify new user added");
        OrangeLoginPage orange=new OrangeLoginPage();
        orange.login();
        orange.clickOnAdminModule();
         List<String> userList=  orange.getUserNameList();
        orange.clickOnAddBtn();
        String nameToAdd="LindaLinda3";
        orange.addUser(nameToAdd,"Linda Anderson","UserUser135");
        orange.clickOnSaveBtn();
        BrowserUtils.wait(3);
      List<String> userList2=  orange.getUserNameList();
        Assert.assertTrue(userList.size()<userList2.size());
        test.pass("Test passed");
    }









}
