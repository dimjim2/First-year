package com.dimmy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String...args){
        ArrayList<String> Movies=new ArrayList<>();
        //Add
        Movies.add("Avengers");
        Movies.add("Lord of the rings");
        Movies.add("Harry Potter");
        Movies.add("Titanic");
        Movies.add("Avatar");
        boolean del = false;
        System.out.println("Give the name of the movie that you want to delete");
        Scanner obj=new Scanner(System.in);
        String movie=obj.nextLine();
        Iterator i = Movies.iterator();
        String str = "";
        while (i.hasNext()) {
            str = (String) i.next();
            if (str.equals(movie)) {
                i.remove();
                break;
            }
        }
        //Movies.removeIf(Movie->Movie.equals(movie));
        //Display iteration
        for (String m:Movies){
            System.out.println(m);
        }
        //Search and edit
        System.out.println("Give me movie you want ot search");
        Scanner sc=new Scanner(System.in);
        String movie1=sc.nextLine();
        int j=0;
        for (String s:Movies){
            if (movie1.equals(s)){
                Movies.set(j,"King of Persia");
            }
            j++;
        }
        for (String m:Movies){
            System.out.println(m);
        }
    }
}
