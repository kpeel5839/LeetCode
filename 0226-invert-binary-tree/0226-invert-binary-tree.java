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
    public void dfs(TreeNode current){
        if (current == null) {
            return;
        }

        TreeNode tmp = current.left;
        current.left = current.right;
        current.right = tmp;

        if (current.left != null) {
            dfs(current.left);
        }

        if (current.right != null) {
            dfs(current.right);
        }
    }
    
    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root; 
    }
}