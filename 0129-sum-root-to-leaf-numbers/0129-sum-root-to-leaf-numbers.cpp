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
  int answer=0;
  void dfs(TreeNode*cur,int v){
    bool leaf=true;
    v+=cur->val;
    if(cur->left!=nullptr){
      dfs(cur->left,v*10);
      leaf=false;
    }
    if(cur->right!=nullptr){
      dfs(cur->right,v*10);
      leaf=false;
    }
    if(leaf){
      answer+=v;
    }
  }
  int sumNumbers(TreeNode* root) {
    dfs(root,0);
    return answer;
  }
};