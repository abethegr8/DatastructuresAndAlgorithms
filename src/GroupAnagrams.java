/*Leetcode: https://leetcode.com/problems/group-anagrams/
Given an array of strings strs, group the anagrams together. You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:
Input: strs = [""]
Output: [[""]]
Example 3:
Input: strs = ["a"]
Output: [["a"]]

Understand:
What kind of array will we have? String[] array
What kind of elements will we working with? only a-z characters.
what is the max length of the String Array?
what is the max length of an element string?
what would you like returned?
Time/Space complexity constraints?

Match:
Since we are working with Arrays
2 pointer, sliding window, Sorting, HashMap/Table and Sets.

Plan:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Edge Cases: empty String Array and/or Empty element string
Time: O(nlogn) due to sorting, Space: O(n) due to storing items in an ArrayList and returning them.
create a hashmap, storing the sorted version of the String first as a key, then create an arraylist as values, this will hold any strings from the string array that matches the key
create a for each loop, looping through the String Array, grabbing one string at a time.
we have to create a character lets name it element calling the string dot toCharArray method. example "eat"
now lets sort that new character element. example "eat" sorts to "aet", Arrays.sort(element);
now that its sorted, create a new String name it stringOfElement by calling the string method valueOf string.valueOf(element); character to string
Algorithm, check if key is in the hashmap, if its not, lets add key as key and create a new ArrayList() as value
if it doesn't go into the if statement go to this means it exist in the hashmap and we want to add the Arraylist Values we have in this for each loop
hashmap.get(key).add(string);
finally return a new ArrayList of the hashmap values that is an list of lists

Can this be Optimized?

Implement: See method created below

Review:
Run through examples, edge cases and bugs in code.
Test Cases: words = [

Evaluate:
Time Complexity: O(nlogn) where n is the number of strings in the String Array, logn is due to sorting
Space Complexity: O(n) due to the extra arraylist we create to return the requested output.


 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    //Time: O(nlogn) Space:O(n)
    public static List<List<String>> groupAnagrams(String[] words){

        if (words.length == 0) {
            return new ArrayList<>();
        }

        HashMap<String, List> strAnagrams = new HashMap<>();

        for (String str : words) {
            String anagramKey = sortAnagramKey(str);
            if (!strAnagrams.containsKey(anagramKey)) {
                strAnagrams.put(anagramKey, new ArrayList());
            }
            strAnagrams.get(anagramKey).add(str);
        }

        return new ArrayList<>(strAnagrams.values());
    }

    public static String sortAnagramKey(String s){
        char[] strToChar = s.toCharArray();
        Arrays.sort(strToChar);
        String anagramKey = String.valueOf(strToChar);
        return anagramKey;
    }

}
