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
    map<int,TreeNode*>m;
    TreeNode* createBinaryTree(vector<vector<int>>& des) {
        set<int>s;
        for(auto&v:des){
            m[v[0]]=new TreeNode(v[0]);
            m[v[1]]=new TreeNode(v[1]);
            s.insert(v[1]);
        }
        int rootNodeValue=0;
        for(auto&v:des){
            if(s.find(v[0])==s.end()){
                rootNodeValue=v[0];
            }
            if(v[2]==1){
                m[v[0]]->left=m[v[1]];
            }else{
                m[v[0]]->right=m[v[1]];
            }
        }
        return m[rootNodeValue];
    }
};