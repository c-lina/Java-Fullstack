package com.revature.models;

public class Snake implements Animal{
    public boolean venomous;
    public int length;

    @Override
    public void makeNoise() {
        System.out.println("hiiiiisssssssssssss");
    }

    @Override
    public void walk() {
        System.out.println("sliiiiiithhhhheeer");
    }

    public Snake() {
        this.venomous = false;
        this.length = 24;
    }

    public Snake(boolean venomous, int length) {
        this.venomous = venomous;
        this.length = length;
    }
}
