package com.revature;

import javax.sound.sampled.Line;
import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //use our linear search for a number that exists in the array
        if(LinearSearch(arr, 5) != -1) {
            System.out.println("Number found! Array index is: " + LinearSearch(arr, 5));
        }

        //using the linear search for a number that doesn't exist in the array
        if(LinearSearch(arr, 50) != -1) {
            System.out.println("Number found! Array index is: " + LinearSearch(arr, 50));
        }
        System.out.println("Number not found!");
    }

    /*

        Linear Search
            * Simple but inefficient searching algorithm
                - It takes the data structure to search through, and target to search for
            * It works by iterating through the data one by one until the target is found
            * If we find the target value, we return the index
            * If we reach the end of data and we don't find the value, we return -1

         */

    public static int LinearSearch(int[] arr, int target) {

        //we use a for loop to iterate through the array one by one
        for(int i = 0; i < arr.length; i++) {
            System.out.println("We are on index: " + i);
            if(arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
