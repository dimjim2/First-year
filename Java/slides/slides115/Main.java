package com.dimmy;

public class Main {
    public static void main(String...args){
        Test t=new Test(5,10);
       float b= t.add();
       System.out.println("Grade "+ b + " Name "+t.name + " age " + t.age);
    }
}
