/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}*/

// Find the middle using slow/fast pointers, reverse the second half, then compare both halves in O(1) space.
class Solution {
    public boolean isPalindrome(Node head) {
        Node slow = head;
        Node fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        Node mid = slow;
        Node node1 = head;
        Node node2 = reverseList(mid);
        
        while(node2 != null) {
            if(node1.data != node2.data) return false;
            
            node1 = node1.next;
            node2 = node2.next;
        }
        
        return true;
    }
    
    
    static Node reverseList(Node head) {
        Node prev = null;
        Node pres = head;
        Node next = head.next;
        
        while(pres != null) {
            pres.next = prev;
            prev = pres;
            pres = next;
            if(next != null) next = next.next;
        }
        
        return prev;
    }
}

// Create a deep copy of the list, reverse the copy, and compare with the original using extra O(n) space.
class Solution {
    public boolean isPalindrome(Node head) {
        Node copy = copyList(head);
        Node reverseCopy = reverseList(copy);
        
        Node node1 = head;
        Node node2 = reverseCopy;
        
        while(node1 != null && node2 != null) {
            if(node1.data != node2.data) return false;
            
            node1 = node1.next;
            node2 = node2.next;
        }
        
        return true;
    }
    
    static Node copyList(Node head) {
        Node dummy = new Node(0);
        Node temp = dummy;
        Node curr = head;
        
        while(curr != null) {
            temp.next = new Node(curr.data);
            curr = curr.next;
            temp = temp.next;
        }
        
        return dummy.next;
    }
    
    static Node reverseList(Node head) {
        Node prev = null;
        Node pres = head;
        Node next = head.next;
        
        while(pres != null) {
            pres.next = prev;
            prev = pres;
            pres = next;
            if(next != null) next = next.next;
        }
        
        return prev;
    }
}

// Examples:

// Input: 1 -> 2 -> 1 -> 1 -> 2 -> 1
// Output: true
// Explanation: The given linked list is 1 -> 2 -> 1 -> 1 -> 2 -> 1, which is a palindrome.
  
// Input: 10 -> 20 -> 30 -> 40 -> 50
// Output: false
// Explanation: The given linked list is 10 -> 20 -> 30 -> 40 -> 50, which is not a palindrome.

