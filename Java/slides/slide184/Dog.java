package com.dimmy;

public class Dog extends Animal {
    public Dog(String name,String species,String color,float population,int age){
        this.name=name;
        this.species=species;
        this.color=color;
        this.population=population;
        this.age=age;
    }
    public void sound(){
        System.out.println("A dog barks");
    }
    public void Eat(String name,String Food){
        System.out.println("Every dog " +name+ " must eat " +Food+ " in order to survive");
    }

}
