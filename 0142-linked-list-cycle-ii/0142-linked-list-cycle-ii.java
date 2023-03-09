/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> v = new HashSet<>();
        ListNode c = head;
        v.add(c);
        
        while (c != null && c.next != null) {
            if (v.contains(c.next)) {
                return c.next;            
            }
            
            c = c.next;
            v.add(c);
        }
        
        return null;
    }
}