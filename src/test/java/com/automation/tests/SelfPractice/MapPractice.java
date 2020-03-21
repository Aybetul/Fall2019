package com.automation.tests.SelfPractice;

import java.util.HashMap;
import java.util.Map;

public class MapPractice {
    // is map iterable?  NO!!! (  It doesn't implement the Iterable, SO WE CAN'T USE loop)

    public static void main(String[] args) {


        Map<String, String> nameStatePair = new HashMap<>();
        nameStatePair.put("Fatih", "FL");
        nameStatePair.put("John", "TN");
        nameStatePair.put("Vlad", "SC");
        nameStatePair.put("Hasan", "NY");
        nameStatePair.put("Abdullo", "NY");
        nameStatePair.put("Atakan", "GA");
        System.out.println("nameStatePair = " + nameStatePair);

    }
}