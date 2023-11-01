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
    public Map<Integer, Integer> m = new HashMap<>();
        
    public void dfs(TreeNode cur) {
        if (cur == null) {
            return;
        }
        
        m.put(cur.val, m.getOrDefault(cur.val, 0) + 1);
        
        if (cur.left != null) {
            dfs(cur.left);
        }
        
        if (cur.right != null) {
            dfs(cur.right);
        }
    }
    
    public int[] findMode(TreeNode root) {
        dfs(root);
        int max = Integer.MIN_VALUE;
        
        for (Integer value : m.values()) {
            max = Math.max(max, value);
        }
        
        List<Integer> list = new ArrayList<>();
        
        for (Map.Entry<Integer, Integer> set : m.entrySet()) {
            if (set.getValue() == max) {
                list.add(set.getKey());
            }
        }
        
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        
        return ans;
    }
}