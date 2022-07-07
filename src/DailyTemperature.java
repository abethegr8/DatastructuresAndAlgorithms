/*https://leetcode.com/problems/daily-temperatures/
Category** Monotonic Stack problem:
** A monotonic stack is simply a stack where the elements are always in sorted order.
** Monotonic stacks are a good option when a problem involves comparing the size of numeric elements, with their order being relevant.
Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you
have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

Example 1:

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
Example 2:

Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
Example 3:

Input: temperatures = [30,60,90]
Output: [1,1,0]

Constraints:

1 <= temperatures.length <= 10^5
30 <= temperatures[i] <= 100

Understand:
Will there ever be an empty array in the input? If so what to do with it?
Are we gauranteed only integers in the array?
If so what are the integers given. Are there any negatives?
What is the max length of the array given?
What is the smallest and lowest number given at any index of the array?

Match:
Since we are working with arrays.
Nested For Loops
2 pointer technique
sliding window technique
Using a stack

Plan:
Since the constraints say the length of the array can be up to 10^5 or 100,000 then nested for loops are not useful because we will run into a time out error
Using a stack, we give up space to make our time better
the stack will keep track of the index of the array temperature.
create an array called answer, initialize it with the length of the temperature array
create a stack to hold integers
create a for loop, the int i will the current day we are working with which matches the index of the array which holds the temp
for(int i=0; i<N; i++)
the first time it runs it will skip this if statement because the stack is empty, then it'll go to the else statement which will push the current day into stack
create a while loop to check if the stack isEmpty() and checks the temperature arrays index is lesser than the following day.
while(!stack.isEmpty() && temperature[stack.peek()] < temperature[i])
if this is true then we found that the next day is hotter so we can do math to find out how many days we waited and we'll add it to the answer array
answer[stack.peek()] = i - stack.peek();
stack.pop(); //pop it out no longer needed
else, lets just push the currentday into the stack. stack holds the current day which is the index of the temperature array
stack.push(i);
finally lets just return the array called answer

Implement: see method below

Review: review any bugs in the code, optimize if asked to.

Evaluate: Time O(N) and Space O(N)

 */

import java.util.Stack;

public class DailyTemperature {
    public static int[] dailyTemperature(int[] temperature){
        int N = temperature.length;
        int[] daysForTemperatureChange = new int[N];        // We will return this array. Will hold the amount of days we have to wait for it to be warmer
        Stack<Integer> indexOfEachTemperatureArrayElement = new Stack<>();      // Monotonic Stack, keeps the index of the temperature of that day

        for (int i = 0; i < N; i++) {
            // Go into the while loop if stack is not empty and the temperature tomorrow is warmer than today
            while(!indexOfEachTemperatureArrayElement.isEmpty() && temperature[indexOfEachTemperatureArrayElement.peek()] < temperature[i]){
                // We add the days it takes to get warmer into the returning array. Simple math take the day we are at minus the day we are comparing
                daysForTemperatureChange[indexOfEachTemperatureArrayElement.peek()] = i - indexOfEachTemperatureArrayElement.peek();
                indexOfEachTemperatureArrayElement.pop();  //lets pop from the stack since we are done with that day.
            }
            // We keep pushing the day that is used as i into the stack. We only get here if the stack is empty and if the temperature is not warmer the next day
            indexOfEachTemperatureArrayElement.push(i);
        }
        return daysForTemperatureChange;
    }

}
