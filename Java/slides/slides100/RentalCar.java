package com.dimmy;

public class RentalCar extends Vehicle implements run{
    int number_of_days_for_rental;
    double rate_per_day;
     public RentalCar(int num,double rate,String brand,double fuels){
        this.number_of_days_for_rental=num;
        this.rate_per_day=rate;
        this.brand=brand;
        this.fuels=fuels;
        price();
    }
    public void price()
    {
        price =number_of_days_for_rental*rate_per_day;
    }
    public void run(){
         System.out.println("I am now running");
    }
}
