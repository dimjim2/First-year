package com.dimmy;
    public class Pinguin extends Animal implements Dive{
        public void Dive(){
            System.out.println(" A pinguin  must dive under the water for 30 minutes in depth of 500 metres!!");
        }
        public void Living_Environment(){
            System.out.println("A pinguin usually lives in cold envrironments like Antartica");
        }

        public Pinguin(String name,String species,String color,float population,int age){
            this.name=name;
            this.species=species;
            this.color=color;
            this.population=population;
            this.age=age;
        }

}
