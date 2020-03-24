package com.dimmy;
public class Animal {
    int age;//not static
    static double height=1.5;
    static int population;
    int number=500;
    public void fly(){
        System.out.println("I am flying like a bird!!!");
    }
    //belongs to the class
    public  static void feed(){
        String food="plant";//local variable
        //System.out.println("the age of the animal is "+ age);
        System.out.println("the height of the animal is "+ height);
       System.out.println("I am eating "+ food);
      // fly(); not static method being called from a static method
        //population=population+number;
        population=population+500;
        System.out.println("Population" + population);
    }
    public void scream(){
        feed();//Non static function calls a static function
        number=number+population;//non static variables have an access to a static variable
        age+=1;
        fly();//access to a non static variable
    }
}
