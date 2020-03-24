package com.dimmy;

public class Vehicle {
    String brand;
    double fuels,price;
    public Vehicle(String brand,double fuels, double v_price)
    {
        this.brand=brand;
        this.fuels=fuels;
        this.price=v_price;
    }
    public Vehicle(){
        this.brand="BMW";
        this.price=10000;
        this.fuels=4000;
    }
}
