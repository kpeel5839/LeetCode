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

    public StringBuilder answer = new StringBuilder();
    public final int LEFT = 1;
    public final int RIGHT = 2;
    
    public void preOrder(TreeNode cur, int direction) {
        if (cur == null) {
            if (direction == LEFT) {
                answer.append("()");
            }
            return;
        }

        answer.append("(").append(cur.val);
        if (!(cur.left == null && cur.right == null)) {
            preOrder(cur.left, LEFT);
            preOrder(cur.right, RIGHT);
        }
        answer.append(")");
    }

    public String tree2str(TreeNode root) {
        preOrder(root, LEFT);
        return answer.substring(1, answer.length() - 1).toString();
    }

}