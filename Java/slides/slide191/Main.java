package com.dimmy;

public class Main{
    public static void main(String... args) {
        //Anonymous classes are inner classes
        //Now we make an anonymous class by implementing an existing interface
        new Smell() {
            public void smell() {
                System.out.println("I am smelling something good");
            }
        }.smell();
        Eat e = new Eat() {
            @Override
            public void eat(String food, String name) {
                System.out.println(name + " is  eating a "+ food);
            }
        };
        e.eat("Burger","Maria");
    }
}
