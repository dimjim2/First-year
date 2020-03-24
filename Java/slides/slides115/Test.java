package com.dimmy;

public class Test {
    String name;
    int first,sec,age;
    {
        System.out.println("Instance initializer");
        this.name="Giorgos";
    }
    {
        System.out.println("Second initializer block");
        this.age=23;
    }
    //constructor
    public Test(int a,int b) {
        System.out.println("constructor called");
        this.first=a;
        this.sec=b;
    }
    float add(){
        int sum=first+sec;
        return (float)sum/2;
    }
}
