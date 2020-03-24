package com.dimmy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Main {
    public static void main(String... args) {
        ArrayList<String> books = new ArrayList<>();
        books.add("Don Quixote");
        books.add("The Lord of the Rings");
        books.add("The Little Prince");
        books.add("The Da Vinci Code");
        books.add("The Alchemist");
        books.add("Hunger games");
        //Remove easy a known element
        books.remove("Hunger games");
        for (String b : books) {
            System.out.println(b);
        }
        System.out.println("----------");
        //remove method with enhanced for loop or iterator may result in ConcurrentModificationException
        // as the iterators returned by ArrayList class's iterator and ListIterator methods are fail-fast.
        /*for (String b : books) {
            if (b.equals("The Little Prince")) {
                books.remove(b);
            }
        }

         */

        //Modify and add are not supporting for each
        for (String each : books) {
            if (each.equals("The Da Vinci Code")) {
                books.set(books.indexOf(each),"Peter pan");
            }
        }

        //Now we will use iterator to remove an element
        //Notice that add method is not supported
        Iterator<String> itr = books.iterator();
        while (itr.hasNext()) {
            System.out.println("book " + itr.next());
           //itr.remove(); //delete all
        }
        //Modify using Iterator wont compile!!!
        /*
        while(itr.hasNext()) {
            String value = itr.next();

            if(value.equals("456")){
                books.add("999");
            }
        }
         */
        //Delete a specified book
        Iterator i = books.iterator();
        String str = "";
        /*while(i.hasNext()) {
            String value = (String) i.next();

            if (value.equals("456")) {
                books.add("999");
            }
        }
         */
        while (i.hasNext()) {
            str = (String) i.next();
            if (str.equals("The Little Prince")) {
                i.remove();
            }
        }
        //Using ListIterator to add,modify,delete method
        ListIterator<String> listIterator = books.listIterator();
        listIterator.next();
        listIterator.add("The woman in the window");;
        /*while (listIterator.hasNext()){
            String s = listIterator.next();
            listIterator.set(s.toUpperCase());
        }
         */

        //Modify the ArrayList working
        /*for(int v=0; v<books.size(); v++){
            String book = books.set(v,"Modify the arrayList");

        }

         */
        //delete method
        books.removeIf( book -> book.equals("The Alchemist"));
        for (String b : books) {
            System.out.println(b);
        }
        System.out.println("----------");
        //ArrayList's remove method can be used with normal for loop to remove an ArrayList in Java.
        // If index is passed then it may give undesired result because of the
        // fact that all the other elements are shifted to the left when an element is removed.
        for(int k = 0; k< books.size(); k++){
           if(k==3){
               books.remove(k);
           }
           if (books.get(k).equals("The Lord of the Rings")){
               books.remove(k);
            }
        }
        for (String b : books) {
            System.out.println(b);
        }
        //Add method
        /*
        In the foreach statement you don't have access to the iterator's add method and in
         any case that's still not the type of add that you want because it does not
         does not append at the end.We use basic for loop
         */

    }
}

