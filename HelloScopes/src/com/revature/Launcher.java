package com.revature;

public class Launcher {
    public static void main(String[] args) {
        //Since int1 and int2 are static, we can call them directly from the ScopeTester class
        //We don't instantiate 
        System.out.println(ScopeTester.int1);
    }
}
