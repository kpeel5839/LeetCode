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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        
        int size = count / k;
        int remain = count % k;
        cur = head;
        
        for (int i = 0; i < k; i++) {
            ListNode copyHead = new ListNode(-1);
            ListNode copyCur = copyHead;
            
            for (int j = 0; j < size + (i < remain ? 1 : 0); j++) {
                copyCur.next = new ListNode(cur.val);
                cur = cur.next;
                copyCur = copyCur.next;
            }
            
            ans[i] = copyHead.next;
        }
        
        return ans;
    }
}