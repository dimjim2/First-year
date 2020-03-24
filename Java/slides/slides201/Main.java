package com.dimmy;

import java.util.Scanner;
public class Main {
    static final String professor="Charles";
    public static void main(String...args) {
        Student s = new Student() {
            @Override
           void lesson() {
                Scanner sc = new Scanner(System.in);
                for (int j = 0; j < 5; j++) {
                    System.out.println("Give me your favorite lesson");
                    fv.add(sc.nextLine());
                }
                display();
            }
        };
        s.lesson();
        s.delete("Algebra");
        System.out.println("-------");
        s.display();

        new Study(){
            @Override
            public void study(){
                System.out.println("I am studying now ");
            }
        }.study();


        String lesson="Computer science";//effectively final
        new Student() {
            class Exercice {
                boolean ok = true;
                void favorite() {
                    do {
                        System.out.println("Give me your favorite lesson");
                        Scanner sc = new Scanner(System.in);
                        String course = sc.nextLine();
                        if (course.equals(lesson)) {
                            //lesson="gggg";;
                            ok=false;
                            System.out.println("I am doing my favorite lesson " +lesson +" with my dear professor " +professor);
                        }
                    } while (ok == true);
                    System.out.println("I am inside PC class");
                }
            }
        }.new Exercice().favorite();

        Student.getStudent().exam();
    }
}
