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
    public TreeNode dfs(int[] in, int[] po, int li, int ri, int lp, int rp) {
        int pivot = po[rp];
        int mid = 0;
        
        for (int i = li; i <= ri; i++) {
            if (in[i] == pivot) {
                mid = i;
                break;
            }
        }
        
        int lSize = mid - li;
        int rSize = ri - mid;
        TreeNode t = new TreeNode(pivot);
        
        if (0 < lSize) {
            t.left = dfs(in, po, li, mid - 1, lp, lp + lSize - 1);
        }
        
        if (0 < rSize) {
            t.right = dfs(in, po, mid + 1, ri, lp + lSize, rp - 1);
        }
        
        return t;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return dfs(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
}