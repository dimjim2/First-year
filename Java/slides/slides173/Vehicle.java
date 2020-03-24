package com.dimmy;

public class Vehicle {
    String brand;
    float energy_consumption;
    double price;
    public void move(){
        System.out.println("A vehicle can either fly,drive in the ground,or dive beneath the surface");
    }
    protected void consume(int rate){
        float consumption=energy_consumption*rate;
        System.out.println("Evey vehicle consumes his own type of energy "+consumption);
    }
     public final void information(){
        System.out.println("Vehicle "+ brand + " energy consumption "+ energy_consumption);
    }
    private double price()
    {
        return price;
    }
    public Vehicle(){
        this.brand="BMW";
        this.energy_consumption=123;
        this.price=1200;
    }
    public Vehicle(String brand,float energy_consumption,double price){
        this.brand=brand;
        this.energy_consumption=energy_consumption;
        this.price=price;
    }
    public static void sound(){
        System.out.println("Sound from the vehicle");
    }
}
