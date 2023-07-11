/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public List<List<Integer>> graph = new ArrayList<>();
    
    public void dfs(TreeNode p, TreeNode c) {
        if (c == null) {
            return;
        }
        
        if (c.left != null) {
            dfs(c, c.left); 
        }
        
        if (c.right != null) {
            dfs(c, c.right); 
        }
        
        if (p != null) {
            graph.get(p.val).add(c.val);
            graph.get(c.val).add(p.val);
        }
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        for (int i = 0; i <= 500; i++) {
            graph.add(new ArrayList<>());
        }
        
        dfs(null, root);
        Queue<int[]> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[501];
        q.add(new int[] {target.val, 0});
        visited[target.val] = true;
        
        while (!q.isEmpty()) {
            int[] point = q.poll();
            
            if (point[1] == k) {
                ans.add(point[0]); 
            } else if (k < point[1]) {
                continue;
            }
            
            for (Integer next : graph.get(point[0])) {
                if (!visited[next]) {
                    q.add(new int[] {next, point[1] + 1});
                    visited[next] = true;
                }
            }
        }
        
        return ans;
    }
}