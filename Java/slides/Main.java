package com.dimmy;

public class Main {
    public static void main(String...args){
        StringBuilder sb=new StringBuilder("Programmer ");
        sb.append(" Junior ");//now original string is changed
        System.out.println(sb);//prints Programmer Junior
        StringBuilder sb1=new StringBuilder(" Oriented Programming");
        sb1.insert(0,"Object");//now original string is changed
        System.out.println(sb1.toString());//prints Object Oriented Programming

        sb.replace(8,11,"ing");
        System.out.println(sb);//Programming Junior
        StringBuilder sb2=new StringBuilder(sb1);
        sb.delete(2,5);
        System.out.println(sb);//prints Pramming Junior
        sb1.reverse();
        System.out.println(sb1);//prints Programming Oriented
        //Constructs a string builder with no characters in it and an initial capacity of 16 characters.
        StringBuilder sb3=new StringBuilder();
        System.out.println(sb3.capacity());//default 16
        sb3.append("Hello");
        System.out.println(sb3.capacity());//now 16

        StringBuilder sb4=new StringBuilder(6);
        System.out.println(sb4.capacity());//6
        sb4.append("Dimitris");
        System.out.println(sb4.capacity());//(old capacity*2)+2
        System.out.println(sb4);
        StringBuilder str = new StringBuilder(10);
        System.out.println(str.capacity());
        //Int his constructor we initialize default 16 + length
        StringBuilder str1 = new StringBuilder("AAAABBBCCCC");//11 length
        // print string
        System.out.println("String1 = "
                + str1.toString());
        System.out.println(str1.capacity());
    }
}
