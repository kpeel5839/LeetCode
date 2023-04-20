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
    public Map<Integer, Integer> m = new HashMap<>();
    public int ans = 0;
    
    public void dfs(TreeNode c, int d, int n) {
        if (c == null) {
            return;
        }
        
        if (!m.containsKey(d)) {
            m.put(d, n);
        }
    
        ans = Math.max(ans, (n - m.get(d) + 1));
        dfs(c.left, d + 1, n * 2);
        dfs(c.right, d + 1, n * 2 + 1);        
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, 1, 1);
        return ans;
    }
}