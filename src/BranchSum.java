/*
Given a binary tree, return a list of its branch sums from leftmost branch sum to rightmost branch sum.

A branch sum is the sum of all values in a tree branch. A branch is a path of nodes that starts at the root and ends at a leaf node.

Example:

Input:
      1
    /   \
   2     3

 Output:
 1+2=3, 1+3=4
 [3, 4]

 Understand:
 Positive and Negative ints
 Return a List<Integer> sums leftmost sums rightmost
 if the root is null, return an empty list

 Match:
 Trees, preorder, inorder, postorder, levelorder, BFS or DFS

 Plan:
 ListNode root, left child and right child, run dfs left side of the tree, run dfs until we hit null, add left nodes interger to sum until we are back at room
 add sum to return list, run dfs on the right until we hit null, add right nodes values until we are at root, add sum to return list
 return sum list

 Implement:

 Review:

 Evaluate:


 */

import java.util.ArrayList;
import java.util.List;

public class BranchSum {
    public static class Node {
        int val;
        Node left;
        Node right;
        Node() {}
        Node(int val) { this.val = val; }
        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<Integer> branchSum(Node root){
        List<Integer> returnSum = new ArrayList<>();
        int sum = 0;
        Node current = root;
        if (current == null) {
            return returnSum;
        }
        dfs(current, sum, returnSum);

        return returnSum;

    }

    public static void dfs(Node current, int sum, List<Integer> returnSum){
        sum += current.val;

        if (current.left == null && current.right == null) {
            returnSum.add(sum);
            return;
        }

        if (current.left != null) {
            dfs(current.left, sum, returnSum);
        }
        if (current.right != null) {
            dfs(current.right, sum, returnSum);
        }
    }
}
