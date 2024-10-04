package com.revature;

import java.io.FileNotFoundException;
import java.io.NotActiveException;

import com.revature.exceptions.NotACookieException;
import com.revature.models.*;

public class Launcher {

    //main will try to throw this NotACookieException when encountered... but there's nowhere to throw it
    //so your code will just crash! There should always be a try/catch method at the end of a throws chain
    //It's common for a method to throw an Exception, but there should be a try/catch method

    public static void main(String[] args) throws NotACookieException {
        System.out.println("==================(Throwing some Runtime Exceptions, AKA Unchecked Exception)");

        //NOTE: We won't usually throw Runtime Exceptions to crash our app on purpose
        //You usually throw a RuntimeException when you want to indicate that an error has occurred that the caller is not expected to handle

        System.out.println("Trying to divide by zero.");
        //System.out.println(5/0);
        //Our Java code will still compile but it will throw an ArithmeticException at RUNTIME (runtime exception)
        //We know it's a Runtime Exception if it can compile

        System.out.println("Trying to access an index that doesn't exist in an Array");

        int[] numbers = {1, 2, 3, 4, 5};

        //System.out.println(numbers[5]);
        //our "numbers" array only has indexes 0-4 - ArrayIndexOutOfBoundsException!

        //throw new FileNotFoundException();
        //FileNotFoundException is a CHECKED EXCEPTION, so the compiler won't let us run this code

        //throw new Exception();
        //the top Exception class is a CHECKED EXCEPTION as well

        System.out.println("=========================(Exception Handling)");

        /*
        //errors are more severe and we can't/don't want to recover from them
        //exceptions are less severe and we do want to recover from them. we will use try methods to catch them

        One way to handle Exceptions is through TRY/CATCH blocks
            -First, we try to execute some code that may or may not throw an Exception
            -Next, we have one or more CATCH blocks that will handle any Exceptions that are thrown
            -Lastly, we have a FINALLY block that will run at the end no matter what

         */

        try {
            System.out.println("Try block starting....");
            int x = 10/0;
            System.out.println("Will I run?");
        } catch (NullPointerException e) {
            System.out.println("I could have caught a NullPointerException... IF I HAD ONE!");
        } catch (ArithmeticException e) {
            System.out.println("I caught an ArithmeticException");
        } catch (Exception e) {
            System.out.println("I caught an Exception!");
        } finally {
            System.out.println("Finally block running... I'll run every time >:D");
            System.out.println("I'm good for things like closing resources, like a database connection");
            System.out.println("or any other general terminal functions, like saying goodbye to a user");
        }

        //Rule of thumb for catch block order: Most specific to most general

        System.out.println("======================(Using our Custom Checked Expression)");

        //Let's make some food objects
        Food food1 = new Food("Steak", false);
        Food food2 = new Food("White Chocolate Macadamia", true);
        CookieEatingMonster monster = new CookieEatingMonster();

        //Let's try to feed the monster
        monster.eatCookieWithTryCatch(food1);

        //Exceptions make it so that the app won't crash

        System.out.println("We just printed the stack trace from the caught expression! We didn't crash");

        monster.EatsCookiesWithThrows(food2);
    }
}
