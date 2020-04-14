package com.automation.tests.Vytrack.login;

import com.automation.pages.LoginPage;
import com.automation.tests.Vytrack.AbstractTestBase;
import com.automation.utulities.BrowserUtils;
import com.automation.utulities.Driver;
import com.automation.utulities.ExcelUtil;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class NewLoginTest extends AbstractTestBase {

// TO SEE THE REPORT -> TEST OUTPUT ->SHOW IN EXPLORER
    @Test
public void verifyPageTitle(){

        test=report.createTest("Verify page title");// we must add to every test at the beginning
        LoginPage loginpage=new LoginPage();
        loginpage.login();
        test.info("Login as store manager");
        String expected = "Dashboard";
        String actual = Driver.getDriver().getTitle();
        Assert.assertEquals(actual, expected, "Page title is not correct!");
        test.pass("Page title Dashboard was verified"); // if assertion pass it will set test status in report to passed

}
         @Test
        public void VerifyWarningMessage(){
             test=report.createTest("Verify warning message");
            LoginPage loginpage=new LoginPage();
            loginpage.login("user", "123");
            Assert.assertEquals( loginpage.getWarningText(),"Invalid user name or password.");
             BrowserUtils.getScreenshot("warning message");
             test.pass("Warning message displayed");

         }
    @Test(dataProvider = "credentials")
    public void loginWithDDT(String userName, String password) {
        test = report.createTest("Verify page title");
        LoginPage loginPage = new LoginPage();
        loginPage.login(userName, password);
        test.info("Login as " + userName);//log some steps
        BrowserUtils.wait(2);
        Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard");
        test.pass("Page title Dashboard was verified");
    }


    //Object[][] or Object[] or Iterator<Object[]>
//Object[] - 1 column with a data
//Object[][] 2+
    @DataProvider
    public Object[][] credentials() {
        return new Object[][]{
                {"storemanager85", "UserUser123"},
                {"salesmanager110", "UserUser123"},
                {"user16", "UserUser123"},
        };
    }


    @DataProvider
public Object[][] credentialsFromExcel() {
        String path="VytrackTestUsers.xlsx";
        String spreadSheet="QA3-short";
        ExcelUtil excelUtils= new ExcelUtil(path, spreadSheet);
      return  excelUtils.getDataArray();
    }

@Test (dataProvider = "credentialsFromExcel")
public void loginTestWithExcel(String execute,String username, String password, String firstname, String lastname,String result){
   test=report.createTest("Login test for"+username);
   if(execute.equals("y")){
       LoginPage loginPage = new LoginPage();
       loginPage.login(username, password);
       test.info("login with "+username+" was successful");
       test.pass("Test pass ");
       test.info(String.format("First name %s, Last name %s , user name %s",firstname, lastname,username));
   }else{
       test.skip("test skipped");
       throw  new SkipException("test was skipped!!");
   }
}




}
