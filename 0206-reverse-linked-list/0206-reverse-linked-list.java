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
  public ListNode reverseList(ListNode head) {
    ListNode cur=head;
    Stack<Integer>stack=new Stack<>();
    while(cur!=null){
      stack.push(cur.val);
      cur=cur.next;
    }
    ListNode answerHead=new ListNode(0);
    cur=answerHead;
    while(!stack.isEmpty()){
      cur.next=new ListNode(stack.pop());
      cur=cur.next;
    }
    return answerHead.next;
  }
}