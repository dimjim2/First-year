package com.dimmy;
import java.util.*;
import java.io.Serializable;
import java.util.regex.Pattern;

public class User implements Serializable {
    //We use a constructor for the User
    public User() {
        String name1 = null;
        while (name1 == null || (name1.trim().isEmpty())) {
            System.out.println("Give me your name");
            name1 = inputString();
            this.name = name1;
        }
    }

    String name;
    //We make a an ArrayList for the contacts
    //Else put the keyword static static
     List<Contact> contacts = new ArrayList<>();

    //Tis methods prints for each contact its attributes as name,email,telephone,address,group
    void displayMyContacts() {
        for (Contact c :
                contacts) {
            System.out.println(c.name + "," + c.email + "," + c.telephone_number + "," + c.address + "," + c.group);
        }
        System.out.println("******");
    }

    //This method makes a new contacts and add it to the ArrayList of the user that we have made
    public static void addContact(User s) {
        System.out.println("Give me your name");
        String name1 = setTheString();
        System.out.println("Enter your email");
        String email1 = setTheEmail();
        System.out.println("Give me your address");
        String addr1 = setTheString();
        System.out.println("Enter your telephone");
        long tel1 = setTelephone();
        System.out.println("Enter if you are friend,family or a colleague");
        String group1 = setGroup();
        Contact someone = new Contact(name1, email1, tel1, addr1, group1);
        s.contacts.add(someone);
    }

    //This method searches based on a name that a user gave the contact and then prints it
    //if it the name that the user gave does not exist prints a message
    public static void searchByTheName(User s) {
        System.out.println("Give me the name you want to search");
        String name5 = setTheString();
        boolean F1 = false;
        for (Contact c :
                 s.contacts) {
            if (c.name.equals(name5)) {
                System.out.println(c.name + "," + c.email + "," + c.telephone_number + "," + c.address + "," + c.group);
                F1 = true;
            }
        }
        if (F1) {
            System.out.println("Found by the name");
        } else {
            System.out.println("The name you gave does not correspond to a name of a contact");
        }
    }

    // This method searches based on a telephone number  that a user gave the contact and then prints t
    //if the telephone number that the user does not exists prints a message
    public static void searchByTelephone(User s) {
        System.out.println("Give me the telephone number you want to search");
        long tel = setTelephone();
        boolean F2;
        F2 = false;
        for (Contact c :
                s.contacts) {
            if (c.telephone_number == tel) {
                System.out.println(c.name + "," + c.email + "," + c.telephone_number + "," + c.address + "," + c.group);
                F2 = true;
            }
        }
        if (F2) {
            System.out.println("Found by the name");
        } else {
            System.out.println("Not found");
        }
    }

    /*We make a boolean method.If it returns true means that the name that user  gave  was correct (exists in contacts)
    and the system must apply the user changes  about his contacts.Also we print similar methods
     */
    public static Boolean editBasedOnTheName(User u) {
        boolean F3 = false;
        System.out.println("Give me the name based on him you want to edit his elements");
        String name_change = setTheString();
        for (Contact c :
                u.contacts) {
            if (c.name.equals(name_change)) {
                System.out.println("Give me the new name of the contact(It is not obligatory to change  if you want!!!)");
                String new_name = setTheString();
                c.name = new_name;
                System.out.println("Give me the email of the new contact(It is not obligatory to change if you want!!!) ");
                String new_email = setTheEmail();
                c.email = new_email;
                System.out.println("Give me the address of the new contact(It is not obligatory to change if you want!!!) ");
                String new_address = setTheString();
                c.address = new_address;
                System.out.println("Give me the telephone number of the new contact(It is not obligatory to change if you want!!!)");
                long new_phone = setTelephone();
                c.telephone_number = new_phone;
                System.out.println("Give me the group of the new contact(It is not obligatory to change if you want!!!)");
                String new_group = setGroup();
                c.group = new_group;
                F3 = true;
            }
        }
        if (F3) {
            System.out.println("The name based of the contact you searched in order to be edited was found");
        } else {
            System.out.println("The name you want to edit does not exist in the address book of the user ");
        }
        return F3;
    }

    /*Tis method deletes based on a name a contact of the user.We use iterators in order to avoid possible
    exceptions and remove method to delete the contact
    */
    public static boolean delete(User u) {
        boolean del=false;
        String del_name=setTheString();
        for (Iterator<Contact> iterator = u.contacts.iterator(); iterator.hasNext(); ) {
            Contact contact = iterator.next();
            if (contact.name.equals(del_name)) {
                iterator.remove();
                del = true;
            }
        }
        return del;
    }

    //This method helps deal with exceptions for long numbers.It is used for user input long numbers
    public static long inputLong() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                return sc.nextLong();
            } catch (InputMismatchException e) {
                sc.next();
                System.out.println("You did not gave an long.Try again!!!");
            }
        }
    }

    //This method helps deal with exception with Strings.It is useful for user input strings(except  group)
    public  static String inputString() {
        Scanner a = new Scanner(System.in);
        while (true) {
            try {
                return a.nextLine();
            } catch (InputMismatchException e) {
                a.next();
                System.out.println("You did not give a string ");
            }
        }
    }

    /*It is a special method for user input  group attributes.
     It calls also inside of his body the inputString() method.It certifies that the possible
      group data are only  friend,colleague or family
     */
    public static String setGroup() {
        boolean ok = true;
        String group1 = null;
        while (ok) {
            group1 = inputString();
            if (group1.equals("friend") || group1.equals("family") || group1.equals("colleague")) {
                ok = false;
            } else {
                System.out.println("Wrong data");
            }
        }
        return group1;
    }

    /*Method for setting the input for the name
    and the address of user.Examines the null input of the user*/
    public static String setTheString() {
        String string = null;
        while (string == null || (string.trim().isEmpty())) {
            string = inputString();
        }
        return string;
    }

    /*Method for setting the input for the email
     of user.Examines the null input of the user
     and if it is valid the email*/
    public static String setTheEmail() {
        String email1 = null;
        boolean F3 = false;
        while ((email1 == null || (email1.trim().isEmpty())) || F3 == false) {
            email1 = inputString();
            boolean k = isValid(email1);
            if (k) {
                F3 = true;
            } else {
                System.out.println("Wrong data");
            }
        }

        return email1;
    }

    //method checks if the email is valid using a regex
    public static boolean isValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
    //method for the telephone.Only 10 digits and long number
    public static long setTelephone() {
        long telephone;
        telephone = inputLong();
        String strLong = Long.toString(telephone);
        int k = strLong.length();
        while (k!=10){
            System.out.println("Only 10 digits for telephone");
            telephone = inputLong();
            strLong = Long.toString(telephone);
            k = strLong.length();
        }
        return telephone;
    }
}