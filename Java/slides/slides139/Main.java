package com.dimmy;

import java.util.Scanner;

public class Main {
    public static void main(String...args){
         Scanner sc=new Scanner(System.in);
         System.out.println("Give me salary");
        float money= sc.nextFloat();
        String message=(money >1500)?"Very good salary.Congrats":(money>1000)?"Good salary":"Mediocre salary";
        System.out.println(message);
        int year;
        Scanner obj=new Scanner(System.in);
        do{
            System.out.println("Give me a year");
            year=obj.nextInt();
        }while (((Integer.toString(year)).length())!=4);
        String message1=((year%4==0 && year%100!=0)||year%400==0)?"Leap year":"Not leap year";
        System.out.println(message1);
    }
}
