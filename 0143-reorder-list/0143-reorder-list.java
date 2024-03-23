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
    public void reorderList(ListNode head) {
      ListNode cur=head;
      List<Integer>list=new ArrayList<>();
      while(cur!=null){
        list.add(cur.val);
        cur=cur.next;
      }
      int n=list.size();
      ListNode answer=new ListNode();
      cur=answer;
      for(int i=0;i<n;i++){
        if(n-1-i==i){
          cur.next=new ListNode(list.get(i));
          cur=cur.next;
          continue;
        }
        if(n-1-i<i){
          break;
        }
        cur.next=new ListNode(list.get(i));
        cur.next.next=new ListNode(list.get(n-1-i));
        cur=cur.next.next;
      }
      answer=answer.next;
      cur=head;
      while(cur!=null){
        cur.val=answer.val;
        answer=answer.next;
        cur=cur.next;
      }
    }
}