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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        
        List<Integer> copy = new ArrayList<>();
        list.forEach(v -> copy.add(v));
        int index = 0;
        
        for (int i = right - 1; left - 1 <= i; i--) {
            list.set(left - 1 + index++, copy.get(i));
        }
        
        ListNode copyHead = new ListNode(-1);
        ListNode copyCur = copyHead;
        
        for (Integer val : list) {
            copyCur.next = new ListNode(val);
            copyCur = copyCur.next;
        }
        
        return copyHead.next;
    }
}