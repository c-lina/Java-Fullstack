package com.revature;

import com.revature.models.*;

public class Launcher {
    public static void main(String[] args) {

        //Instantiate an Animal object with the no-args constructor
        //This will give us a generic Animal object with generic values

        Animal a = new Animal();

        //let's use some animal variables
        System.out.println("Our animal has " + a.legs + " legs"); // 0 legs is no way to live

        //we can assign new values to our object's variables
        a.legs = 12;
        System.out.println("Now our animal has " + a.legs + " legs");

        //let's invoke the 2 animal methods

        a.eat();

        //since makeSound() returns a String, we need to print it out to see anything
        System.out.println(a.makeSound());

        //TODO: make 2 new Animals in a different way

//        a.sound = "Groooooowl";
//        System.out.println(a.makeSound());

        //OK let's instantiate 2 new animals using an all-args constructor
        Animal a2 = new Animal(4,2,"woof");
        Animal a3 = new Animal(2,5,"oo oo aa aa");

        //use makeNoise methods just for fun

        System.out.println(a2.makeSound());
        System.out.println(a3.makeSound());

        System.out.println("============================(we use our new Dog subclass)");

        //Instantiate a dog object using the no-args constructor

        Dog d = new Dog();

        //let's use some dog methods
        d.eat();
        d.fetch("ball");

        //Using the all-args constructor now

        Dog d2 = new Dog(4,5,"AWOOOOOOO", "foxhound");
        Dog d3 = new Dog(4,8, "bark", "terrier");

        System.out.println(d2.breed + " says " + d2.makeSound());
        System.out.println(d3.breed + " says " + d3.makeSound());

        //method overloading is when we have methods with the same name but with a different lists of parameters
    }
}
