package com.revature.models;

/*

Boeing extends Plane. Plane implements Vehicle. So this Class has everything from Plane and Vehicle
In other words, it has INHERITED all the members from Plane and Vehicle

Since Boeing747 is a CONCRETE class, it MUST implement the 2 abstract methods it inherited

 */

public class Boeing747 extends Plane{
    //This method was inherited from plane
    @Override
    public void takeOff() {
        System.out.println("Increasing Throttle...");
        System.out.println("Lift off!");
    }

    //This method was inherited from Vehicle
    @Override
    public void goForward() {
            System.out.println("Starting Engines...");
            System.out.println("The guy with the light batons is like 'ok you can go now'");
            System.out.println("We're rolling");
    }

    //Notice we didn't need to @Override the communicateOverRadio() method. It's already implemented
    //We could have overridden it, but we don't have to

    //TODO: remember the default no-args constructor goes away once we make our own constructor
    //TODO: so if we need a no-args constructor, we have to recreate it ourselves


    public Boeing747(int numWings, int numTurbines) {
        super(numWings, numTurbines);
    }
}
