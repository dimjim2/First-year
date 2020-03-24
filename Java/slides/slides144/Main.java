package com.dimmy;

import java.util.Scanner;

public class Main {
    public static void main(String...args) {
        //Top ten box office movies until now
        System.out.println("Give me a number 1-10");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        //switch with integer
        switch (number) {
            case 1:
                System.out.println("Avatar");
                break;
            case 2:
                System.out.println("Avengers : Endgame");
                break;
            case 3:
                System.out.println("Titanic");
                break;
            case 4:
                System.out.println("Star Wars the force Awakens");
                break;
            case 5:
                System.out.println("Avengers:Infinity War");
                break;
            case 6:
                System.out.println("Jurassic World");
                break;
            case 7:
                System.out.println("Avengers");
                break;
            case 8:
                System.out.println("Furious 7");
                break;
            case 9:
                System.out.println("Avengers:Age of Ultron");
                break;
            case 10:
                System.out.println("Black Panther");
                break;
            default:
                System.out.println("Something went wrong");
                break;

        }
        // A switch works with the byte, short, char, and int primitive data types.Also switch may
        // be faster than if else when they are many multiple choices
        System.out.println("Give me a direction");
        char direction= sc.next().charAt(0);
        //boolean condition
        if( direction == 'E' )
            System.out.println("East");
        else if( direction == 'W' )
            System.out.println("West");
        else if( direction == 'S' )
            System.out.println("South");
        else if( direction == 'N' )
            System.out.println("North");
        else
            System.out.println("Unknown direction");
        //If else direction is char object
        switch( direction )
        {
            case 'E':
                System.out.println("East");
                break;
            case 'W':
                System.out.println("West");
                break;
            case 'S':
                System.out.println("South");
                break;
            case 'N':
                System.out.println("North");
                break;
            default:
                System.out.println("Unknown direction");
                break;
        }
    }
}
