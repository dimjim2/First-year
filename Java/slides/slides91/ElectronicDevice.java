package com.dimmy;

import static java.lang.StrictMath.abs;

public class ElectronicDevice {
    static String type="device";//Class variable
    final static String using_type="Energy";//Class variable
    double inch,batteryRemaining;//instance variable
    String brand;//instance variable
    public void charge(double batterylife/*method parameter */){
        System.out.println("The battery is now charging");
        double battery=abs(batterylife-batteryRemaining);//local variable
        System.out.println("Battery to must be filled is " + battery);

    }
    ElectronicDevice(double inch,String brand,double batteryRemaining){
        this.inch=inch;
        this.batteryRemaining=batteryRemaining;
        this.brand=brand;
    }
    void information(){
        System.out.println("Type: " + type + " brand:" + brand + " using type: "+ using_type + " inch:" + inch +
                " battery life remaining: "+ batteryRemaining);
    }
}
