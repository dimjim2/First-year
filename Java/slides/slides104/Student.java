package com.dimmy;


public class Student extends Human{
    int id;
    String department;
    String name;
    Student(int age){
        this.age=age;
    }
    Student(String name,int id,String department,int age){
        //super(); Call Human constructor
        // this.age=age;
       this(age);
        this.name=name;
        this.id=id;
        this.department=department;
    }
    //in a static method instance members,this and super cannot be accessed
    /*
    static void information_parent(){
        // referring parent class(i.e, class Human)
        // instance variable(i.e, a)
        System.out.println("Your name is "+ super.name);
        System.out.println("Your height " + super.height);
        System.out.println("Your name is "+name + "id " + this.id + " you study in the department "+ this.department+"age "+age);
        super.run("Athens",55.06);
    }
     */
     void information(){
        // referring parent class(i.e, class Human)
        // instance variable(i.e, a)
        System.out.println("Your name is "+ super.name);
        System.out.println("Your height " + super.height);
        System.out.println("Your name is "+name + " id " + this.id + " you study in the department "+ this.department+" age "+age);
        super.run("Athens",55.06);
    }
}
