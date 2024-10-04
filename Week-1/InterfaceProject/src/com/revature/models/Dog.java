package com.revature.models;

public class Dog implements Animal{
    String breed;
    int weight;

    @Override
    public void makeNoise() {
        System.out.println("booooorf");
    }

    @Override
    public void walk() {
        System.out.println("poof poof poof");
    }


    public void eat() {
        System.out.println("CRUNCH CRUNCH CRUNCH");
    }

    public Dog() {
        this.breed = "german shepherd";
        this.weight = 110;
    }

    public Dog(String breed, int weight) {
        this.breed = breed;
        this.weight = weight;
    }
}
