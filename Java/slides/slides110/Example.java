package com.dimmy;

import java.util.Scanner;

public class Example {
    void myMethod(String name){
        int number;
        Scanner obj=new Scanner(System.in);
        do {
            System.out.println("Give me an integer");
            number =obj.nextInt();
        }while (number<=0);
        for(int i=0;i<number;i++){
            System.out.println("Hello" + name);
        }
    }
    //Different type parameter
    void myMethod(int number){
        for (int i=0;i<number;i++){
            System.out.println("Hello you");
        }
    }
    public int multiply(int a,int b,int c){
      int  mul=a*b*c;
      return mul;
    }
    /*
    protected int multiply(int a,int b,int c){
        int mul=a*b*c;
        return mul;
    }
     */
    //But this accepted
    protected int multiply(int a,int b){
        int mul=a*b;
        return mul;
    }
    public void swap(int a,int b){
        System.out.println("a " + a +" b " + b);
        int x;
        x=a;
        a=b;
        b=x;
        System.out.println("Swap a " + a + " b " +b);
    }
    /*Not accepted only different type
    public String swap(int a,int b){
        System.out.println("a"+a +"b"+b);
        int x;
        x=a;
        a=b;
        b=x;
        System.out.println("Swap a" + a + "b" +b);
    }
     */
    //Changing both return type and access
   /* protected String swap(int a,int b){
        System.out.println("a"+c +"b"+b);
        int x;
        x=a;
        a=b;
        b=x;
        return ("Swap a" + a + "b" +b);
    }
     */
}
