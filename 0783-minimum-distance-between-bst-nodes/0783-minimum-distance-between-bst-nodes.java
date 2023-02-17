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
    List<Integer> value = new ArrayList<>();
    public void dfs(TreeNode current) {
        if (current == null) {
            return;
        }
        
        value.add(current.val);
        
        if (current.left != null) {
            dfs(current.left);
        }
        
        if (current.right != null) {
            dfs(current.right);
        }
    }
    
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        Collections.sort(value);
        int answer = Integer.MAX_VALUE;
        
        for (int i = 0; i < value.size() - 1; i++) {
            answer = Math.min(answer, value.get(i + 1) - value.get(i));
        }
        
        return answer;
    }
}