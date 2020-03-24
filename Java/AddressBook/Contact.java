package com.dimmy;
import java.io.Serializable;
public class Contact implements Serializable  {
    //instance variable
    String name;
    String email;
    long telephone_number;
    String address;
    String group;
    //constructor for the Contact class
    public Contact(String your_name, String your_email,long your_telephone_number,String your_adress,String your_group) {
        this.name= your_name;
        this.email =your_email;
        this.telephone_number=your_telephone_number;
        this.address=your_adress;
        this.group=your_group;

    }
}