package com.dimmy;

public class Vehicle {
    String brand;
    double price,fuels;
    public Vehicle(String brand,double fuels, double v_price)
    {
        this.brand=brand;
        this.fuels=fuels;
        this.price=v_price;
    }
    protected Vehicle(){
        this.brand="BMW";
        this.price=10000;
        this.fuels=4000;
    }
    void drive(String place){
        System.out.println("I am now driving in "+place);
    }
}
