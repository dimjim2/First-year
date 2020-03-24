package com.dimmy;

public class Main {
    public static void main(String...args) {
        //Reference comparision ==
        //Content comparison equals
        String var1 = "beach party";
        String var2 = "beach party";
        System.out.println(var1==var2);
        System.out.println(var1.equals(var2));
        String var3="programmer";
        String var4="Machine learning";
        System.out.println(var3==var4);
        System.out.println(var3.equals(var4));
        String var5=new String("Computer science");
        String var6=new String("Computer science");
        System.out.println(var5==var6);
        System.out.println(var5.equals(var6));
        int var7=17;
        int var8=var7;
        System.out.println(var7==var8);
    }
}
