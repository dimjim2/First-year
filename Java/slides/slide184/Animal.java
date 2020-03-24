package com.dimmy;

public class Animal {
    String species;
    String name;
    String color;
    float population;
    int age;

    public void Eat(String name,String Food){
        System.out.println("Every " +name+ " must eat " +Food+ " in order to survive");
    }
    final public void smell(){
        System.out.println("The  is smelling something");
    }
}
