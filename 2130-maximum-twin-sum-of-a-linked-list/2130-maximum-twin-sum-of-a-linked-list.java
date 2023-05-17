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
    public int pairSum(ListNode head) {
        ListNode c = head;
        List<Integer> list = new ArrayList<>();
        
        while (c != null) {
            list.add(c.val);
            c = c.next;
        }
        
        int ans = 0;
        for (int i = 0; i < list.size() / 2; i++) {
            ans = Math.max(ans, list.get(i) + list.get(list.size() - 1 - i));
        }
        
        return ans;
    }
}