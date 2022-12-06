/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {    
        ListNode evenHead = null;
        ListNode currentEvenNode = null;
        ListNode previousNode = null;
        ListNode lastOddNode = null;
        ListNode currentNode = head;        
        int index = 0;
        
        while (head != null) {
            index++;        
            
            if (index % 2 == 1) { // Odd         
                previousNode = currentNode;
                lastOddNode = previousNode;
                currentNode = currentNode.next;
                previousNode.next = null;            
            } else { // Even            
                previousNode.next = currentNode.next;
                
                if (evenHead == null) {
                    evenHead = currentNode;
                    currentEvenNode = evenHead;
                } else {
                    currentEvenNode.next = currentNode;
                    currentEvenNode = currentEvenNode.next;
                }
                
                currentNode = currentNode.next;
                currentEvenNode.next = null;
            }
            
            if (currentNode == null) {
                lastOddNode.next = evenHead;
                break;
            }
        }
            
        return head;
    }
}