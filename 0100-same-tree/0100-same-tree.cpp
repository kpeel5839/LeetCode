/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left),
 * right(right) {}
 * };
 */
class Solution {
public:
    typedef vector<int> vi;
    typedef vector<vi> vii;
    vii vp, vq;
    int LEFT = 1;
    int RIGHT = 2;
    void dfs(TreeNode* cur, vii& v, int depth) {
        if (cur->left != nullptr) {
            v.push_back({LEFT, cur->left->val, depth});
            dfs(cur->left, v, depth + 1);
        }
        if (cur->right != nullptr) {
            v.push_back({RIGHT, cur->right->val, depth});
            dfs(cur->right, v, depth + 1);
        }
    }
    bool isSameTree(TreeNode* p, TreeNode* q) {
        if (p == nullptr && q == nullptr) {
            return true;
        } else if (p == nullptr || q == nullptr) {
            return false;
        }
        if (p->val != q->val) {
            return false;
        }
        dfs(p, vp, 0);
        dfs(q, vq, 0);
        if (vp.size() != vq.size()) {
            return false;
        }
        for (int i = 0; i < vp.size(); i++) {
            for (int j = 0; j < 3; j++) {
                if (vp[i][j] != vq[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
};