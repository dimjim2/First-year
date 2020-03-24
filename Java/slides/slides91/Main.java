package com.dimmy;

public class Main {
    public static void main(String ... args){
        ElectronicDevice obj=new ElectronicDevice(13.3,"Samsung",14.666);
        obj.charge(3557);
       System.out.println(ElectronicDevice.type);
      // ElectronicDevice.using_type="Wind"; it is final static
        System.out.println(ElectronicDevice.using_type);
        obj.information();
    }
}
