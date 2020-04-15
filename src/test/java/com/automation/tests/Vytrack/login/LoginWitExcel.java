package com.automation.tests.Vytrack.login;

import com.automation.pages.LoginPage;
import com.automation.tests.Vytrack.AbstractTestBase;
import com.automation.utulities.ExcelUtil;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginWitExcel  extends AbstractTestBase {

    @DataProvider
    public Object[][] credentialsFromExcel() {
        String path="VytrackTestUsers.xlsx";
        String spreadSheet="QA3-short";
        excelUtil= new ExcelUtil(path, spreadSheet);
        return  excelUtil.getDataArray();
    }


    @Test(dataProvider = "credentialsFromExcel")
    public void loginTestWithExcel2(String execute,String username, String password, String firstname, String lastname,String result){
        String path="VytrackTestUsers.xlsx";
        String spreadSheet="QA3-short";
        ExcelUtil excelUtils= new ExcelUtil(path, spreadSheet);
        test=report.createTest("Login test for"+username);
        if(execute.equals("y")){
            LoginPage loginPage = new LoginPage();
            loginPage.login(username, password);
            test.info("login with "+username+" was successful");
            test.pass("Test pass ");
            test.info(String.format("First name %s, Last name %s , user name %s",firstname, lastname,username));
            excelUtils.setCellData("Passed","result",row++);
        }else{
            test.skip("test skipped");
            excelUtils.setCellData("Skipped","result",row++);
            throw  new SkipException("test was skipped!!");
        }
    }
}
