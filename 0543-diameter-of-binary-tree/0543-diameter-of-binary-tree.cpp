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
  int answer=1;
  int dfs(TreeNode* cur){
    int left=0;
    int right=0;
    if(cur->left!=nullptr){
      left=dfs(cur->left);
    }
    if(cur->right!=nullptr){
      right=dfs(cur->right);
    }
    answer=max(answer,left+right+1);
    return max(left,right)+1;
  }
  int diameterOfBinaryTree(TreeNode* root) {
    dfs(root);
    return answer-1;
  }
};;