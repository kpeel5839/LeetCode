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
    Map<List<Integer>, Integer> map = new HashMap<>();
    List<TreeNode> answer = new ArrayList<>();
    final int NONE = -300;
    
    public List<Integer> dfs(TreeNode cur) {
        if (cur == null) {
            return null;
        }
        
        List<Integer> list = new ArrayList<>();
        list.add(cur.val);
        
        if (cur.left != null) {
            list.addAll(dfs(cur.left));
        } else {
            list.add(NONE);
        }
        
        if (cur.right != null) {
            list.addAll(dfs(cur.right));
        } else {
            list.add(NONE);
        }
                        
        int count = map.getOrDefault(list, 0);                
        if (count == 0) {
            map.put(list, count + 1);   
        } else if (count == 1) {
            answer.add(cur);
            map.put(list, count + 1);
        }
        
        return list;
    }
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return answer;
    }
}