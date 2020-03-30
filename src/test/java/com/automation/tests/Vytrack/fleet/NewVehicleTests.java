package com.automation.tests.Vytrack.fleet;

import com.automation.pages.LoginPage;
import com.automation.pages.fleet.VehiclesPage;
import com.automation.tests.Vytrack.AbstractTestBase;
import com.automation.utulities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class NewVehicleTests extends AbstractTestBase {
    @Test
    public void verifyTitle(){
        LoginPage loginPage = new LoginPage();  // we used this class to log in
        VehiclesPage vehiclesPage = new VehiclesPage();  // we used this class to navigate
        loginPage.login();
        vehiclesPage.navigateTo("Fleet", "Vehicles");
        String expectedTitle = "All - Car - Entities - System - Car - Entities - System";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}