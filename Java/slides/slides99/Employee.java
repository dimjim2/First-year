package com.dimmy;

public class Employee {
    int age;
    double salary;
    static double bonus;
    String name;

    public Employee() {
        this.age = 20;
        this.bonus = 0;
        this.name = "Melina";
        this.salary = 1000;
    }

    public Employee(int age, String name, double salary) {
        this.age = age;
        this.bonus = 0;
        this.name = name;
        this.salary = salary;
    }

    //varargs extra bonus
    public static void calculateMoney(int working_age, double... args) {
        for (double x : args) {
            bonus += x;
        }
        if (working_age >= 10) {
            bonus += bonus * 0.5;
        } else if (working_age >= 5) {
            bonus += bonus * 0.25;
        } else {
            bonus += bonus * 0.1;
        }
        System.out.println("Bonus calculated " + bonus);
    }

    public void information() {
        salary = salary + bonus;
        System.out.println("Name " + name + " age " + age + " salary " + salary);
    }

    //Not accepted
    /*public int test(int...args1 , String ... args){
        int sum=0;
       for(int x:args1){
            sum+=x;
    }
    for (String y:args){
        System.out.println("Summary is" +sum + "name" + y);
        }
     */
    public int test(String name, int... args) {
        int sum = 0;
        System.out.println("Name " + name);
        for (int x : args) {
            sum += x;
        }
        return sum;
    }
}
