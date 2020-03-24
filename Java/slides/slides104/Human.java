package com.dimmy;

public class Human {
    int age;
    static String name;
    double height;
    public Human(){
        this.name="Dimitris";
        this.age=19;
        this.height=1.70;
    }
    void run(String place,double time){
        System.out.println("I am running in "+place +" in total time " +time);
    }
    void eat(String food){
        System.out.println("I am eating " +food );
    }
}
