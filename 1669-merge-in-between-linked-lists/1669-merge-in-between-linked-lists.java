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
  public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
    ListNode cur=list1;
    List<Integer>values=new ArrayList<>();
    while(cur!=null){
      values.add(cur.val);
      cur=cur.next;
    }
    ListNode endOfList2=list2;
    while(endOfList2.next!=null){
      endOfList2=endOfList2.next;
    }
    ListNode answer=new ListNode();
    cur=answer;
    for(int i=0;i<values.size();i++){
      if(i<a){
        cur.next=new ListNode(values.get(i));
        cur=cur.next;
      }else if(a<=i&&i<=b){
        if(a==i){
          cur.next=list2;
        }
      }else{
        endOfList2.next=new ListNode(values.get(i));
        endOfList2=endOfList2.next;
      }
    }
    return answer.next;
  }
}