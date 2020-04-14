package com.automation.pages.Orange;

import com.automation.pages.AbstractPageBase;
import com.automation.utulities.BrowserUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class OrangeLoginPage extends AbstractPageBase {


    @FindBy(id="txtUsername")
   private WebElement username;

    @FindBy(id="txtPassword")
    private WebElement password;


    @FindBy(id="menu_admin_viewAdminModule")
    private WebElement adminBtn;

    @FindBy(id="btnAdd")
    private WebElement addBtn;

    @FindBy(id="systemUser_employeeName_empName")
    private WebElement employeeNameInput;

    @FindBy(id="systemUser_userName")
    private WebElement userNameInput;

    @FindBy(id="systemUser_password")
    private WebElement passwordInput;

    @FindBy(id="systemUser_confirmPassword")
    private WebElement confirmPasswordInput;

    @FindBy(id="btnSave")
    private WebElement saveBtn;

    @FindBy(xpath = "//tbody//tr//td[3]")
    private List<WebElement> userNameList;

   public void login(){
       username.sendKeys("Admin");
       password.sendKeys("admin123", Keys.ENTER);
   }
    public void clickOnAdminModule(){
       wait.until(ExpectedConditions.elementToBeClickable(adminBtn)).click();
}

    public void clickOnAddBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(addBtn)).click();
    }

    public void clickOnSaveBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn)).click();
    }

    public List<String > getUserNameList(){
        return BrowserUtils.TextFromWebElement(userNameList);
    }

     public void addUser(String username, String employeeName, String password){
       employeeNameInput.sendKeys(employeeName);
        userNameInput.sendKeys(username);
         passwordInput.sendKeys(password);
          confirmPasswordInput.sendKeys(password);
            wait.until(ExpectedConditions.elementToBeClickable(saveBtn)).click();
}


}
