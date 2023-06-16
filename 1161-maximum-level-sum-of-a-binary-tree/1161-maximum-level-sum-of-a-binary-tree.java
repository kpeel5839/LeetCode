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
    
    public Map<Integer, Integer> level = new HashMap<>();
     
    public void dfs(TreeNode c, int height) {
        if (c == null) {
            return;
        }
        
        if (!level.containsKey(height)) {
            level.put(height, 0);
        }
        
        level.put(height, level.get(height) + c.val);
        
        if (c.left != null) {
            dfs(c.left, height + 1); 
        }
        
        if (c.right != null) {
            dfs(c.right, height + 1);
        }
    }
    
    public int maxLevelSum(TreeNode root) {
        dfs(root, 1);
        
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(level.entrySet());
        
        list.sort((o1, o2) -> o1.getKey() - o2.getKey());
        
        int maxIndex = 0;
        int max = Integer.MIN_VALUE;
        
        for (Map.Entry<Integer, Integer> entry : list) {
            if (max < entry.getValue()) {
                max = entry.getValue();
                maxIndex = entry.getKey();
            }
        }
        
        return maxIndex;
    }
}