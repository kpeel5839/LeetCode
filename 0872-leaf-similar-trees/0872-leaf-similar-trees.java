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
    public void dfs(TreeNode currentNode, List<Integer> leafValueSequence) {
        // 여기서 왼쪽, 오른쪽 확인하고, 둘다 없으면 리프노드임
        boolean isLeaf = true;
        
        if (currentNode.left != null) {
            isLeaf = false;
            dfs(currentNode.left, leafValueSequence);
        }
        
        if (currentNode.right != null) {
            isLeaf = false;
            dfs(currentNode.right, leafValueSequence);
        }
        
        if (isLeaf) {
            leafValueSequence.add(currentNode.val);
        }
    }
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // 일단 리프 노드에 대해서 각각의 value 를 뽑아낼 수 있어야함
        // tree 는 left, right 로 이루어져있고, left -> right order 이니까, 그냥 일반적으로 하면 됨, pre, in, post 이런 거 상관 x
        boolean isTotallySame = true;
        List<Integer> leafValueSequenceOfTree1 = new ArrayList<>();
        List<Integer> leafValueSequenceOfTree2 = new ArrayList<>();
        dfs(root1, leafValueSequenceOfTree1);
        dfs(root2, leafValueSequenceOfTree2);
        
        if (leafValueSequenceOfTree1.size() == leafValueSequenceOfTree2.size()) {
            for (int i = 0; i < leafValueSequenceOfTree1.size(); i++) {
                if (!leafValueSequenceOfTree1.get(i).equals(leafValueSequenceOfTree2.get(i))) { // is difference
                    isTotallySame = false;
                }
            }
        } else {
            isTotallySame = false;
        }
        
        return isTotallySame;
    }
}