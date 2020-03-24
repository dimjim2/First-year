package com.dimmy;

public class Programmer {
    int age;
    private String name;
    public void favoriteLanguage(String language){
        System.out.println("I am programming in "+ language);
    }
    public Programmer(){
        this.age=30;
        this.name="Helena";
    }
}
