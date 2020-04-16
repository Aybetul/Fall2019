package com.automation.tests.SelfPractice;

public class Bitrix {

    /**
     *
     List<String > workFlowsLst= Arrays.asList("Leave Approval","Business Trip","General Requests","Purchase Request","Expense Report");


     @Test(description = "US8_AC1")
     public void WorkFlowTest(){
     LoginPage loginPage=new LoginPage();
     loginPage.login();
     WorkFlowsPage workFlowsPage=new WorkFlowsPage();
     workFlowsPage.navigateToWorkFlows("Leave Approval");
     workFlowsPage.clickOnAdd();
     workFlowsPage.startDatePicker("17","May","2022");
     workFlowsPage.endDatePicker("18","May","2022");
     workFlowsPage.selectAbsenceType("Sick leave");
     workFlowsPage.SendKeysReasonToLeave("I think i have Covid-19! Sorry!!!");

     }


     import org.openqa.selenium.By;
     import org.openqa.selenium.Keys;
     import org.openqa.selenium.WebElement;
     import org.openqa.selenium.support.FindBy;
     import org.openqa.selenium.support.ui.ExpectedConditions;
     import org.openqa.selenium.support.ui.Select;
     import pages.AbstractBasePage;


     public class WorkFlowsPage extends AbstractBasePage {

     // Set up the branch
     @FindBy(id="left-menu-more-btn")
     private WebElement moreBtn;

     @FindBy (xpath = "(//span[contains(text(),'Workflows')])[1]")
     private WebElement workFlows ;

     @FindBy (xpath = "(//span[contains(text(),'Workflows in Activity Stream')])")
     private  WebElement WorkFlowsInAS;

     @FindBy(id = "lists-title-action-add")
     private  WebElement addbtn;

     @FindBy(xpath = "//*[@id=\"tab_el_edit_table\"]/tbody/tr[2]/td[2]/img")
     private  WebElement startDatePicker;

     @FindBy(xpath = "(//img[@class='calendar-icon'])[2]")
     private  WebElement endDatePicker;

     @FindBy (className = "bx-calendar-top-month")
     private  WebElement mouthPicker;

     @FindBy (className = "bx-calendar-top-year")
     private  WebElement yearPicker;

     @FindBy(name = "PREVIEW_TEXT")
     private WebElement ReasonToLeave;




     public void SendKeysReasonToLeave(String reason){
     ReasonToLeave.sendKeys(reason, Keys.ENTER);
     }


     public void selectAbsenceType(String type){
     Select select=new Select(driver.findElement(By.name("PROPERTY_88")));
     select.selectByVisibleText(type);
     }


     public void endDatePicker(String day, String month, String year){
     utilities.BrowserUtils.clickWithJS(endDatePicker);
     wait.until(ExpectedConditions.elementToBeClickable(mouthPicker)).click();
     driver.findElement(By.xpath("//span[text()='"+month+"']")).click();
     utilities.BrowserUtils.clickWithJS(yearPicker);
     driver.findElement(By.xpath("//span[text()='"+year+"']")).click();
     utilities.BrowserUtils.clickWithJS(  driver.findElement(By.xpath("//a[@class='bx-calendar-cell'][text()='"+day+"']")));

     }

     public void startDatePicker(String day, String month, String year){
     utilities.BrowserUtils.clickWithJS(startDatePicker);
     wait.until(ExpectedConditions.elementToBeClickable(mouthPicker)).click();
     driver.findElement(By.xpath("//span[text()='"+month+"']")).click();
     utilities.BrowserUtils.clickWithJS(yearPicker);
     driver.findElement(By.xpath("//span[text()='"+year+"']")).click();
     utilities.BrowserUtils.clickWithJS(  driver.findElement(By.xpath("//a[@class='bx-calendar-cell'][text()='"+day+"']")));

     }


     public void navigateToWorkFlows(String tabName){
     utilities.BrowserUtils.waitForPageToLoad(10);
     wait.until(ExpectedConditions.elementToBeClickable(moreBtn)) .click();
     utilities.BrowserUtils.waitForPageToLoad(10);
     wait.until(ExpectedConditions.elementToBeClickable(workFlows)) .click();
     utilities.BrowserUtils.waitForPageToLoad(10);
     wait.until(ExpectedConditions.elementToBeClickable(WorkFlowsInAS)) .click();
     utilities.BrowserUtils.waitForPageToLoad(10);
     String xpath="//a[text()='"+tabName+"']";
     wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpath)))).click();
     utilities.BrowserUtils.wait(5);
     }

     public void clickOnAdd(){
     utilities.BrowserUtils.waitForPageToLoad(10);
     wait.until(ExpectedConditions.elementToBeClickable(addbtn)).click();
     }




     */
}
