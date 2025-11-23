/* Structure of node
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
} */

class Solution {
    int getKthFromLast(Node head, int k) {
        Node temp = reverseList(head);
        
        for(int i = 0; i < k - 1; i++) {
            if(temp != null) temp = temp.next;
            else return -1;
        }
        
        if(temp == null) return -1;
        
        return temp.data;
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

// Examples

// Input: LinkedList: 1->2->3->4->5->6->7->8->9, k = 2
// Output: 8
// Explanation: The given linked list is 1->2->3->4->5->6->7->8->9. The 2nd node from end is 8.

// Input: LinkedList: 10->5->100->5, k = 5
// Output: -1
// Explanation: The given linked list is 10->5->100->5. Since 'k' is more than the number of nodes, the output is -1.

