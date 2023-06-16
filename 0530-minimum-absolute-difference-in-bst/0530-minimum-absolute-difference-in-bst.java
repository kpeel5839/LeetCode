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
    
    List<Integer> list = new ArrayList<>();
    
    public void dfs(TreeNode c) {
        if (c == null) {
            return;
        }
        
        list.add(c.val);
        
        if (c.left != null) {
            dfs(c.left);
        }
        
        if (c.right != null) {
            dfs(c.right);
        }
    }
    
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        Collections.sort(list);
        int ans = Integer.MAX_VALUE;
        
        for (int i = 0; i < list.size() - 1; i++) {
            ans = Math.min(ans, Math.abs(list.get(i + 1) - list.get(i)));
        }
        
        return ans;
    }
}