package com.dimmy;

public class Employer extends Human implements Work{
    double funds;
    int teamsize;
    void reportWork(){
        System.out.println("I am now supervising the work");
    }
    void hire(int people){
        System.out.println("I want to hire "+people);
    }
   public void work(){
       System.out.println("I am working as an employer");
    }
    void information(){
        System.out.println("Age "+age+" phone number "+phoneNumber+" weight"+weight +" name "+name +" funds " + funds);
    }
    public Employer(int age,long phoneNumber,float weight,String name,float funds){
        this.age=age;
        this.phoneNumber=phoneNumber;
        this.weight=weight;
        this.name=name;
        this.funds=funds;

    }
}
