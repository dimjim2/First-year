package com.dimmy;
//constructor not member of a class
public class Car extends Vehicle {
    int number_of_days_for_rental;
    double rate_per_day;
     Car(int num,double rate,String brand,double fuels){
        this.number_of_days_for_rental=num;
        this.rate_per_day=rate;
        this.brand=brand;
        this.fuels=fuels;
    }
    private Car(){
         super("Opel",3300,1500);//Calls Vehicle constructor
         this.number_of_days_for_rental=5;
         this.rate_per_day=0.5;
         this.brand="Toyota";
         this.fuels=3200;

     }
     void display(){
         System.out.println("Numbers of day "+number_of_days_for_rental+" rate_per_day "+rate_per_day
                 +" brand "+brand+" fuels "+fuels );
     }
    public void price()
    {
        price =(number_of_days_for_rental*rate_per_day)*0.5+500;
        System.out.println(price);
    }
     public static void main(String... args){
         Car c=new Car();
         c.display();
         c.price();
     }
}
