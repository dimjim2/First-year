package com.dimmy;

public class Main {
    public static void main(String[] args){
        Programmer p1=new Programmer(){
            @Override
            public void favoriteLanguage(String language){
                System.out.println("I am programming in my favorite language "+ language);
                }
        };
        p1.favoriteLanguage("Java");
        System.out.println(p1.age);
        //Not obligatory to override a method
        new Manager(){
            @Override
            void supervise(){
                System.out.println("I am the head manager of the project and i am very happy for this");
            }
        }.supervise();
        System.out.println(new Manager().name);//Using new without a variable
    }
}
