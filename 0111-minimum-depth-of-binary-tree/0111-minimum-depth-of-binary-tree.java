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
    
    public int ans = Integer.MAX_VALUE;
    
    public void dfs(TreeNode c, int d) {
        if (c == null) {
            return;
        } 
        
        if (c.left != null) {
            dfs(c.left, d + 1);
        }  
        
        if (c.right != null) {
            dfs(c.right, d + 1);
        }
        
        if (c.left == null && c.right == null) {
            ans = Math.min(ans, d);
        }
    }
    
    public int minDepth(TreeNode root) {
        dfs(root, 1); 
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
    
}