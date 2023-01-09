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
    public List<Integer> answer = new ArrayList<>();
    
    public void preOrder(TreeNode cur) {
        if (cur == null) {
            return;
        }
        
        answer.add(cur.val);
        
        if (cur.left != null) {
            preOrder(cur.left);    
        }
        
        if (cur.right != null) {
            preOrder(cur.right);
        }
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return answer;
    }
}