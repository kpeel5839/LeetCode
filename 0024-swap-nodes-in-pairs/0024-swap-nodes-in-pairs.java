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
    public ListNode swapPairs(ListNode head) {
        ListNode c = head;
        List<Integer> list = new ArrayList<>();
        
        while (c != null) {
            list.add(c.val);
            c = c.next;
        }
        
        for (int i = 1; i < list.size(); i += 2) {
            int a = list.get(i - 1);
            int b = list.get(i);
            list.set(i - 1, b);
            list.set(i, a);
        }
        
        ListNode h = new ListNode();
        c = h;
        
        for (Integer v : list) {
            c.next = new ListNode(v);
            c = c.next;
        }
        
        return h.next;
    }
}