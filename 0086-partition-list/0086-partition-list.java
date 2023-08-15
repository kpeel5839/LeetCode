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
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode();
        ListNode largeHead = new ListNode();
        ListNode smallCur = smallHead;
        ListNode largeCur = largeHead;
        ListNode cur = head;
        
        while (cur != null) {
            if (cur.val < x) {
                smallCur.next = new ListNode(cur.val);
                smallCur = smallCur.next;
            } else {
                largeCur.next = new ListNode(cur.val);
                largeCur = largeCur.next;
            }

            cur = cur.next;
        }
        
        smallCur.next = largeHead.next;
        return smallHead.next;
    }
}