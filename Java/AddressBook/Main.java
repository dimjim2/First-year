package com.dimmy;
import java.io.*;
import java.util.*;
import java.util.Scanner;
public class Main {
    //Display method for the menu
    public static void display() {
        Console con = System.console();
        String str = "Please select an option  from this menu" + System.lineSeparator() +
                "---------------------------------" + System.lineSeparator() +
                "  1.  Display of all my contacts" + System.lineSeparator() +
                "  2.  Add a new contact" + System.lineSeparator() +
                "  3.  Search a contact based on a name" + System.lineSeparator() +
                "  4.  Search a contact based on the telephone number" + System.lineSeparator() +
                "  5.  Edit based on name" + System.lineSeparator() +
                "  6.  Delete based on a name" + System.lineSeparator() +
                "  7.  Exit from the application";
        System.out.println(str);
    }

    public static void main(String[] args) {
        //make a new user object
        User u1 = new User();
        System.out.println("Welcome user "+u1.name);
        //We make new Contact objects with constructor and added to the ArrayList
        Contact c1 = new Contact("Dimitris Dimitriou", "dimyjimy@gmail.com", 2108047942, "Papagou 24","family");
        Contact c2 = new Contact("Melina Vlachou", "melinavlachou@gmail.com", 2108073645, "Voula 12","friend");
        Contact c3=new  Contact("Giorgos Konstantinou","giorgoskonst@gmail.com",2134567778,"Athens 1234","colleague");
        u1.contacts.add(c1);
        u1.contacts.add(c2);
        u1.contacts.add(c3);
        System.out.println("Saved contacts already");
        u1.displayMyContacts();
        saveUser(u1, "s1.dat");
        boolean ok = true;

        while (ok) {
            display();
            int answ = inputInt();
            //We consider that the input is integer and between 1-7
            while(answ<=0|| answ>7) {
                System.out.println("Your ,must choose from 1-7" );
                 answ = inputInt();
            }
            //We use switch structure to make the menu and call the methods needed
                switch (answ) {
                    case 1:
                        u1.displayMyContacts();
                        break;
                    case 2:
                        u1.addContact(u1);
                        saveUser(u1, "s1.dat");
                        break;
                    case 3:
                        u1.searchByTheName(u1);
                        break;
                    case 4:
                        u1.searchByTelephone(u1);
                        break;
                    case 5:
                        boolean k=u1.editBasedOnTheName(u1);
                        if (k) {
                            saveUser(u1, "s1.dat");
                        }
                        break;
                    case 6:
                        boolean f=u1.delete(u1);
                        if (f){
                            saveUser(u1,"s1.dat");
                        }
                        else{
                            System.out.println("The method delete was failed");
                        }
                        break;
                    case 7:
                        System.out.println("Now you exit from the address book application "+u1.name);
                        ok=false;
                        break;
                }
            }
        }
    //Important to save User changes about his contacts.We consider exceptions
    static void saveUser(User s, String filename) {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("User data has been saved!");
    }
    //Input method for ints that helps avoid exceptions
    public static int inputInt()
    {
        Scanner in=new Scanner(System.in);
        while (true)
        {
            try
            {
                return in.nextInt();
            }
            catch (InputMismatchException e)
            {
                in.next();
                System.out.print("That’s not "
                        + "an integer. Try again: ");
            }
        }
    }
}