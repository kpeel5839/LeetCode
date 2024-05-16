/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    bool dfs(TreeNode* cur){
        bool leaf=true;
        bool result1;
        bool result2;
        if(cur->left!=nullptr){
            result1=dfs(cur->left);
            leaf=false;
        }
        if(cur->right!=nullptr){
            result2=dfs(cur->right);
            leaf=false;
        }
        if(leaf){
            return cur->val==0?false:true;
        }
        return cur->val==2?result1||result2:result1&&result2;
    }
    bool evaluateTree(TreeNode* root) {
        return dfs(root);
    }
};