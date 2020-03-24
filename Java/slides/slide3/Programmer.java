package com.dimmy;

public class Programmer {
    int age,yearsWorking;
    String name;
    float weight;
    public Programmer(int age,int years,String name,float weight){
        this.age=age;
        this.yearsWorking=years;
        this.name=name;
        this.weight=weight;
    }
    public void writeCode(String language){
        System.out.println("I am writing code in "+language);
    }
    public void information(){
        System.out.println("Name "+ name + " age "+ age + " years working "+ yearsWorking + " weight " +weight);
    }
}
