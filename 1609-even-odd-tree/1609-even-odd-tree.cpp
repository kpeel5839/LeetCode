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
  bool success=true;
  map<int,int>m;
  void dfs(TreeNode* cur,int row){
    if(!success){
      return;
    }
    if(row%2==cur->val%2){
      success=false;
      return;
    }
    if(m.find(row)!=m.end()){
      if(row%2==0&&(m[row]>=cur->val)){
        success=false;
      }
      if(row%2==1&&(m[row]<=cur->val)){
        success=false;
      }
    }
    m[row]=cur->val;
    if(cur->left!=nullptr){
      dfs(cur->left,row+1);
    }
    if(cur->right!=nullptr){
      dfs(cur->right,row+1);
    }
  }
  bool isEvenOddTree(TreeNode* root) {
    dfs(root,0);
    return success;
  }
};