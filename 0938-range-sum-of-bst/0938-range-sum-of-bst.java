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
    public static int sum = 0;
    public void dfs(TreeNode node , int low ,int high) {
        if(node.left != null){
            dfs(node.left , low , high);
        }
        
        if(node.right != null){
            dfs(node.right , low , high);
        }
        
        if(low <= node.val && node.val <= high){
            sum += node.val;
        }
    }
    
    public int rangeSumBST(TreeNode root, int low, int high) {
        sum = 0;
        dfs(root , low , high);
        return sum;
    }
}