import java.util.*;

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
    public final long MOD = (long) Math.pow(10, 9) + 7;
    public List<Long> subTreeSumOfTree = new ArrayList<>();
    
    public long getSubTreeSum(TreeNode currentNode) {
        long subTreeSum = currentNode.val;
            
        if (currentNode.left != null) {
            subTreeSum += getSubTreeSum(currentNode.left);
        }
        
        if (currentNode.right != null) {
            subTreeSum += getSubTreeSum(currentNode.right);
        }
        
        subTreeSumOfTree.add(subTreeSum);
        return subTreeSum;
    }
    
    public int maxProduct(TreeNode root) {        
        long totalSumOfTree = getSubTreeSum(root);
        long result = 0;
        
        for (int i = 0; i < subTreeSumOfTree.size(); i++) {
            long subTreeSum = subTreeSumOfTree.get(i);
            result = Math.max(result, (totalSumOfTree - subTreeSum) * subTreeSum);
        }
        
        return (int) (result % MOD);
    }
}