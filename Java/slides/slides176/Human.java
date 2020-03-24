package com.dimmy;

public class Human {
    int age;
    String name;
    long phoneNumber;
    double weight;
    public Human(){
       this.age=25;
       this.phoneNumber=2108047942;
       this.weight=65.5;
       this.name="Marios";

    }
    void information(){
        System.out.println("Age "+age+" phone number "+phoneNumber+" weight"+weight +" name "+name);
    }

}
