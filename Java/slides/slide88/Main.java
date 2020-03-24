package com.dimmy;

public class Main {
    public static void main(String ... args){
        Animal.feed();//no need to make a an object
        Animal a=new Animal();
        a.scream();
        Animal b=null;
        b.scream();//Accepted but not
        System.out.println("height of an animal"+Animal.height);
    }
}
