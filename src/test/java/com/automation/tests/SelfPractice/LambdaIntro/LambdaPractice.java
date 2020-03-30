package com.automation.tests.SelfPractice.LambdaIntro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class LambdaPractice {


    public static void main(String[] args) {

        // instead of using this code we will use lambda to make the code shorter
//        Moveable moveXMile= new Moveable() {
//            @Override
//            public void move(int mile) {
//                System.out.println("moving "+mile );
//            }
//        };

        // Lambda is shorter this is a object creating
        Moveable moveXMile = (int mile) -> System.out.println("moving " + mile);
        Moveable moveXMile2 = mile -> System.out.println("moving fast " + mile);
        moveAction(moveXMile);
        moveAction(mile -> System.out.println("moving fast " + mile));


        // with lambda we create object without a class
        Measurable m1 = () -> System.out.println("measuring Square ");
        Measurable m2 = () -> System.out.println("measuring Rectangle  ");

        Measurable m3 = () -> {
            System.out.println("measuring Circle  step1 ");
            System.out.println("measuring Circle  step2 ");
            System.out.println("measuring Circle  step3 ");
        };
        m1.measure();
        m2.measure();
        m3.measure();

        // with two parameter
        Computer addre = (num1, num2) -> System.out.println("adding " + (num1 + num2));
        Computer multiplier = (num1, num2) -> System.out.println("mulpling " + (num1 * num2));

// with return type
        Flyable drone = (mile) -> {
            return mile > 10;
        };
        Flyable drone2 = mile -> mile > 10;

        System.out.println(drone.flyHigh(4));
        System.out.println(drone.flyHigh(15));


        // Function Interface
        Function<String, Integer> length = t -> t.length();
        List<String> names = new ArrayList<>(Arrays.asList("melih", "metin", "aybetul", "akif"));
        List<Integer> l = new ArrayList<>();
        for (String name : names) {
            l.add(name.length());
        }



 // compare the strings
        List<String> names2 = new ArrayList<>(Arrays.asList("melih", "metin", "aybetul", "akif"));
      names.sort(Comparator.comparing(str->str.substring(1,2)));  // according to second  char
       names.forEach(e-> System.out.println(e));


    }


        public static void moveAction(Moveable x){
            System.out.println("moving "+25 );
        }
}
