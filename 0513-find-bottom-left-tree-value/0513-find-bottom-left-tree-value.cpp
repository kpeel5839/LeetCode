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
  int maxRow=-1;
  int answer=0;
  void dfs(TreeNode* cur,int row){
    if(maxRow<row){
      maxRow=row;
      answer=cur->val;
    }
    if(cur->left!=nullptr){
      dfs(cur->left,row+1);
    }
    if(cur->right!=nullptr){
      dfs(cur->right,row+1);
    }
  }
  int findBottomLeftValue(TreeNode* root) {
    dfs(root,0);
    return answer;
  }
};