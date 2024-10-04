package com.revature;

import com.revature.models.Animal;
import com.revature.models.Cat;
import com.revature.models.Dog;
import com.revature.models.Snake;

public class Launcher {
    public static void main(String[] args) {
        Cat kitten = new Cat();
        System.out.println("Kitten goes");
        kitten.makeNoise();
        kitten.walk();
        kitten.scratchingPost("cushion");
        Dog puppy = new Dog();
        System.out.println("Puppy goes");
        puppy.makeNoise();
        puppy.walk();
        puppy.eat();
        Snake harry = new Snake();
        System.out.println("Snake goes");
        harry.makeNoise();
        harry.walk();

    }
}
