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
import java.util.*;

class Solution {

    // Using long to avoid overflow issues with large values
    List<Long> levels;

    public void dfs(TreeNode cur, TreeNode parent, int depth) {
        if (cur == null) {
            return;
        }
        if (levels.size() <= depth) {
            levels.add(0L);
        }
        levels.set(depth, levels.get(depth) + cur.val);
        if (cur.left != null) {
            dfs(cur.left, cur, depth + 1);
        }
        if (cur.right != null) {
            dfs(cur.right, cur, depth + 1);
        }
    }

    public void getAnswer(TreeNode cur, TreeNode parent, int depth, int sum) {
        if (cur == null) {
            return;
        }
        cur.val = (int)(levels.get(depth) - sum);
        long totals = 0;
        if (cur.left != null) {
            totals += cur.left.val;
        }
        if (cur.right != null) {
            totals += cur.right.val;
        }
        if (cur.left != null) {
            getAnswer(cur.left, cur, depth + 1, (int) totals);
        }
        if (cur.right != null) {
            getAnswer(cur.right, cur, depth + 1, (int) totals);
        }
    }

    public TreeNode replaceValueInTree(TreeNode root) {
        levels = new ArrayList<>();
        dfs(root, null, 0);
        getAnswer(root, null, 0, root.val);
        return root;
    }
}
