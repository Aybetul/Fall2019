package com.automation.tests.SelfPractice.LambdaIntro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerInterface {
    public static void main(String[] args) {

        Consumer<String> doublePrinter = new StringDoublePrinter();
        doublePrinter.accept("apple");


        // with Lambda
        Consumer<String> print = t -> System.out.println(t + "    " + t);
        print.accept("orange");

        // Lambda practice
        List<String> names = new ArrayList<>(Arrays.asList("melih", "metin", "aybetul", "akif"));
        names.forEach(t -> System.out.println(t));
    }
}
