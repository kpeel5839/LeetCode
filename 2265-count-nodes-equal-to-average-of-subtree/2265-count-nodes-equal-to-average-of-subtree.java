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

    public int ans = 0;

    public int[] dfs(TreeNode cur) {
        if (cur == null) {
            return new int[] {0, 0};
        }

        int[] left = new int[] {0, 0};
        int[] right = new int[] {0, 0};

        if (cur.left != null) {
            left = dfs(cur.left);
        }

        if (cur.right != null) {
            right = dfs(cur.right);
        }

        int totalSum = left[0] + right[0] + cur.val;
        int totalCount = left[1] + right[1] + 1;
        
        if (totalSum / totalCount == cur.val) {
            ans++;
        }

        return new int[] {totalSum, totalCount};
    }

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }
}