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
    typedef long long ll;
    typedef vector<ll>vl;
    typedef vector<vl>vll;
    vl de;
    void dfs(TreeNode*cur,int depth){
        if(cur==nullptr){
            return;
        }
        if(!(depth<de.size())){
            de.push_back(0ll);
        }
        de[depth]+=(ll)cur->val;
        if(cur->left!=nullptr){
            dfs(cur->left,depth+1);
        }
        if(cur->right!=nullptr){
            dfs(cur->right,depth+1);
        }
    }
    long long kthLargestLevelSum(TreeNode* root, int k) {
        de=vl();
        dfs(root,0);
        ll n=de.size();
        if(n<k){
            return -1;
        }
        sort(de.begin(),de.end(),[](ll&o1,ll&o2){
            return o1>o2;
        });
        return de[k-1];
    }
};