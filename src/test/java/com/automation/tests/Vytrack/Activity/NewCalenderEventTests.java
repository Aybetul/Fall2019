package com.automation.tests.Vytrack.Activity;

import com.automation.pages.AbstractPageBase;
import com.automation.pages.Activities.CalenderEventsPage;
import com.automation.pages.LoginPage;
import com.automation.tests.Vytrack.AbstractTestBase;
import com.automation.utulities.BrowserUtils;
import com.automation.utulities.DateTimeUtilities;
import com.automation.utulities.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class NewCalenderEventTests extends AbstractTestBase {
    LoginPage loginPage = new LoginPage();
    CalenderEventsPage calendarEventsPage = new CalenderEventsPage();




    //================HW-5 Starts here========================
    /**
     * Test Case #1 1. Go to “https://qa1.vytrack.com/"
     * 2. Login as a store manager
     * 3. Navigate to “Activities -> Calendar Events”
     * 4. Hover on three dots “…” for “Testers meeting” calendar event
     * <p>
     * 5. Verify that “view”, “edit” and “delete” options are available
     */
    @Test
    public void TestCase1() {
        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        BrowserUtils.wait(10);
        List<String> lst = calendarEventsPage.getDotsValue();
        System.out.println(lst);
        Assert.assertTrue(lst.get(0).equals("View") && lst.get(1).equals("Edit") && lst.get(2).equals("Delete"));


    }

    /**
     * Test Case #2 1. Go to “https://qa1.vytrack.com/"
     * 2. Login as a store manager
     * 3. Navigate to “Activities -> Calendar Events”
     * 4. Click on “Grid Options” button
     * 5. Deselect all options except “Title”
     * 6. Verify that “Title” column still displayed
     */
    @Test
    public void TestCase2() { // passed
        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        calendarEventsPage.clickOnGridSetting();
        calendarEventsPage.clickAllAcceptTitle();
        Assert.assertTrue(calendarEventsPage.verifyTitleDisplayed());
    }

    /**
     * Test Case #3 1. Go to “https://qa1.vytrack.com/"
     * 2. Login as a store manager
     * 3. Navigate to “Activities -> Calendar Events”
     * <p>
     * 4. Click on “Create Calendar Event” button
     * 5. Expand “Save And Close” menu
     * 6. Verify that “Save And Close”, “Save And New” and “Save” options are available
     */
    @Test
    public void TextCase3() {
        test = report.createTest("Verify save and close options");
        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        //  calendarEventsPage.navigateToCalendarEvents();
        BrowserUtils.wait(10);
        calendarEventsPage.clickToCreateCalendarEvent2();
        BrowserUtils.wait(10);

        calendarEventsPage.clickSaveAndCloseArrow();
        BrowserUtils.wait(20);
        List<String> expected = Arrays.asList("Save And Close", "Save And New", "Save");
        List<String> actual = calendarEventsPage.getSaveAndCloseText();
        Assert.assertEquals(actual, expected);
    }

    /**
     * Test Case #4 1. Go to “https://qa1.vytrack.com/"
     * 2. Login as a store manager
     * 3. Navigate to “Activities -> Calendar Events”
     * 4. Click on “Create Calendar Event” button
     * 5. Then, click on “Cancel” button
     * 6Verify that “All Calendar Events” page subtitle is
     * displayed
     */
    @Test
    public void TestCase4() { // passed
        test = report.createTest("verify Title Displayed");
        loginPage.login();
        calendarEventsPage.navigateToCalendarEvents();
        BrowserUtils.wait(10);
        calendarEventsPage.clickToCreateCalendarEvent2();
        BrowserUtils.wait(10);
        calendarEventsPage.clickOnCancel();
        BrowserUtils.wait(5);
        Assert.assertTrue(calendarEventsPage.verifyTitleDisplayed());

    }


    /**
     * Test Case #6 1. Go to “https://qa1.vytrack.com/"
     * 2. Login as a store manager
     * 3. Navigate to “Activities -> Calendar Events”
     * 4. Click on “Create Calendar Event” button
     * <p>
     * 5. Select “9:00 PM” as a start time
     * 6. Verify that end time is equals to “10:00 PM”
     */
    @Test
    public void TestCase6() {
        test = report.createTest("verify time is 10:00 PM");
        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        BrowserUtils.wait(10);
        calendarEventsPage.clickToCreateCalendarEvent2();
        BrowserUtils.wait(10);
        calendarEventsPage.selectValueForStartTime();
        Assert.assertEquals(calendarEventsPage.getEndTime(), "10:00 PM");

    }


    /**
     * Test Case #7 1. Go to “https://qa1.vytrack.com/"
     * 2. Login as a store manager
     * 3. Navigate to “Activities -> Calendar Events”
     * 4. Click on “Create Calendar Event” button
     * <p>
     * 5. Select “All-Day Event” checkbox
     * 6. Verify that “All-Day Event” checkbox is selected
     * 7. Verify that start and end time input boxes are not displayed
     * 8. Verify that start and end date input boxes are displayed
     */

    @Test
    public void TestCase7() { // passed
        test = report.createTest("verify time check box are displayed ");
        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        BrowserUtils.wait(10);
        calendarEventsPage.clickToCreateCalendarEvent2();
        BrowserUtils.wait(10);
        calendarEventsPage.clickOnAllDayEventCheckBox();
        BrowserUtils.wait(10);
        Assert.assertTrue(calendarEventsPage.verifyAllDayEventCheckBoxIsSelected());
        Assert.assertFalse(calendarEventsPage.startTimeIsdisplayed());
        Assert.assertFalse(calendarEventsPage.endTimeIsdisplayed());
        Assert.assertTrue(calendarEventsPage.startDateIsdisplayed());
        Assert.assertTrue(calendarEventsPage.endDateIsdisplayed());
    }

    /**
     * Test Case #8
     * 1. Go to “https://qa1.vytrack.com/"
     * 2. Login as a store manager
     * 3. Navigate to “Activities -> Calendar Events”
     * 4. Click on “Create Calendar Event” button
     * 5. Select “Repeat” checkbox
     * 6. Verify that “Repeat” checkbox is selected
     * 7. Verify that “Daily” is selected by default and
     * following options are available in
     * “Repeats” drop-down:
     */


    @Test
    public void TestCase8() { // passed
        test = report.createTest("verify repeats options");
        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        BrowserUtils.wait(10);
        calendarEventsPage.clickToCreateCalendarEvent2();
        BrowserUtils.wait(10);
        calendarEventsPage.clickOnRepeatCheckBox();
        BrowserUtils.wait(10);
        Assert.assertTrue(calendarEventsPage.repeatCheckBoxIsSelected());
        Assert.assertEquals(calendarEventsPage.getFirstOptionRepeatsCheckBox(), "Daily");
        List<String> expected = Arrays.asList("Daily", "Weekly", "Monthly", "Yearly");
        List<String> actual = calendarEventsPage.getOptionRepeatsCheckBox();
        Assert.assertEquals(actual, expected);
        test.pass("Test Passed");
    }

    /**
     * Test Case #9
     * 1. Go to “https://qa1.vytrack.com/"
     * 2. Login as a store manager
     * 3. Navigate to “Activities -> Calendar Events”
     * 4. Click on “Create Calendar Event” button
     * 5. Select “Repeat” checkbox
     * 6. Verify that “Repeat” checkbox is selected
     * 7. Verify that “Repeat Every” radio button is
     * selected
     * 8. Verify that “Never” radio button is selected as an
     * “Ends” option.
     * 9. Verify that following message as a summary is
     * displayed: “Summary: Daily every 1 day”
     */
    @Test
    public void TestCase9() { // passed
        test = report.createTest("verify repeats options");
        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        BrowserUtils.wait(10);
        calendarEventsPage.clickToCreateCalendarEvent2();
        BrowserUtils.wait(10);
        calendarEventsPage.clickOnRepeatCheckBox();
        BrowserUtils.wait(10);
        String expectedSummary = calendarEventsPage.getSummaryText();
        String actualSummary = "Daily every 1 day";
        Assert.assertTrue(calendarEventsPage.repeatCheckBoxIsSelected());
        Assert.assertTrue(calendarEventsPage.isRepeatEveryBtnSelected());
        Assert.assertTrue(calendarEventsPage.isNeverBtnSelected());
        Assert.assertEquals(expectedSummary, actualSummary);

    }

    /**
     * Test Case #10
     * 1. Go to “https://qa1.vytrack.com/"
     * 2. Login as a store manager
     * 3. Navigate to “Activities -> Calendar Events”
     * 4. Click on “Create Calendar Event” button
     * 5. Select “Repeat” checkbox
     * 6. Select “After 10 occurrences” as an “Ends”
     * option.
     * 7. Verify that following message as a summary is
     * displayed: “Summary: Daily every 1 day, end
     * after 10 occurrences
     */
    @Test
    public void TestCase10() { // passed
        test = report.createTest("verify repeats options");
        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        BrowserUtils.wait(10);
        calendarEventsPage.clickToCreateCalendarEvent2();
        BrowserUtils.wait(10);
        calendarEventsPage.clickOnRepeatCheckBox();
        BrowserUtils.wait(20);

        String val = "10";
        calendarEventsPage.enterValueToAfter(val);
        BrowserUtils.wait(20);
        String expectedSummary = calendarEventsPage.getSummaryFullText();
        String actualSummary = "Daily every 1 day, end after " + val + " occurrences";
        Assert.assertEquals(expectedSummary, actualSummary);
        test.pass("test passed");
    }

    /**
     * Test Case #11
     * 1. Go to “https://qa1.vytrack.com/"
     * 2. Login as a store manager
     * 3. Navigate to “Activities -> Calendar Events”
     * 4. Click on “Create Calendar Event” button
     * 5. Select “Repeat” checkbox
     * 6. Select “By Nov 18, 2021” as an “Ends” option.
     * 7. Verify that following message as a summary is
     * displayed: “Summary: Daily every 1 day, end by
     * Nov 18, 2021”
     */
    @Test
    public void TestCase11() {
        test =report.createTest("verify repeats options");
        loginPage.login();
        calendarEventsPage.navigateTo("Activities","Calendar Events");
        BrowserUtils.wait(10);
        calendarEventsPage.clickToCreateCalendarEvent2();
        BrowserUtils.wait(10);
        calendarEventsPage.clickOnRepeatCheckBox();
        BrowserUtils.wait(20);
            calendarEventsPage.selectNow182021();
          //  Assert.assertFalse();

    }

    /**
     * Test Case #12
     * 1. Go to “https://qa1.vytrack.com/"
     * 2. Login as a store manager
     * 3. Navigate to “Activities -> Calendar Events”
     * 4. Click on “Create Calendar Event” button
     * 5. Select “Repeat” checkbox
     * 6. Select “Weekly” options as a “Repeat” option
     * 7. Select “Monday and Friday” options as a
     * “Repeat On” options
     * 8. Verify that “Monday and Friday” options are
     * selected
     * 9. Verify that following message as a summary is
     * displayed: “Summary: Weekly every 1 week on
     * Monday, Friday”
     */

    @Test
    public void TestCase12() {
        test = report.createTest("verify repeats options");
        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        BrowserUtils.wait(10);
        calendarEventsPage.clickToCreateCalendarEvent2();
        BrowserUtils.wait(10);
        calendarEventsPage.clickOnRepeatCheckBox();
        BrowserUtils.wait(20);
        calendarEventsPage.selectWeekly();
        BrowserUtils.wait(10);
        calendarEventsPage.selectDays("monday", "friday");
        String expected="Summary: Weekly every 1 week on Monday, Friday";
        String actual=calendarEventsPage.getTextFromSummary();
        Assert.assertEquals(actual,expected);
    }


//=============HW-5 ends here==================================



    @Test
     public void verifyUserName() {
        test = report.createTest("Verify user name");

    loginPage.login();
        calendarEventsPage.navigateTo("Activities","Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();
        Assert.assertEquals(calendarEventsPage.getOwner(),calendarEventsPage.getCurrentUserName());
        test.pass("Test passed");

    }
    /**
     * Test Case: Default options
     * Login as sales manager
     * Go to Activities --> Calendar Events
     * Click on Create Calendar Event
     * Default owner name should be current user/
     **/
    @Test
    public void defaultOptionsTest() {
        test = report.createTest("Verify default options");

        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();
        Assert.assertEquals(calendarEventsPage.getOwner(), calendarEventsPage.getCurrentUserName());
        String actualStartDate = calendarEventsPage.getStartedDate();
        String expectedStartDate = DateTimeUtilities.GetCurrentDate("MMM d, yyyy");
        Assert.assertEquals(actualStartDate, expectedStartDate);
        test.pass("Test passed");
    }

    /**
     * 15 minutes until 3:45
     * Test Case: Time difference
     * Login as sales manager
     * Go to Activities --> Calendar Events
     * Click on Create Calendar Event
     * Verify that difference between start and end time is 1 hour
     **/
    @Test
    public void TimeDifference() {
        test = report.createTest("Verify time difference");

        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();
        String startTime = calendarEventsPage.getStartedTime();
        String endTime = calendarEventsPage.getEndTime();
        String format = "h:mm a";
        long actual = DateTimeUtilities.getTimeDifference(startTime,endTime,format);
        Assert.assertEquals(actual,1,"Time difference is not correct");
        test.pass("Test passed");
    }

     @Test
     public void verifyColumnNames(){
         test = report.createTest("Verify column names");

         loginPage.login();
    calendarEventsPage.navigateTo("Activities", "Calendar Events");
    List<String> expected = Arrays.asList("TITLE", "CALENDAR", "START", "END", "RECURRENT", "RECURRENCE", "INVITATION STATUS");
    Assert.assertEquals(calendarEventsPage.getColumnNames(),expected);
    test.pass("Test passed");
}

    @Test(dataProvider = "calendarEvents")
    public void createCalendarEventTest(String title, String description) {
        //if you have more one test, and 1st pass but others failing,
        //you are getting session id is null exception
        //because driver object was not initialized in time
        //just create page objects inside a test
        LoginPage loginPage = new LoginPage();
        CalenderEventsPage calendarEventsPage = new CalenderEventsPage();

        //only for extent report. To create a test in html report
        test = report.createTest("Create calendar event for"+title);
        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();
        calendarEventsPage.enterCalendarEventTitle(title);
        calendarEventsPage.enterCalendarEventDescription(description);
        calendarEventsPage.clickOnSaveAndClose();

        //verify that calendar event info is correct
        Assert.assertEquals(calendarEventsPage.getGeneralInfoDescriptionText(), description);
        Assert.assertEquals(calendarEventsPage.getGeneralInfoTitleText(), title);

        //for extent report. specify that test passed in report (if all assertions passed)
        test.pass("Calendar event was created successfully!");
    }

    @DataProvider
    public Object[][] calendarEvents() {
        return new Object[][]{
                {"Daily stand-up",  "Scrum meeting to provide updates"},
                {"Sprint Review",   "Scrum meeting where team discussing previous sprint"},
                {"Sprint Planning", "Scrum meeting where team discussing backlog for following sprint"}


    };
    }



}
