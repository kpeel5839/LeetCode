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
    void dfs(TreeNode*cur,int target){
        if(cur->left!=nullptr){
            dfs(cur->left,target);
            if(cur->left->val==target&&cur->left->left==nullptr&&cur->left->right==nullptr){
                cur->left=nullptr;
            }
        }
        if(cur->right!=nullptr){
            dfs(cur->right,target);
            if(cur->right->val==target&&cur->right->left==nullptr&&cur->right->right==nullptr){
                cur->right=nullptr;
            }
        }
    }
    TreeNode* removeLeafNodes(TreeNode* root, int target) {
        dfs(root,target);
        if(root->left==nullptr&&root->right==nullptr&&root->val==target){
            return nullptr;
        }
        return root;
    }
};