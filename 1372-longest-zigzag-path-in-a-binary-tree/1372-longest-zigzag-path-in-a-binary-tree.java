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
    public int ans; 
    public void dfs(TreeNode c, int d, boolean l, boolean r) {
        if (c == null) {
            return;
        }
        
        ans = Math.max(ans, d);
        dfs(c.left, l ? 1 : d + 1, true, false);
        dfs(c.right, r ? 1 : d + 1, false, true);        
    }
    
    public int longestZigZag(TreeNode root) {
        dfs(root.left, 1, true, false);
        dfs(root.right, 1, false, true);
        return ans;
    }
}