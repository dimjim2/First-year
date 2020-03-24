package com.dimmy;

public class Main {
    public static void main(String args[]){
        Vehicle v=new Vehicle();
        v.consume(2);
       // v.price(); Is private it cannot be called from an another class
        v.move();
        v.information();
        Car c=new Car("Audi",1345,20000,180);
        c.consume(3);
        c.move();
        c.sound();
        Vehicle v1=new Car("Toyota",1222,2111,120);
        /*if there are methods present in super class, but overridden by subclass, and if object
        of subclass is created, then whatever reference we use(either
        subclass or superclass), it will always be the overridden method in subclass that will be executed
         */
        v1.move();
        //Staticmethod is not consider overriding !!!
        v1.sound();
        v1.information();

    }
}
