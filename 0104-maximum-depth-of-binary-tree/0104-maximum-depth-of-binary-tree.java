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
    
    public int answer = 0;
    
    public void dfs(TreeNode current, int depth) {
        if (current == null) {
            return;
        }
        
        if (current.left != null) {
            dfs(current.left, depth + 1);
        }

        if (current.right != null) {
            dfs(current.right, depth + 1);
        }

        answer = Math.max(answer, depth);
    }
    
    public int maxDepth(TreeNode root) {
        dfs(root, 1);
        return answer;
    }
}