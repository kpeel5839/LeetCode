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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode c = head;
        List<Integer> list = new ArrayList<>();
        while (true) {
            list.add(c.val);
            
            if (c.next == null) {
                break;
            }
            
            c = c.next;
        }
        
        int a = list.get(k - 1);
        int b = list.get(list.size() - k);
        list.set(k - 1, b);
        list.set(list.size() - k, a);
        ListNode h = new ListNode();
        c = h;    
        
        for (int i = 0; i < list.size(); i++) {
            c.next = new ListNode(list.get(i));
            c = c.next;        
        }
        
        return h.next;
    }
}