package com.dimmy;

public class Car extends Vehicle {
    float horsePower;
    public Car(String brand,float cons,double price,float horsePower){
        this.brand=brand;
        this.energy_consumption=cons;
        this.price=price;
        this.horsePower=horsePower;
    }
    public void move(){
        System.out.println("I am driving in the ground");
    }
    /*The access modifier for an overriding method can allow more, but not less, access than the overridden method.
    Super class method consume is protected and the subclass can made public but not private
     */
    public void consume(int rate){
        float consumption=energy_consumption*rate;
        System.out.println("Evey car consumes a certain number of fuel "+consumption);
    }
    //Error a final method cannot be overwritten
    /*public void information(){

    }
     */
    //A method like this because it is private from the super class cannot be overwritten at all
     private double price(){
         return price;
     }
    public static void sound(){
        System.out.println("Sound from the Car");
    }
}
