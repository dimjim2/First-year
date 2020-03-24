package com.dimmy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

public class Student {
    private int age;
    private String name;
    ArrayList<String>fv=new ArrayList<>();
    void lesson() {
        Scanner sc=new Scanner(System.in);
        for (int i=0; i <5 ;i++){
            System.out.println("Give me your favorite lesson");
           fv.add(sc.nextLine());
        }
        for (String l:fv){
            System.out.println(l);
        }
    }
    void delete(String s) {
        Iterator i = fv.iterator();
        String str = "";
        while (i.hasNext()) {
            str = (String) i.next();
            if (s.equals(str)) {
                i.remove();
            }
        }
    }
    void display(){
        for (String l : fv) {
            System.out.println(l);
        }
    }
    static Student getStudent(){
        return new Student();
    }
    public Student() {
        this.age=25;
        this.name="Marios";

    }
    public void exam(){
        System.out.println("Tomorrow i am sitting an exam");
    }
}
