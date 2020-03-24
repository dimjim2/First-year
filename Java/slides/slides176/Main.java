package com.dimmy;

public class Main {
    public static void main(String...args){
        SoftwareEngineer s=new SoftwareEngineer(23,21232211,60,"Dimitris");
        s.writeCode("Java");
        s.work();
        s.age=27;
        s.information();

        Human human=new SoftwareEngineer(34,687655325,80,"Kostas");
        human.name="Mary";
        //human.yearsProgramming=12; Wrong
        ((SoftwareEngineer)human).yearsProgramming=23456;
        ((SoftwareEngineer) human).writeCode("Informatics");
        ((SoftwareEngineer) human).work();
        System.out.println(human instanceof SoftwareEngineer);
        System.out.println(human instanceof Human);
        Work worker =new Employer(29,67855543,60,"Maria",20000);
        worker.work();
        //worker.reportWork();
        ((Employer)worker).reportWork();
        ((Employer)worker).hire(5);
        ((Employer)worker).teamsize=10;
        System.out.println(worker instanceof Work);
        //System.out.println(worker instanceof Object); All classes and implement inherit from object true

        Object o =new SoftwareEngineer(21,6754321,67,"James");
        ((SoftwareEngineer) o).name="Seth";
        ((SoftwareEngineer) o).writeCode("C++");
        ((SoftwareEngineer) o).work();
        ((SoftwareEngineer)o).favoriteLaguage="Python";

        System.out.println("---------");

        Work[] workers =new Work[2];
        workers[0]=new Employer(56,6543123,80,"John",50000);
        workers[1]=new SoftwareEngineer(56,6543123,80,"John");
        for (Work i: workers ) {
            i.work();
        }
    }
}
