package com.automation.pages.Activities;
import com.automation.pages.AbstractPageBase;
import com.automation.utulities.BrowserUtils;
import com.automation.utulities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

public class CalenderEventsPage extends AbstractPageBase {
    private WebDriver driver;
    private WebDriverWait wait;

   @FindBy(css= "[title='Create Calendar event']")
   private WebElement createCalendarEvent;

    @FindBy(xpath= "(//a[contains(text(),'Create Calendar event')])[3]")
    private WebElement createCalendarEvent2;

    @FindBy(className = "select2-chosen")
   private WebElement owner;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_start']")
   private WebElement startDate;

    @FindBy(xpath = "(//input[@placeholder='Choose a date'])[1]")
    private WebElement startDateInput;

    @FindBy(xpath = "(//input[@placeholder='Choose a date'])[2]")
    private WebElement endDateInput;

    @FindBy(xpath = "(//input[@placeholder='time'])[2]")
    private WebElement endTimeInput;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_start']")
    private WebElement startTime;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_end']")
    private WebElement endTime;

    @FindBy(className="grid-header-cell__label")
    private List<WebElement> columnNames;

    @FindBy(css = "iframe[id^='oro_calendar_event_form_description-uid']")
    private WebElement descriptionFrame;

    @FindBy(css = "[id^='oro_calendar_event_form_title-uid']")
    private WebElement title;

    @FindBy(id = "tinymce")
    private WebElement descriptionTextArea;

    @FindBy(css = "[class='btn-group pull-right'] > button")
    private WebElement saveAndClose;

    @FindBy(xpath = "(//div[@class='control-label'])[1]")
    private WebElement generalInfoTitle;

    @FindBy(xpath = "//label[text()='Description']/following-sibling::div//div")
    private WebElement generalInfoDescription;

    @FindBy(xpath = "//td[text()='Testers meeting']/following-sibling::td//li//li//a")
    private List<WebElement> dotsForTestersMeeting;

    @FindBy(xpath = "//a[@title='Grid Settings']")
    private WebElement gridBtn;

@FindBy(css = "[data-role=renderable]")
private List<WebElement> gridSettingList;

@FindBy(xpath = "(//span[@class='grid-header-cell__label'])[1]")
private WebElement titleInHeader;

@FindBy(className = "main-group action-button dropdown-item")
private List<WebElement> saveAndCloseList;

@FindBy(css="[class='caret']")
private WebElement SaveAndCloseArrow;

    @FindBy(xpath="//a[@title='Cancel']")
    private WebElement cancel;

    @FindBy(xpath="(//input[@placeholder='time'])[1]")
    private WebElement startTimeInput;

    @FindBy(xpath="//input[contains(@id,'form_allDay')]")
    private WebElement allDayEventCheckBox;

    @FindBy(xpath="//input[@data-name='recurrence-repeat']")
    private WebElement repeatCheckBox;

    @FindBy(xpath="//select[@class='recurrence-repeats__select']")
    private WebElement repeatsCheckBox;

@FindBy(xpath = "//input[@checked='checked']")
private  WebElement repeatEveryBtn;

    @FindBy(xpath = "(//div//label//input[@type='radio'])[1]")
    private  WebElement neverBtn;

    @FindBy(xpath = "//span[text()='Daily every 1 day']")
    private  WebElement summaryText;

    @FindBy(xpath = "//span[text()=', end after 10 occurrences']")
    private  WebElement summaryFullText;

    @FindBy(css = "[data-related-field='occurrences']")
    private  WebElement afterInput;

    @FindBy(className = "ui-datepicker-month")
    private  WebElement selectMouth;

    @FindBy(className = "ui-datepicker-year")
    private  WebElement selectYear;

    @FindBy(className = "ui-state-default ui-state-active")
    private  WebElement selectDay18;

    @FindBy(css="[data-name=multi-checkbox-value-keeper]")
    private WebElement RepeatOnDayOptions;

    @FindBy (xpath="//span[text()='Weekly every 1 week on Monday, Friday']")
    private WebElement SummaryText;



    public String getTextFromSummary(){
     return   SummaryText.getText();
    }


    public WebElement getStartTime(){
        return startTime;
    }

    public void selectDays(String day1, String day2){
driver.findElement(By.xpath("//input[@value='"+day1+"']")).click();
        driver.findElement(By.xpath("//input[@value='"+day2+"']")).click();
    }

    public void clickTimePM(String h){
        driver.findElement(By.xpath("//li[text()='"+h+":00 PM']")).click();
    }

    public void selectWeekly(){
        repeatsCheckBox.click();
        Select s= new Select(repeatsCheckBox);
        s.selectByVisibleText("Weekly");

    }

    public void selectDate(String mouth,String year,String day){
    endDateInput.click();
    Select s=new Select(selectMouth);
    s.selectByVisibleText(mouth);
    Select n=new Select(selectYear);
    n.selectByVisibleText(year);
driver.findElement(By.xpath("//a[text()='"+day+"']")).click();
}


    public String getSummaryFullText(){
        return summaryText.getText()+ summaryFullText.getText();
    }


    public void enterValueToAfter(String value){
     //   wait.until(ExpectedConditions.visibilityOf(afterInput));
        afterInput.click();
      afterInput.sendKeys(value, Keys.ENTER);
    }

public String getSummaryText(){
    return summaryText.getText();
}

public boolean isNeverBtnSelected(){
        return neverBtn.isSelected();
    }



    public void clickToCreateCalendarEvent2() {
        BrowserUtils.waitForPageToLoad(20);
      //  wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("(//a[contains(text(),'Create Calendar event')])[3]")));
      //  wait.until(ExpectedConditions.elementToBeClickable(createCalendarEvent2)).click();
        createCalendarEvent2.click();
        BrowserUtils.waitForPageToLoad(20);
    }

public boolean isRepeatEveryBtnSelected(){
        return repeatEveryBtn.isSelected();
}

public String getFirstOptionRepeatsCheckBox(){
        Select s= new Select(repeatsCheckBox);
     String n =  s.getFirstSelectedOption().getText();
      return n;
    }

    public List<String> getOptionRepeatsCheckBox(){
        Select s= new Select(repeatsCheckBox);
      List<  String >n = BrowserUtils.TextFromWebElement( s.getOptions());
        return n;
    }

    public void clickOnRepeatCheckBox(){
        BrowserUtils.waitForPageToLoad(20);
        // wait.until(ExpectedConditions.elementToBeClickable(repeatCheckBox)).click();
       repeatCheckBox.click();
        BrowserUtils.waitForPageToLoad(20);
    }

    public boolean repeatCheckBoxIsSelected(){
        BrowserUtils.waitForPageToLoad(20);
        return repeatCheckBox.isSelected();
    }

    public boolean startTimeIsdisplayed(){
        BrowserUtils.wait(10);
        return startTimeInput.isDisplayed();
    }

    public boolean endTimeIsdisplayed(){
        BrowserUtils.wait(10);
        return endTimeInput.isDisplayed();
    }

    public boolean startDateIsdisplayed(){
        BrowserUtils.wait(10);
        return startDateInput.isDisplayed();
    }

    public boolean endDateIsdisplayed(){
        BrowserUtils.wait(10);
        return endDateInput.isDisplayed();
    }

    public void clickOnAllDayEventCheckBox(){
        BrowserUtils.waitForPageToLoad(20);
        // wait.until(ExpectedConditions.elementToBeClickable(allDayEventCheckBox)).click();
        allDayEventCheckBox.click();
        BrowserUtils.waitForPageToLoad(20);
    }

    public boolean verifyAllDayEventCheckBoxIsSelected(){
        BrowserUtils.waitForPageToLoad(20);
     return   allDayEventCheckBox.isSelected();

    }

    public void selectValueForStartTime(){
    BrowserUtils.waitForPageToLoad(20);
   startTimeInput.click();
   BrowserUtils.scrollTo(driver.findElement(By.xpath("//li[text()='09:00 PM']")));
        driver.findElement(By.xpath("//li[text()='09:00 PM']")).click();
  BrowserUtils.waitForPageToLoad(20);
}

public void clickOnCancel(){
        BrowserUtils.waitForPageToLoad(20);
        // wait.until(ExpectedConditions.elementToBeClickable(SaveAndCloseArrow)).click();
        cancel.click();
        BrowserUtils.waitForPageToLoad(20);
    }

public void clickSaveAndCloseArrow(){
        BrowserUtils.waitForPageToLoad(20);
        // wait.until(ExpectedConditions.elementToBeClickable(SaveAndCloseArrow)).click();
        SaveAndCloseArrow.click();
        BrowserUtils.waitForPageToLoad(20);
    }


public List<String> getSaveAndCloseText(){
    BrowserUtils.waitForPageToLoad(20);
  return   BrowserUtils.TextFromWebElement(saveAndCloseList);
}
//=============================================
//HW5 textCase2
public void clickAllAcceptTitle(){
    BrowserUtils.waitForPageToLoad(10);
    for(int i=1 ;i<gridSettingList.size();i++){
      //  wait.until(ExpectedConditions.elementToBeClickable( gridSettingList.get(i))).click();
        gridSettingList.get(i).click();
        BrowserUtils.waitForPageToLoad(10);
    }
}
public boolean verifyTitleDisplayed(){
   BrowserUtils.waitForPageToLoad(10);
 return   titleInHeader.isDisplayed();
}



    public void clickOnGridSetting(){
        BrowserUtils.waitForPageToLoad(20);
       // wait.until(ExpectedConditions.elementToBeClickable(gridBtn)).click();
        gridBtn.click();
    }
//==========================================================

    public List<WebElement> getDotsList(){

        return dotsForTestersMeeting;
    }

    public WebElement getDot(){
        return  driver.findElement(By.xpath("//td[.=\"Testers meeting\"]/..//div//a"));
}

public void enterCalendarEventTitle(String titleValue) {
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(title)).sendKeys(titleValue);
    }

    public void enterCalendarEventDescription(String description) {
        //wait until frame is available and switch to it
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(descriptionFrame));
        descriptionTextArea.sendKeys(description);
        driver.switchTo().defaultContent();//exit from the frame
    }

    public void clickOnSaveAndClose() {
        wait.until(ExpectedConditions.elementToBeClickable(saveAndClose)).click();
    }

    public String getGeneralInfoTitleText() {
        BrowserUtils.waitForPageToLoad(20);
        return generalInfoTitle.getText();
    }

    public String getGeneralInfoDescriptionText() {
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Description']/following-sibling::div//div")));
        return generalInfoDescription.getText();
    }



    //==================================================
    public List<String> getColumnNames(){
        BrowserUtils.waitForPageToLoad(20);
        return BrowserUtils.TextFromWebElement(columnNames);

    }


    public String getOwner(){
       BrowserUtils.waitForPageToLoad(10);
       wait.until(ExpectedConditions.presenceOfElementLocated(By.className("select2-chosen")));
       wait.until(ExpectedConditions.visibilityOf(owner));
       return owner.getText().trim();
   }


    public String getStartedDate(){
       BrowserUtils.waitForPageToLoad(10);
       wait.until(ExpectedConditions.visibilityOf(startDate));
        BrowserUtils.scrollTo(startDate);
       return startDate.getAttribute("value");

}

    public String getStartedTime(){
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id^='time_selector_oro_calendar_event_form_start']")));
        wait.until(ExpectedConditions.visibilityOf(startTime));
        return startTime.getAttribute("value");

    }
    public String getEndTime(){
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(endTime));
        return endTime.getAttribute("value");

    }
    public void clickToCreateCalendarEvent() {
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[title='Create Calendar event']")));
        wait.until(ExpectedConditions.elementToBeClickable(createCalendarEvent)).click();
        BrowserUtils.waitForPageToLoad(20);
    }

    public void navigateToCalendarEvents(){
        WebElement loaderMask= null;
        driver = Driver.getDriver();
        wait= new WebDriverWait(driver, 20);
        if(driver.findElements(By.cssSelector("div[class='loader-mask shown']")).size()>0) {
            loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        }

        WebElement activitiesElement = driver.findElement(By.linkText("Activities"));
        wait.until(ExpectedConditions.visibilityOf(activitiesElement));
        wait.until(ExpectedConditions.elementToBeClickable(activitiesElement));
        activitiesElement.click();

        WebElement calendarEventsElement = driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.visibilityOf(calendarEventsElement));
        wait.until(ExpectedConditions.elementToBeClickable(calendarEventsElement));
        calendarEventsElement.click();

        wait.until(ExpectedConditions.invisibilityOf(loaderMask));
    }


}
