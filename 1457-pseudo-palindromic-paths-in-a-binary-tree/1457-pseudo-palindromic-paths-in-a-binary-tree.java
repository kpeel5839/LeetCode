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
    
    public int[] count;
    public int answer = 0;
    
    public void dfs(TreeNode cur) {
        if (cur == null) {
            return;
        }
        
        count[cur.val]++;
        
        if (cur.left == null && cur.right == null) {
            int oddCount = 0;
            
            for (int i = 1; i < count.length; i++) {
                if (count[i] % 2 == 1) {
                    oddCount++;
                }
            }
            
            if (oddCount <= 1) {
                answer++;
            }
        }
        
        dfs(cur.left);
        dfs(cur.right);
        count[cur.val]--;
    }
    
    public int pseudoPalindromicPaths (TreeNode root) {
        count = new int[10];
        dfs(root);
        
        return answer;
    }
}