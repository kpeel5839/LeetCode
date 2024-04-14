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
  void dfs(TreeNode* cur,bool isLeft){
    if(cur==nullptr){
      return;
    }
    int childCnt=0;
    if(cur->left!=nullptr){
      dfs(cur->left,true);
      childCnt++;
    }
    if(cur->right!=nullptr){
      dfs(cur->right,false);
      childCnt++;
    }
    if(childCnt==0&&isLeft){
      answer+=cur->val;
    }
  }
  int sumOfLeftLeaves(TreeNode* root) {
    dfs(root,false);
    return answer;
  }
};