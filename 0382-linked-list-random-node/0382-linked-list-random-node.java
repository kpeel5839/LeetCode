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
    
    public List<ListNode> nodes;

    public Solution(ListNode head) {
        ListNode c = head;    
        nodes = new ArrayList<>();
        
        while (c != null) {
            nodes.add(c);
            
            if (c.next == null) {
                break;
            }
            
            c = c.next;
        }
    }
    
    public int getRandom() {
        Random random = new Random();
        return nodes.get(random.nextInt(nodes.size())).val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */