package com.automation.tests.day13;

import com.automation.utulities.ConfigurationReader;
import com.automation.utulities.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ConfigurationReaderTest {



    @Test
    public void readProperties(){
      String browser= ConfigurationReader.getProperty("browser") ;
        System.out.println(browser);

        String url=ConfigurationReader.getProperty("qa1");  //click and hold ctrl to see the qa1 value
        System.out.println(url);

        String clr= ConfigurationReader.getProperty("color");
        System.out.println(clr);

        String storeManager=ConfigurationReader.getProperty("store_manager") ;
        System.out.println(storeManager);
        String driver1=ConfigurationReader.getProperty("driver1");
        System.out.println(driver1);

        WebDriver driver= DriverFactory.createDriver(browser);
        driver.get(url);
    }
}
