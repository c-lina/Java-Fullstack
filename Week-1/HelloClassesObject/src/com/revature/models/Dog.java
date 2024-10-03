package com.revature.models;

/*

Dog EXTENDS Animal... So what>

First of all, this is a primary example of INHERITANCE (one of the 4 pillars of OOP)
This means that the Dog class has ALL the members (variables and methods) of the Animal Class
It is now a SUBCLASS of animal, AKA Child class
    -This is a "IS-A" relationship. This means that a Dog IS-A Animal.
Dog can also have its own unique members that Animal doesn't have

 */

public class Dog extends Animal{

    //Dog-specific variable

    public String breed;

    //A Dog=specific method - note that it takes a parameter
    public void fetch(String thing) {
        System.out.println(breed + " fetched the " + thing);
    }

    /*

    METHOD OVERRIDING - we're taking the original eat() method from Animal and changing what it does
    Method overriding is only done in subclasses. In other words, Child Classes override Parent Class methods

    If we didn't override the eat() method, Dog would just have the same original one as Animal
    To override, we declare the SAME METHOD SIGNATURE, with a DIFFERENT METHOD BODY
    This is an example of POLYMORPHISM - one of the pillars of OOP
        -Polymorphism = "same name, different form", think of the word "morph" as in change
     */

    @Override
    public void eat() {
        System.out.println(breed + " is eating like his life depends on it");
    }

    //short way to make constructors: right-click -> generate -> constructor ->  choose the constructor type you want

    //no-args constructor
    public Dog() {
        this.breed = "mutt";
    }

    //all-args constructor
    public Dog(int legs, int age, String sound, String breed) {
        //super() just calls to a parent constructor (in other words a SUPERconstructor)
        //in other words, it uses the constructor of the parent class
        //In this case, the Dog all-args constructor will use the Animal all-args constructor
        super(legs, age, sound);
        this.breed = breed; //and of course, Dog needs to handle its own unique fields
    }

    /*

    METHOD OVERLOADING - Another example of polymorphism

    Method overloading is having multiple methods with the same name, but with a different lists of parameters
    The main example of overloading as we see is constructors

     */
}
