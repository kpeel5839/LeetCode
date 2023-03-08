/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode answer = null;
    
    public boolean dfs(TreeNode current, int p, int q) {
        boolean left = false;
        boolean right = false;
        
        if (current.left != null) {
            left = dfs(current.left, p, q);
        }
        
        if (current.right != null) {
            right = dfs(current.right, p, q);
        }
        
        if (left && right && answer == null) {
            answer = current;
        }
        
        if ((left || right) && answer == null && (current.val == p || current.val == q)) {
            answer = current;
        }
        
        if (current.val == p || current.val == q) {
            return true;
        }
        
        return left || right;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p.val, q.val);
        return answer;
    }
}