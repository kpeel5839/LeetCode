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
    public int maxDiff = 0;
    public void getMaxAncestorDiff(TreeNode currentNode, int maxUntilNow, int minUntilNow) {
        maxDiff = Math.max(maxDiff, Math.max(Math.abs(maxUntilNow - currentNode.val), Math.abs(minUntilNow - currentNode.val)));    
        
        if (currentNode.left != null) {
            getMaxAncestorDiff(currentNode.left, Math.max(currentNode.val, maxUntilNow), Math.min(currentNode.val, minUntilNow));    
        }   
        
        if (currentNode.right != null) {
            getMaxAncestorDiff(currentNode.right, Math.max(currentNode.val, maxUntilNow), Math.min(currentNode.val, minUntilNow));
        }
    }
    
    public int maxAncestorDiff(TreeNode root) {
        getMaxAncestorDiff(root, root.val, root.val);
        return maxDiff;
    }
}