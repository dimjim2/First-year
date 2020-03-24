package com.dimmy;

public class Main {
    public static void main(String[] args) {
        Employee em = new Employee(43,"dimitra",1234);
        //Be careful that a vararg is the last parameter
        Employee.calculateMoney(16);//Not a vararg
        em.calculateMoney(6,400,300,1000);//instance access static method
       int b =em.test("Melina",12,4,5,6,-2);
        em.information();
        System.out.println(b);
    }
}
