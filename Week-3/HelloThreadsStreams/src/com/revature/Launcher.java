package com.revature;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("=======================(Threads)");

        //Instantiate two threads (from InterfaceBasedThread)
        InterfaceBasedThread thread1 = new InterfaceBasedThread();
        InterfaceBasedThread thread2 = new InterfaceBasedThread();

//        thread1.run();
//        thread2.run();

        //This doesn't look concurrent at all... we didn't actually create new Threads
        //We just ran the run() method, but we needed the start() method too invoke a new thread
            //That's why we say "main----" in the output

        //Let's use start() to instantiate these new threads instead
        Thread t1 = new Thread(thread1);
        t1.start();

        Thread t2 = new Thread(thread2);
        t2.start();

        //NOTE: it doesn't matter what thread we use in the constructor, as long as it's a valid one
        Thread t3 = new Thread(thread2);

        //We'll try to set this Thread with the highest priority
            //This doesn't necessary mean it will start and finish first, but it will be given more CPU time
        t3.setPriority(Thread.MAX_PRIORITY);
        t3.start();

        System.out.println("========================(Streams)");

        //Let's make a basic Stream of Integers
        IntStream.range(0,10).skip(3).forEach(System.out::println);
        /*

        The Stream will have values 0-9 *
            * The Stream will skip the first 3 values (skip() - intermediate)
            * For each value in the string, print it out (forEach() - terminal)

        What is System.out::println? It's called "method reference syntax" (week 3 of the rubric)
        You may notice we never said what's in the print statement
        Method Reference Syntax lets us imply the value that method will take as a parameter
        Java goes "well there's nothing else for us to print, so I guess we'll print the integer that was given to us"

         */

        //Stream.of() is a convenient way to make a String of any object we want. The data must be the same data type
        Optional<String> firstString = Stream.of("OK", "uhhhhhh", "Revature", "InfoSys", "Pumpkin", "Candle")
                .sorted() //sorts the Stream according to the natural order (uses a merge sort! probably)
                .findFirst(); //returns the first element in the Stream

        /*

        Ok what is an optional? It's a Java class that either holds a value or be empty
            * It will OPTIONALLY hold a value. This is useful when we have a potentially null value
            * This is a great way to avoid NullPointerExceptions and cut down on the verbosity of try/catches
            * We do not need to extract the values in a specific way (.isPresent() and .get())

         */

        if(firstString.isPresent()) {
            System.out.println(firstString.get());
        }
        else {
            System.out.println("No data found! This helps us avoid NullPointerExceptions that can crash our app");
        }

        //Let's use a Stream on an existing data structure to create a new ArrayList after running operations on it
        ArrayList<String> names = new ArrayList<>();

        names.add("Ben");
        names.add("Jamie");
        names.add("Mister");
        names.add("Edward");
        names.add("Eggward");
        names.add("Edward");

        List<String> newNames = names.stream()
                .map(String::toUpperCase) //.maps() performs an operation for every value in the stream (note: method reference syntax)
                .distinct()
                .filter(name -> name.length() < 7)
                .toList(); //terminal operation - end the stream and return the results as a List

        System.out.println(newNames);

        //Quick Reflection API Example--------------------------------
        Class<Thread> threadClassObjectForReflection = Thread.class;

        //Getting every method found in Thread and printing it out
        for(Method m : threadClassObjectForReflection.getMethods()) {
            System.out.println(m);
            System.out.println(Arrays.toString(m.getExceptionTypes())); //printing out the methods Exceptions (which is an array)
        }
    }
}
