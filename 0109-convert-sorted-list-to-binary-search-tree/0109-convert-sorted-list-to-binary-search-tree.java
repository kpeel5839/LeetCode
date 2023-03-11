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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public TreeNode recursive(List<Integer> list, int l, int r) {
        if (r < l) {
            return null;
        }
        
        int size = r - l + 1;
        int mid = (l + r) / 2;
        
        if (size % 2 == 0) {
            mid++;
        }
        
        TreeNode node = new TreeNode(list.get(mid), 
                                    recursive(list, l, mid - 1),
                                    recursive(list, mid + 1, r));
        
        return node;
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        
        return recursive(list, 0, list.size() - 1);
    }
}