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

    public String getValue(ListNode head) {
        StringBuilder sb = new StringBuilder(); 

        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }
        
        return sb.toString();
    }

    public ListNode calculate(String s1, String s2) {
        StringBuilder result = new StringBuilder();
        
        if (s1.length() < s2.length()) {
            String tmp = s1;
            s1 = s2;
            s2 = tmp;
        }
        
        int s1Index = s1.length() - 1;
        int s2Index = s2.length() - 1;
        int addNumber = 0;
    
        while (0 <= s2Index) {
            int s1Value = s1.charAt(s1Index) - '0';
            int s2Value = s2.charAt(s2Index) - '0';

            result.append((s1Value + s2Value + addNumber) % 10);
            addNumber = (s1Value + s2Value + addNumber) / 10;

            s1Index--;         
            s2Index--;
        }

        while (0 <= s1Index) {
            int s1Value = s1.charAt(s1Index) - '0';

            result.append((s1Value + addNumber) % 10);
            addNumber = (s1Value + addNumber) / 10;
            
            s1Index--;
        }

        if (addNumber == 1) {
            result.append(addNumber); 
        }

        return stringToNode(result.reverse().toString());
    }

    public ListNode stringToNode(String s) {
        ListNode head = new ListNode();
        ListNode current = head;

        for (int i = 0; i < s.length(); i++) {
            current.next = new ListNode(s.charAt(i) - '0');
            current = current.next;
        }
        
        return head.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return calculate(getValue(l1), getValue(l2));
    }
}