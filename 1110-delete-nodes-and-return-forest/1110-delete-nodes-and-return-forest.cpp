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
    set<int>deleted;
    vector<TreeNode*>roots;
    void dfs(TreeNode*cur,TreeNode* parent){
        if(cur==nullptr){
            return;
        }
        if(deleted.find(cur->val)!=deleted.end()){
            if(parent!=nullptr){
                if(parent->left==cur){
                    parent->left=nullptr;
                }
                if(parent->right==cur){
                    parent->right=nullptr;
                }
            }
            if(cur->left!=nullptr){
                roots.push_back(cur->left);
            }
            if(cur->right!=nullptr){
                roots.push_back(cur->right); 
            }
        }
        if(cur->left!=nullptr){
            dfs(cur->left,cur);
        }
        if(cur->right!=nullptr){
            dfs(cur->right,cur);
        }
    }
    vector<TreeNode*> delNodes(TreeNode* root, vector<int>& to_delete) {
        for(auto v:to_delete)deleted.insert(v);
        roots.push_back(root);
        dfs(root,nullptr);
        vector<TreeNode*>answer;
        for(auto v:roots){
            if(deleted.find(v->val)==deleted.end()){
                answer.push_back(v);
            }
        }
        return answer;
    }
};