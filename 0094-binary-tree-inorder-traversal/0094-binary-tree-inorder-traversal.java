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
    
    List<Integer> ans = new ArrayList<>();
    
    public void dfs(TreeNode cur) {
        if (cur == null) {
            return;
        }
        
        dfs(cur.left);
        ans.add(cur.val);
        dfs(cur.right);
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return ans;
    }
    
}