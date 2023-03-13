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
    public List[] l = new List[2];
    
    public void dfs(TreeNode c, int depth, int n) {    
        if (l[n].size() <= depth) {
            l[n].add(new ArrayList<>());
        }
        
        if (c == null) {
            ((ArrayList) l[n].get(depth)).add(-101);
            return;
        }
        
        ((ArrayList) l[n].get(depth)).add(c.val);
        dfs(c.left, depth + 1, n);
        dfs(c.right, depth + 1, n);
    }
    
    public boolean isSymmetric(TreeNode root) {
        l[0] = new ArrayList<ArrayList<Integer>>();
        l[1] = new ArrayList<ArrayList<Integer>>();
        
        dfs(root.left, 0, 0);
        dfs(root.right, 0, 1);
        
        if (l[0].size() != l[1].size()) {
            return false;
        }
        
        for (int i = 0; i < l[0].size(); i++) {
            ArrayList<Integer> l1 = (ArrayList) l[0].get(i);
            ArrayList<Integer> l2 = (ArrayList) l[1].get(i);
            
            if (l1.size() != l2.size()) {
                return false;
            }
            
            for (int j = 0; j < l1.size(); j++) {
                if (l1.get(j) != l2.get(l2.size() - j - 1)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}