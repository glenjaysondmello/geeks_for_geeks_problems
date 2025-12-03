/*
class Node
{
    int data;
    Node next;
}
*/

// Floyd’s Cycle Detection to find loop, then align slow & fast to locate loop start and remove it by breaking the last link.
class Solution {
    public static void removeLoop(Node head) {
        Node slow = head;
        Node fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast) break;
        }
        
        if(slow != fast) return;
        
        slow = head;
        
        if(slow == fast) {
            while(fast.next != slow) {
                fast = fast.next;
            }
        } else {
            while(slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        
        fast.next = null;
    }
}

// Examples:

// Input: head = 1 -> 3 -> 4, pos = 2
// Output: true
// Explanation: The linked list looks like 1 -> 3 -> 4 -> 3(1) where, value(index) is which the last node is connected to
// A loop is present in the list, and it is removed.

// Input: head = 1 -> 8 -> 3 -> 4, pos = 0
// Output: false
// Explanation: 
// The Linked list does not contains any loop.

// Input: head = 1 -> 2 -> 3 -> 4, pos = 1
// Output: true
// Explanation: The linked list looks like 1 -> 2 -> 3 -> 4 -> 1(0)
// A loop is present in the list, and it is removed.

