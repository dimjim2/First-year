package com.dimmy;

public class Main {
    public static void main(String...args){
        Bat b=new Bat("Indian","Asiatic","black",13455,14,13.4);
        b.informations(50);
        b.Living_Environment();
        b.Fly();
        b.Eat("Bat","birds");
        b.bat_sound();
        b.Life_of_bat(15);
        Pinguin p1=new Pinguin("Martin","Aquatic","blue",123432,20);
        p1.Dive();
        p1.Living_Environment();
        p1.Eat("Pinguin","fish");

    }
}
