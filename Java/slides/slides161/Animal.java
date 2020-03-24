package com.dimmy;

public abstract class Animal {
    String species;
    String name;
    String color;
    float population;
    int age;
    public void Living_Environment(){
        System.out.println("I am living somewhere!!!");
    }
    public void Eat(String name,String Food){
        System.out.println("Every " +name+ " must eat " +Food+ " in order to survive");
    }

}
