package com.dimmy;

public class Main {
    public static void main(String...args){
        Vehicle v1=new Vehicle("Audi",12.333,20.0000);
        Vehicle v2=new Vehicle();
        v1.drive("Athens");
        v2.drive("New York");
        //Car c=new Car(); Wrong!!
        Car c=new Car(12,0.5,"Jeep",2200);
        c.display();
        c.price();
    }
}
