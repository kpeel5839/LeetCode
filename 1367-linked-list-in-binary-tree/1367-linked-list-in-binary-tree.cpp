/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
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
    typedef vector<vi>vii;
    vi values;
    vii list;
    void dfs(TreeNode*cur,vi sublist){
        if(cur==nullptr){
            list.push_back(sublist);
            return;
        }
        sublist.push_back(cur->val);
        dfs(cur->left,sublist);
        dfs(cur->right,sublist);
    }
    bool isSubPath(ListNode* head, TreeNode* root) {
        ListNode*cur=head;
        while(cur!=nullptr){
            values.push_back(cur->val); cur=cur->next;
        }
        dfs(root,{});
        int totalSize=0;
        for(int i=0;i<list.size();i++){
            for(int j=0;j+(int)values.size()<=list[i].size();j++){
                for(int c=0;c<values.size();c++){
                    if(list[i][j+c]!=values[c]){
                        break;
                    }
                    if(c+1==values.size()){
                        return true;
                    }
                }
            }
        }
        return false;
    }
};