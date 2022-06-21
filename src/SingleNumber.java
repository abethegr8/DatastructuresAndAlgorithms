/*Hackerrank Homework for Week2
Given a non-empty array of integers, every element appears twice except for one. Find that single one.
Note: Our algorithm should have a linear runtime complexity.
For example:
Input: [2, 2, 1]
Output: 1
Input: [4, 1, 2, 1, 2]
Output: 4

UMPIRE:
Understand: Are we getting only integers in the array? What are the time/space constraints? what would you like returned? if not found what to return?
What is the largest the length of the array going to be? What is the lowest to highest the integer will be at each element in the array?
Match: Arrays, I could use nested loops, two pointers, sliding window, or datastructure hashmap?
Plan: I plan on creating a method that takes time:O(n) space:O(n) by using a hashmap to keep the elements of the array as keys and the number of times they
appear in the hashmap as values
Implement: see class created below
Review: review verbally what and how i made the class/function
Evaluate: time: O(n), space O(n)
 */

import java.util.HashMap;

public class SingleNumber {
    public static int singleNumber(int[] arr){
        HashMap<Integer, Integer> myHash = new HashMap<>();             //create hashmap
        for (int num : arr) {                                           //for loop to add elements to hashmap and values as a count
            myHash.put(num, myHash.getOrDefault(num, 0) + 1);
        }

        for (int num : arr) {           //return the num in array with a key of 1
            if(myHash.get(num) == 1){
                return num;
            }
        }

        return -1;  //if none found return -1;

    }

    public static int singleNumberOptimized(int[] arr){
        //bit manipulation
        int a = 0;
        for (int num : arr) {
            a ^= num;
        }
        return a;
    }

}
