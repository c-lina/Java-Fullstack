package com.revature.models;

/*

This is an ABSTRACT CLASS, not the "abstract" non-access modifier. It implements the Vehicle Interface
So now, this abstract class has access to all of the members of Vehicle

Abstract Classes are Classes with AT LEAST one abstract method
What sets them apart from Interfaces, is that they can also have concrete methods

Why use an Abstract Class over an Interface?
    -If you KNOW you have certain methods that will be the same across all subclasses
    -The child classes will share the same functionality for that method (can still override of course)
    -I usually just use Interfaces in full stack development though.

Abstract methods, you are forced to override while regular methods in classes, the overriding is optional
 */

public abstract class Plane implements Vehicle {
    //Some plane variables - these are less restrictive than Interfaces (no need to be static or final)
    public int numWings;
    public int numTurbines;

    //Abstract plane method - All planes can take off, but not all planes take off the same way

    public abstract void goForward();

    public abstract void takeOff();

    public void communicateOverRadio() {
        System.out.println("uhhhhhhhhhhh welcome aboard everybody we're uhhhhhhhhhhh looking at-");
    }

    public Plane(int numTurbines, int numWings) {
        this.numTurbines = numTurbines;
        this.numWings = numWings;
    }
//TODO: maybe a constructor? doesn't REALLY matter since Abs Classes can't be instantiated
    //We would then call to super() in a subclass

}
