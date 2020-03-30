package com.automation.tests.day13;

import org.testng.annotations.Test;

public class SystemProperties {

    @Test
  public void test(){
        System.out.println(System.getProperty("user.dir"));  // this is user directory
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("user.home"));
String pathToDownloads=System.getProperty("user.home")+"\\Downloads"; // finds downloads path
        System.out.println(pathToDownloads);
        System.out.println(System.getProperty("os.arch"));

  }



}
