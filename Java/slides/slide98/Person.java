package com.dimmy;

import java.util.Scanner;

public class Person {
    int age;
    String name,profession;
    double weight,salary;
    public Person(int age,String name,String profession,double weight,double salary){
        this.age=age;
        this.weight=weight;
        this.profession=profession;
        this.name=name;
        this.salary=salary;
    }
    public String informations(){
        return "Age"+age + "name" + name + "profession" + profession + "name " +name ;
    }
    //Void not necessary return statement
    public void calculate(){
        if (salary>=1500){
            System.out.println("Excellent");
        }
        else if (salary>=1000){
            System.out.println("Very good");
        }
        else{
            System.out.println("Good");
        }
    }
    public void guessMyName(){
        int i=0;
        Scanner obj=new Scanner(System.in);
        System.out.println("Give me a name to match");
        String name1=obj.nextLine();
        while(!name.equals(name1)) {
            System.out.println("No that its not my name");
            System.out.println("Give me again ");
            name1=obj.nextLine();
            i += 1;
        }
        System.out.println("You actually found it with the "+ (i+1) + "th attemp");
        return;
    }
    public void chose(){
        Scanner sc=new Scanner(System.in);
        int day;
        do {
            System.out.println("Give the number of a day 1-7");
            day = sc.nextInt();
        }while (day<=0 || day>8);
        switch (day) {
            case 1:
                System.out.println(" Today is Monday");
                return;
            case 2:
                System.out.println("Today is Tuesday");
                return;
            case 3:
                System.out.println("Today is Wednesday");
                return;
            case 4:
                System.out.println("Today is Thursday");
                return;
            case 5:
                System.out.println("Today is Friday");
                return;
            case 6:
                System.out.println("Today is Saturday");
                return;
            case 7:
                System.out.println("Today is Sunday");
                return;
        }
    }

}
