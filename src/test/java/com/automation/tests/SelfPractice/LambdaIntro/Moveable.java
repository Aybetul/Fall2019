package com.automation.tests.SelfPractice.LambdaIntro;
@FunctionalInterface
public interface Moveable {

   void move(int mile);

}

@FunctionalInterface
interface Measurable{
   void measure();
}


@FunctionalInterface
interface Computer{
   void compute(int num1, int num2);
}


@FunctionalInterface
interface Flyable{
   boolean flyHigh(int mile );
}




 // instead of creating this class we will create inner class in LambdaPractice class to make the code shorter
//class DistanceMover implements Moveable{
//
//    @Override
//    public void move(int mile) {
//        System.out.println("moving " + mile );
//    }
//}