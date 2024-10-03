package com.revature.models;

//This is a Class meant to model an Animal - Think of it as a blueprint for Animal Object
//This class defines all of the attributes (variables) and behaviors that an animal can have

public class Animal {
    //These are 3 Animal Variables - data that describes an Animal
    public int legs;
    public int age;
    public String sound;

    //This is a method that lets an animal eat
    public void eat() {
        System.out.println("CRONCH CRONCH CRONCH");
    }

    //This is a method that lets an animal make a sound
    public String makeSound() {
        return sound; //Returns the value of the sound variable (which is a String)
    }

    /*

    Method Disambiguation

    The methods above are both public, so they're accessible throughout the entire app

    Methods have RETURN TYPES - the type of data that a method will return
        -eat() has a void return type, meaning it doesn't return anything
        -makeSound() has a String data type, which means it will return a String

        -Math.random() returns a double between 0.0 - 1.0

    These methods have no (parameters) - so we don't have to supply any info

     */

    //Methods and functions serve the same purpose

    //no-args constructor and an all-args constructor ------------------------/

    //no-args constructor. It takes NO ARGuments. Often used to define our own default values
    //If we instantiate a new Animal and give it no arguments, this constructor will be called
    public Animal() {
        this.legs = 0;
        this.age = 1;
        this.sound = "yawn";
    }

    //Constructors are methods. They are special methods that help us create objects.

    //all-args constructor. It takes ALL available ARGuments for an Animal (every varaible)
    public Animal(int legs, int age, String sound) {
        this.legs = legs;
        this.age = age;
        this.sound = sound;
    }

    //NOTE: If we don't define a constructor, Java will provide a no-args constructor for us with totally default values
    //Once we define a custom constructor, this default no-args constructor goes away

    //TODO: Ben will add a method disambiguation just as a cheat sheet for how methods work

    //TODO: no-args constructor and all-orgs constructor

    //TODO: subclass that extends this Animal class


}
