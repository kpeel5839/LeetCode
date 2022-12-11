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
    public int max = Integer.MIN_VALUE;
    
    public int getMaxPathSum(TreeNode currentNode) {
        int leftPathSum = 0;
        int rightPathSum = 0;
        
        if (currentNode.left != null ) {
            leftPathSum = getMaxPathSum(currentNode.left);    
        }
        
        if (currentNode.right != null) {
            rightPathSum = getMaxPathSum(currentNode.right);
        }
        
        // 이제 여기서 결정해야함, 점수를 낼 때에는 양쪽 둘다 선택하는 것이 좋은지 아닌지를 선택하고
        // 그리고 위쪽에 넘길때는 둘중 max 해서 더해서 넘김
        max = Math.max(max, currentNode.val + (leftPathSum < 0 ? 0 : leftPathSum) + (rightPathSum < 0 ? 0 : rightPathSum));
        return currentNode.val + (Math.max(leftPathSum, rightPathSum) < 0 ? 0 : Math.max(leftPathSum, rightPathSum));
    }
    
    public int maxPathSum(TreeNode root) {
        getMaxPathSum(root);
        return max;
    }
}