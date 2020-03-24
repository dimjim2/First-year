package com.dimmy;

public class SoftwareEngineer extends Human implements Work{
    String favoriteLaguage;
    int yearsProgramming;
    public void writeCode(String language){
        System.out.println("I am now writing code in "+language);
    }
    public void work(){
        System.out.println("I am working as a Software Engineer");
    }
    public SoftwareEngineer(int age,long phoneNumber,float weight,String name){
        this.age=age;
        this.phoneNumber=phoneNumber;
        this.weight=weight;
        this.name=name;

    }
}
