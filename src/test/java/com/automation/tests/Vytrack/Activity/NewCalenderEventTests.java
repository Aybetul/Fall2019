package com.automation.tests.Vytrack.Activity;

import com.automation.pages.AbstractPageBase;
import com.automation.pages.Activities.CalenderEventsPage;
import com.automation.pages.LoginPage;
import com.automation.tests.Vytrack.AbstractTestBase;
import com.automation.utulities.BrowserUtils;
import com.automation.utulities.DateTimeUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

public class NewCalenderEventTests extends AbstractTestBase {
    LoginPage lgn = new LoginPage();
    CalenderEventsPage calendarEventsPage= new CalenderEventsPage();


    @Test
     public void verifyUserName() {
        lgn.login();
        calendarEventsPage.navigateTo("Activities","Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();
        Assert.assertEquals(calendarEventsPage.getOwner(),calendarEventsPage.getCurrentUserName());

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
        lgn.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();
        Assert.assertEquals(calendarEventsPage.getOwner(), calendarEventsPage.getCurrentUserName());
        String actualStartDate = calendarEventsPage.getStartedDate();
        String expectedStartDate = DateTimeUtilities.GetCurrentDate("MMM dd, yyyy");
        Assert.assertEquals(actualStartDate, expectedStartDate);
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
        lgn.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();
        String startTime = calendarEventsPage.getStartedTime();
        String endTime = calendarEventsPage.getEndTime();
        String format = "h:mm a";
        long actual = DateTimeUtilities.getTimeDifference(startTime,endTime,format);
        Assert.assertEquals(actual,1,"Time difference is not correct");
    }

     @Test
     public void verifyColumnNames(){
    lgn.login();
    calendarEventsPage.navigateTo("Activities", "Calendar Events");
    List<String> expected = Arrays.asList("TITLE", "CALENDAR", "START", "END", "RECURRENT", "RECURRENCE", "INVITATION STATUS");
    Assert.assertEquals(calendarEventsPage.getColumnNames(),expected);
}

}
