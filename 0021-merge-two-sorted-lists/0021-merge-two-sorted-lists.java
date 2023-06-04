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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        List<Integer> list = new ArrayList<>();
        
        ListNode c = list1;
        
        while (c != null) {
            list.add(c.val);
            c = c.next;
        }
        
        c = list2;
        while (c != null) {
            list.add(c.val);
            c = c.next;
        }
        
        Collections.sort(list);
        ListNode head = new ListNode();
        c = head;
        
        for (Integer next : list) {
            c.next = new ListNode(next);
            c = c.next;
        }
        
        return head.next;
    }
}