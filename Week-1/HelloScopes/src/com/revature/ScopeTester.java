package com.revature;

public class ScopeTester {

    //This is a Class scoped (AKA static scoped) primitive. Note "static" non-access modifier
    //It's initialized with the value 10
    //Static members belongs to the class so you can call it directly from the class (class scoped variable)
    //If you change a static, it will change for all instances of it

    public static int int1 = 10;

    //Here's another Class scoped primitive. It's uninitialized

    public static int int2;

    //This is an Instance scoped primitive. Note the lack of the static
    //Because it does not have 'static', so you need to make an instance of the class to access it (instance scoped variable)

    public int int3 = 5;

    //let's throw in another nonstatic just for practice
    public String message = "I am the original message";

    public static void staticMethod() {
        System.out.println("Hello from the static method in ScopeTester");
    }

    public void nonstaticMethod() {
        System.out.println("Hello from the nonstatic method in ScopeTester");
    }
}
