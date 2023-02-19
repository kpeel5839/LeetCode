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
    int maxDepth = -1;
    List<List<Integer>> answer = new ArrayList<>();
    
    public void dfs(TreeNode current, int depth) {
        if (current == null) {
            return;
        }
        
        maxDepth = Math.max(maxDepth, depth);
        
        if (current.left != null) {
            dfs(current.left, depth + 1);
        }
        
        if (current.right != null) {
            dfs(current.right, depth + 1);
        }
        
        answer.get(depth).add(current.val);
    }
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        for (int i = 0; i < 2000; i++) {
            answer.add(new ArrayList<>());
        }
        
        dfs(root, 0);
        answer = answer.subList(0, maxDepth + 1);
        
        for (int i = 1; i < answer.size(); i += 2) {
            Collections.reverse(answer.get(i));
        }

        return answer;
    }
}