/*https://leetcode.com/problems/fibonacci-number/
The Fibonacci numbers are the numbers in the following integer sequence.
0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144,
1  2  3  4  5  6  7   8   9  10  11  12   13
e.i: fib(2) should be 1, because 0+1 = 1; fib(3) should be 2, because 0+1+1=2; fib(4) should be 4 because 0+1+1+2=4;

 */

public class Fibonnaci {
    public static int fibBruteForce(int n){
        //Time: O(2^n), Space: O(N), we are using the call stack
        if(n <= 1){     //base case, we only get here if n = 1 or 0.
            return n;
        }
        //the way fib works is that we know what the next number is if we add the two previous numbers. n-1 single previous, n-2 double previous
        return fibBruteForce(n - 1) + fibBruteForce(n-2);
    }
}
