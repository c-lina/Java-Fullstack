package com.revature;

public class LauncherControlFlow {
    //short type "main" and hit enter
    public static void main(String[] args) {
        //using the built-in Math class to get a random number with the random method
        int random = (int)(Math.random() * 100);

        System.out.println(random);

        /*

        Math.random() gives us a random double between 0.1 to 1.0
        We type casted it to an int because we want a whole number
        We also multiplied it by 100 so we can get numbers from 0-100

         */

        System.out.println("=============================(If/Else)");

        //If the (condition) is true, then run the {block}, otherwise move on

        if(random > 75) {
            System.out.println("Random number is pretty big");
        }
        else if(random > 50){
            System.out.println("Random number is medium sized");
        }
        else {
            System.out.println("Random number is pretty small");
        }

        System.out.println("=============================(While/Do-While Loops)");

        //While loops will run the {block} while the (condition) is true

        //still using the random number from before

        while(random < 200) {
            System.out.println("Random number is " +random);
            random += 20;
        }

        System.out.println("While loop broke! Our number is " +random);

        //Do-While Loops are similar, but they will still run the {block} once before checking the condition

        do {
            System.out.println("Our number is " +random);
            random -= 5;
        } while(random > 150);

        System.out.println("=============================(For Loops)");

        //basic for loop --/

        /*

        for as long as this int i which starts at 0 is less than 10...
        run the block of code, and increment i by 1

        So we've written a loop that will execute some block of code 10 times

        DECLARATION: the initial variable we'll use in our loop
        CONDITION: the condition that will run before each loop
        STATEMENT: the code that will run before each loop

         */

        //We use a while loop when we don't know how many times we want to loop
        //We use a for loop when we do know how many times we want to loop

        for(int i = 0; i < 15; i++) {
            System.out.println("i is: " +i);
        }

        //more common use case of for loops: moving through a sequence of values...

        //This is an array of String. In other words, a String Array (more common termonology)
        String[] cars = {"Acura", "Mazda", "Ford", "Kia", "Toyota"};

        //Array are INDEXED, we we can retrieve their inidividual values using their index
        System.out.println(cars[0]); //Gets the first value in the array
        System.out.println(cars[4]);

        int len = cars.length;
        System.out.println("length of cars array is " +len);

        System.out.println("-----------");

        //I'm going to use a for loop to iterate through the Array and print out its values
        //TODO: skip a value and break the loop at a value

        //As long as i is less than the length of the cars Array (5), run the block of code, and increment
        for(int i = 0; i < cars.length; i++) {

            //I want to skip the current loop if we hit "Mazda"
            if(cars[i].equals("Mazda")) {
                continue; //continue causes the current loop to skip and move to the next one
            }

            //I want to break the loop entirely if we hit "Kia"
            if(cars[i].equals("Kia")) {
                break;
            }
            System.out.println(cars[i]);
        }

        System.out.println("--------");

        //Here's an ENHANCES FOR LOOP - often used to easily iterate through sequences
        //"for every car in the String[] of cars, print out the car"
        for(String car : cars) {
            System.out.println(car);
        }

        System.out.println("--------");

        String[] food = {"Pizza", "Hot Dog", "Sandwich", "Pasta"};
        for(String item : food) {
            System.out.println(item);
        }

        System.out.println();

        System.out.println("=======================(Switch)");

        System.out.println("What is the best pokemon?");

        String pokemon = "wurmple";

        //switch statements take in a value and execute some logic based on that value
        switch(pokemon) {
            case "magikarp":
                System.out.println("Magikarp is the wrong choice");
                break;
            case "charizard":
                System.out.println("Close but not the best");
                break;
            case "garchomp":
                System.out.println("That's correct!");
                break;
            case "mudkip":
                System.out.println("Mudkip is the actual right choice");
                break;
            default:
                System.out.println(pokemon + " isn't in the running");
        }

        // == (generally used for primitives) compares the memory address
        // .equals compare the literal (for strings/objects)

        // xor or "^" only return true if it has an ODD numbers of true
        if(true ^ false ^ false ^ true ^ false ^ true ^ false) {
            System.out.println("Hello");
        }



    }
}
