package com.automation.tests.SelfPractice.LambdaIntro;
// Functional Interface
interface  Calculator{
    void add(int num1, int num2);
}

class CalC{
    public static void addSomething(int num1, int num2){
        System.out.println("num1+ num2 ="+(num1+num2));
    }
    public void letsAdd(int num1, int num2){
        System.out.println("num1+ num2 ="+(num1+num2));
    }
}
// Functional Interface
interface Messenger{
 Message getMessage(String mess);
}

class Message{
    Message(String mess){
        System.out.println("-> message is "+mess);
    }
        }

public class LambdaReferenceMethods {


    public static void main(String[] args) {
      //  CalC.addSomething(10,20);

        // 1. Reference to static method
      //  Calculator cRef= CalC::addSomething; // Method reference
        //    cRef.add(10,20);


      //  2.Reference to non static method or Instance Method
        CalC call= new CalC();
        Calculator cRef= call::letsAdd; // Method reference
        cRef.add(10,20); // it adapt another method like its own


      // 3. Reference to Constructor
      Messenger mReg= Message::new;
      mReg.getMessage("Hi There!!"); //-> message is Hi There!! (message+ constructor)

      //======================================================







    }
}
