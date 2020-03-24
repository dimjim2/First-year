package com.dimmy;

public class Main {
    public static void main(String...args){
        //Widening
        int i = 100;
        //automatic type conversion
        long lo =i;
        double d1=lo;
        System.out.println(lo);
        System.out.println(d1);
        //Narrowing
        long myLong = 9;
        int myInt = (int) myLong;
        char a='c';
        short s=(short) a;
        System.out.println(myLong);
        System.out.println(a);
        System.out.println(myInt);
        System.out.println(s);//Unpredicted but true
        //Upcasting
        Dog d=new Dog("Max","Lamprador","black",1500,8);
        //override subclass
        d.smell();
        Animal animal= d;
        animal.Eat("domestic dog","bones");
        animal.smell();
        Animal a1=new Dog("Mark","Unknown","white",2000,10);
        System.out.println(a1 instanceof Dog);
        System.out.println(a1 instanceof Animal);
        //Downcasting
        ((Dog)a1).sound();
    }
}
