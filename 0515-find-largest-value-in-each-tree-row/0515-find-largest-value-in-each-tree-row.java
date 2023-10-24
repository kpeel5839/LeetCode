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

    public List<Integer> list = new ArrayList<>();
    
    public void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }

        if (list.size() <= depth) {
            list.add(Integer.MIN_VALUE);
        }

        list.set(depth, Math.max(list.get(depth), node.val));
        
        if (node.left != null) {
            dfs(node.left, depth + 1);
        }

        if (node.right != null) {
            dfs(node.right, depth + 1);
        }
    }

    public List<Integer> largestValues(TreeNode root) {
        dfs(root, 0);
        return list;
    }
}