/** * Definition for a binary tree node.
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
    vector<int>v;
    void dfs(TreeNode*cur){
        if(cur==nullptr){
            return;
        }
        for(int i=0;i<=cur->val;i++){
            v[i]+=cur->val;
        }
        dfs(cur->left);
        dfs(cur->right);
    }
    void treeChange(TreeNode*cur){
        if(cur==nullptr){
            return;
        }
        cur->val=v[cur->val];
        treeChange(cur->left);
        treeChange(cur->right);
    }
    TreeNode* bstToGst(TreeNode* root) {
        v.resize(101);
        dfs(root);
        treeChange(root);
        return root;
    }
};