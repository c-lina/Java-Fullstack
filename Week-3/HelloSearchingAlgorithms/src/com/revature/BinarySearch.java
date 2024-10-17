package com.revature;

public class BinarySearch {
    public static void main(String[] args) {

        //array of ints to search them
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int target = 10;
        int result = BinarySearch(arr, target);

        if(result != 1) {
            System.out.println("Target " + target + " found at index " + result);
        }
    }

    /*

    Binary Search
        * A more efficient but more complex algorithm (compared to linear search)
            - BINARY SEARCH ONLY WORKS WITH SORTED DATA! So we would have to sort unsorted data
        * It works by comparing the target to the middle element in the data
        * If the target is less than the middle element, we only search the left half of the data
        * If the target is greater than the middle element, we only search the right half of the data
        * We repeat this process of halving the elements only we find the target
     */

    public static int BinarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        //while the left pointer is <= the right pointer
        while(left <= right) {
            int mid = (left + right) / 2;

            System.out.println("left is " + left);
            System.out.println("Middle index is: " + mid);

            //if the middle index is the target, return it
            if(arr[mid] == target) {
                return mid;
            }

            System.out.println("Data splits here");

            //if the middle element is less than the target, ignore the left half (we know it's the right half)
            if(target > arr[mid]) {
                left = mid + 1; //
            }
            else if(target < arr[mid]) {
                //if the target is less than the middle element, ignore the right half (we know it's the left half)
                right = mid - 1;
            }

        } //end of while loop

        //if the while loop ends before returning, the element wasn't found
        return -1;

    }


}
