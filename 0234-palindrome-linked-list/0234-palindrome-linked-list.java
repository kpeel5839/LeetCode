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
    public boolean isPalindrome(ListNode head) {
      List<Integer>values=new ArrayList<>();
      ListNode cur=head;
      while(cur!=null){
        values.add(cur.val);
        cur=cur.next;
      }
      for(int i=0;i<values.size();i++){
        if(values.get(i)!=values.get(values.size()-1-i)){
          return false;
        }
      }
      return true;
    }
}