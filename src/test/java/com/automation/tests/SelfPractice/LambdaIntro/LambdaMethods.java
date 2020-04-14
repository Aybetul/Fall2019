package com.automation.tests.SelfPractice.LambdaIntro;
import java.util.*;

public class LambdaMethods {

    public static void main(String[] args) {
        List<Integer> nums= Arrays.asList(5,7,8,6,2,1,49);

        System.out.println("-------non lambda-------");
        Integer min=null;
        Integer max=null;
        Integer sum=0;
for(Integer i: nums){
    if(max==null) {
        max = i;
        min = i;
    }else if(max<i){
        max=i;}
    else if(min>i){
        min=i;
    }
    sum+=i;
}
float average=(float) sum/nums.size();
        System.out.println("Max="+max);
        System.out.println("Min=" + min);
        System.out.println("average=" + average);
        System.out.println("sum = " + sum);


        System.out.println("-------non lambda-------");

        IntSummaryStatistics stats= nums.stream().mapToInt(x->x).summaryStatistics();
        System.out.println("Max="+stats.getMax());
        System.out.println("Min=" + stats.getMin());
        System.out.println("average=" + stats.getAverage());
        System.out.println("sum = " + stats.getSum());

//=========================================================================
        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);

        items.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));

        items.forEach((k,v)->{
            System.out.println("Item : " + k + " Count : " + v);
            if("E".equals(k)){
                System.out.println("Hello E");
            }
        });
//======================================================================
        Map<String, Integer> items2 = new HashMap<>();
        items2.put("A", 10);
        items2.put("B", 20);
        items2.put("C", 30);
        items2.put("D", 40);
        items2.put("E", 50);
        items2.put("F", 60);

        for (Map.Entry<String, Integer> entry : items2.entrySet()) {
            System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
        }
//==============================================================
        List<String> items3 = new ArrayList<>();
        items3.add("A");
        items3.add("B");
        items3.add("C");
        items3.add("D");
        items3.add("E");

        //lambda
        //Output : A,B,C,D,E
        items3.forEach(item->System.out.println(item));

        //Output : C
        items3.forEach(item->{
            if("C".equals(item)){
                System.out.println(item);
            }
        });
        //remove E

        items3.removeIf(e-> "E".equals(e));
        System.out.println(items3);


        //method reference
        //Output : A,B,C,D,E
        items3.forEach(System.out::println);

        //Stream and filter
        //Output : B
        items3.stream()
                .filter(s->s.contains("B"))
                .forEach(System.out::println);

//https://mkyong.com/java8/java-8-foreach-examples/  // reference website



    }
}
