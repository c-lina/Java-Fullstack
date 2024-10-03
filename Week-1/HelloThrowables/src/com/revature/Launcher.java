package com.revature;

import java.io.FileNotFoundException;

public class Launcher {
    public static void main(String[] args) {
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
    }
}
