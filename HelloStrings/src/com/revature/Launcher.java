package com.revature;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("=====================(String immutability)");

        //Strings are immutable - we can't change a String once we've defined it

        String s = "I AM IMMUTABLE";

        //s = "I lied" - this reassigns s
        //While the string can be reassigned, the original String (I AM IMMUTABLE) will still be bumping around in memory


        s.toLowerCase(); //the method is happening, but it's actually changing the String
        //if we want to see the change, we have to reassign the results to a variable
        //the issue is that the results are not being saved

        String s2 = s.toLowerCase();

        System.out.println("Old String: " + s);
        System.out.println("New String: " + s2);

        System.out.println("=========================(String Equality)");

        //we can compare primitives with =, but not objects
//        int i = 5;
//        System.out.println(i == 5);

        //string are objects, and objects must be compared with .equals()
        String st = "Hello Java"; //this is a string literal (no "new" keyword)
        String st2 = "Hello Java"; //another String literal with the same value

        //These two Strings are technically the same object in memory as well
        //This is a feature of using String literals

        //By using the "new" keyword, we will ALWAYS create a new object in memory

        String st3 = new String("Hello Java");
        System.out.println(st == st2); //true - they are the same object in memory, and == compares the memory
        System.out.println(st == st3); //false - they are different objects in memory, since we used "new" for st3

        System.out.println(st.equals(st3)); //true - .equals() compared VALUES of objects, not memory addresses

        System.out.println("================================(String Method)");

        //a pangram to use some String methods on
        String pangram = "How vexingly quick daft zebras jump!";

        //we can use the length method to return an int value for the amount of chars in the string
        System.out.println("The pangram is " + pangram.length() + " chars long.");

        //we can use substring() to return a portion of the String (based on index)
        System.out.println(pangram.substring(10));
        System.out.println(pangram.substring(5,25));

        //we can use contains() to check if a String contains a certain substring
        if(pangram.contains("zebra")) {
            System.out.println("The pangram has something to do with zebras");
        }

        //we can use indexOf() to find the index of a string
        //we can use split() to break up a String into an array of Strings based on a certain delimeter
        String[] words = pangram.split("");

        System.out.println(words); //If we try to print a non-string, we will just get a memory address (until we learn about toString())

        for(String word : words) {
            System.out.println(word);
        }

        //charAt() returns the character at a certain index
        System.out.println("The char at index 5 is: " + pangram.charAt(5));

        //charAt() is often used in conjunction with length() to reverse Strings (in interviews that is)

        String hello = "Hello World";
        String str = "";

        for(int i = hello.length() - 1; i >= 0; i--) {
            str = str + hello.charAt(i);
        }

        System.out.println(str);

        System.out.println("===========================(StringBuilder Practice Program)");

        StringBuilder sb = new StringBuilder("Sphinx of Black Quartz,Judge my vow");
        String reverse = "";

        for(int i = sb.length() - 1; i >= 0; i--) {
            reverse = reverse + sb.charAt(i);
        }

        System.out.println(reverse);
        reverse = reverse + "Lina";
        System.out.println(reverse);
        String name = "Jamie";
        String finale = "";

        for(int j = 0; j < reverse.length(); j++) {
            if(j == 11) {
                finale = finale + name;
            }
            finale = finale + reverse.charAt(j);
        }
        System.out.println(finale);

        sb.reverse();
        sb.append("Lina");
        sb.insert(12, "Jamie");
        System.out.println(sb);

        //I think I understand
        /*

        Strings being immutable means that when you use a method such as toLowerCase, you have to reassign it to
        see the effect

        ex:
        String s = "I AM IMMUTABLE";
        s.toLowerCase();
        doesn't work

        StringBuilders are mutable because you don't have to reassign it. You just have to call the method and it
        reassigns itself

        ex:
        StringBuilder sb = new Stringbuilder("I AM IMMUTABLE");
        sb.reverse();
        works

         */



    }
}
