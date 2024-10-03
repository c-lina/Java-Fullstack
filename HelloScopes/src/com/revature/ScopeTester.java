package com.revature;

public class ScopeTester {

    //This is a Class scoped (AKA static scoped) primitive. Note "static" non-access modifier
    //It's initialized with the value 10
    //Static members belongs to the class

    public static int int1 = 10;

    //Here's another Class scoped primitive. It's uninitialized

    public static int int2;

    //This is an Instance scoped primitive. Note the lack of the static
    //Because it does not have 'static', it does not belong to the class

    public int int3 = 5;
}
