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
    typedef vector<int>vi;
    vi list;
    void dfs(TreeNode*cur){
        if(cur==nullptr){
            return;
        }
        list.push_back(cur->val);
        dfs(cur->left);
        dfs(cur->right);
    }
    TreeNode* createBST(int l,int r){
        int mid=(l+r)/2;
        TreeNode* cur=new TreeNode(list[mid]);
        if(l!=mid){
            cur->left=createBST(l,mid-1);
        }
        if(r!=mid){
            cur->right=createBST(mid+1,r);
        }
        return cur;
    }
    TreeNode* balanceBST(TreeNode* root) {
        dfs(root);
        sort(list.begin(),list.end());
        int listSize=list.size();
        return createBST(0,list.size()-1);
    }
};