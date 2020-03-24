package com.dimmy;

public class Bat extends Animal {
    double diamWings;
    public final void Fly(){
        System.out.println("Also it can fly");

    }
    public void Living_Environment(){
        System.out.println("A bat can live in caves");
    }
    public int  Life_of_bat(int age){
        int expectation;
        if(age>30){
            System.out.println("Over the life estimation");
            expectation=0;
        }
        else{
            System.out.println("The life estimation is 30 year");
            System.out.println("Remains");
            expectation=30-age;
        }
        return expectation;
    }
    public void informations(int a){
        System.out.println("A bat is a mammal and so it  has a fury and has the" +
                " attribute to have his teeth one time replaced");
        if (a>=65) {
            System.out.println("The metabolism rate  of the bat is " + a + " % and normal");
        }
        else{
            System.out.println("The metabolism of bat is not normal.Needs help!!!");
        }

    }
    public Bat(String name,String species,String color,float population,int age,double diamWings){
        this.name =name;
        this.species=species;
        this.color=color;
        this.population=population;
        this.age=age;
        this.diamWings=diamWings;
    }
    public void bat_sound(){
        System.out.println("A bat by producing scrams and listening to echoes can communicate with other bats");
    }
}
