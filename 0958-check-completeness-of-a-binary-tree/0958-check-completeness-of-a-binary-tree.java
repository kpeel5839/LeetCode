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
    public boolean isCompleteTree(TreeNode root) {
        int nodeCount = 0;
        List<Integer> nodeValues = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode t = q.poll();
            
            if (t == null) {
                nodeValues.add(-1);
                continue;
            }

            nodeValues.add(t.val);
            nodeCount++;
            q.add(t.left);
            q.add(t.right);
        }

        for (int i = 0; i < nodeCount; i++) {
            if (nodeValues.get(i) == -1) {
                return false;
            }
        }
        
        return true;
    }
}