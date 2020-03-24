package com.dimmy;

public class Main {
    public static void main(String... args) {
        RentalCar c = new RentalCar(12, 0.7, "Toyota", 2450);
        System.out.println("Is c instance of Vehicle and interface run?");
        System.out.println(c instanceof Vehicle);
        System.out.println(c instanceof run);
        Vehicle v = new Vehicle();
        System.out.println("Is v instance of RentalCar");
        System.out.println(v instanceof RentalCar);
        Vehicle v1 = new RentalCar(6, 0.5, "Peugeot", 1000);
        //Vehicle hold its own and child and RentalCar reference
        if (v1 instanceof RentalCar) {
            System.out.println("v1 is instance of RentalCar");
        } else {
            System.out.println("v1 is NOT instance of RentalCar");
        }
        Vehicle v2 =v1;
        if (v2 instanceof RentalCar && v2 instanceof run) {
            System.out.println("v2 is instance of RentalCar");
            System.out.println(((RentalCar)v2).number_of_days_for_rental);
        } else {
            System.out.println("v2 is NOT instance of RentalCar");
        }
    }
}