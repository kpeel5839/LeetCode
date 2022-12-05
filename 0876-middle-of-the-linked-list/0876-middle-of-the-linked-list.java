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
    public ListNode middleNode(ListNode head) {
        // 일단, ListNode 의 head 를 이용해서, next 를 통해서 size 를 파악한다.
        int sizeOfLinkedList = 0;
        ListNode cur = head;
        
        while (true) {
            // cur 의 next 계속 호출하면서 앞으로 나아가고, sizeOfLinkedList++ 를 해줌, next 가 null 인 순간 break;
            sizeOfLinkedList++;
            if (cur.next == null) {
                break;
            }
            cur = cur.next;
        }
        
        int returnIndexInLinkedList = (sizeOfLinkedList / 2) + 1;
        int nowIndex = 1;
        cur = head;
        
        while (true) {        
            if (nowIndex == returnIndexInLinkedList) {
                return cur;
            }
            
            cur = cur.next;
            nowIndex++;   
        }
    }
}