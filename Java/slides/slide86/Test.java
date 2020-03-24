package com.dimmy;

public class Test {
    static int data=30;
    static String message="You are the best";
    public static class Exercice implements Solve{
        public void display() {
            System.out.println("Hi to all guys!");
            System.out.println("Can access properties of outer class as : "+ data);
        }
        static void solve(){
            System.out.println("I am solving an exercise");
        };
        // static class
        public void printMessage() {

            System.out.println("Message from nested static class: " + message);
        }
    }
}
