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
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> e = new ArrayList<>();
        for (ListNode l : lists) {
            while (l != null) {
                e.add(l.val);
                l = l.next;
            }
        }
        
        Collections.sort(e);
        ListNode root = new ListNode(0);
        ListNode c = root;
        
        for (Integer val : e) {
            c.next = new ListNode(val);
            c = c.next;
        }
        
        return root.next;
    }
}