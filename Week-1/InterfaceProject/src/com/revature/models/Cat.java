package com.revature.models;

public class Cat implements Animal{
    public String breed;
    boolean playful;

    @Override
    public void makeNoise() {
        System.out.println("meooooooow");
    }

    @Override
    public void walk() {
        System.out.println("rap rap rap");
    }

    public void scratchingPost(String scratchingItem) {
        System.out.println(breed + " used " + scratchingItem + " as a scratching post");
    }

    public Cat() {
        this.breed = "calico";
        this.playful = true;
    }

    public Cat(String breed, boolean playful) {
        this.breed = breed;
        this.playful = playful;
    }
}
