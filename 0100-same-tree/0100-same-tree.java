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
    public boolean isSame(List<long[]> firstTree, List<long[]> secondTree) {
        for (int i = 0; i < Math.min(firstTree.size(), secondTree.size()); i++) {
            if (!(firstTree.get(i)[0] == secondTree.get(i)[0] && firstTree.get(i)[1] == secondTree.get(i)[1])) {
                return false;
            }
        }
        
        return firstTree.size() == secondTree.size();
    }
    
    public void preOrder(List<long[]> order, long nodeNumber, TreeNode cur) {
        if (cur == null) {
            return;
        }
        
        order.add(new long[] {nodeNumber, cur.val});
        
        if (cur.left != null) {
            preOrder(order, nodeNumber * 2, cur.left);
        }
        
        if (cur.right != null) {
            preOrder(order, nodeNumber * 2 + 1, cur.right);
        }
    }
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<long[]> firstTree = new ArrayList<>();
        List<long[]> secondTree = new ArrayList<>();
        preOrder(firstTree, 1, p);
        preOrder(secondTree, 1, q);
        
        return isSame(firstTree, secondTree);
    }
}