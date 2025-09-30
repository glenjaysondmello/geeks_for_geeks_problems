/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    // Function to check whether a Binary Tree is BST or not.
    boolean isBST(Node root) {
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    static boolean isValid(Node node, int low, int high) {
        if(node == null) return true;
        
        int value = node.data;
        
        if(value < low) return false;
        if(value > high) return false;
        
        return isValid(node.left, low, value) && isValid(node.right, value, high);
    }
}

// Examples:

// Input: root = [2, 1, 3, N, N, N, 5]
// Output: true 
// Explanation: The left subtree of every node contains smaller keys and right subtree of every node contains greater keys. Hence, the tree is a BST.

// Input: root = [2, N, 7, N, 6, N, 9] 
// Output: false 
// Explanation: Since the node to the right of node with key 7 has lesser key value, hence it is not a valid BST.

// Input: root = [10, 5, 20, N, N, 9, 25]
// Output: false
// Explanation: The node with key 9 present in the right subtree has lesser key value than root node.

