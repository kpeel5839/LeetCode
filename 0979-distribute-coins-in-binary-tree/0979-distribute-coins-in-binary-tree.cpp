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
    typedef vector<int> vi;
    typedef vector<vi> vii;
    typedef vector<vii> viii;
    int answer=0;
    void add(viii&origin,viii&result){
        for(int i=0;i<result[0].size();i++){
            origin[0].push_back(result[0][i]);
        }
        for(int i=0;i<result[1].size();i++){
            origin[1].push_back(result[1][i]);
        }
    }
    viii dfs(TreeNode* cur){
        viii curArr(2);
        if(cur->val==0){
            curArr[1].push_back({cur->val,0});
        }else if(cur->val!=1){
            curArr[0].push_back({cur->val-1,0});
        }
        if(cur->left!=nullptr){
            viii result=dfs(cur->left);
            add(curArr,result);
        }
        if(cur->right!=nullptr){
            viii result=dfs(cur->right);
            add(curArr,result);
        }
        sort(curArr[0].begin(),curArr[0].end(),[](vi o1,vi o2){
            return o1[1]>o2[1];
        });
        sort(curArr[1].begin(),curArr[1].end(),[](vi o1,vi o2){
            return o1[1]>o2[1];
        });
        int pointer=0;
        // for(int i=0;i<curArr[1].size();i++){
        //     cout<<"{ "<<curArr[1][i][0]<<", "<<curArr[1][i][1]<<" }"<<"\n";
        // }
        // cout<<curArr[1].size()<<"\n";
        for(int i=0;i<curArr[0].size();i++){
            while(pointer!=curArr[1].size()&&curArr[0][i][0]!=0){
                answer+=curArr[0][i][1]+curArr[1][pointer][1];
                // cout<<curArr[0][i][1]<<", "<<curArr[1][pointer][1]<<"\n";
                // cout<<curArr[0][i][0]<<"\n";
                curArr[1][pointer++][0]=-1;
                curArr[0][i][0]--;
            }
        }
        viii resultArr(2);
        for(int i=0;i<curArr[0].size();i++){
            if(curArr[0][i][0]==0){
                continue;
            }
            resultArr[0].push_back({curArr[0][i][0],curArr[0][i][1]+1});
        }
        for(int i=0;i<curArr[1].size();i++){
            if(curArr[1][i][0]==-1){
                continue;
            }
            resultArr[1].push_back({curArr[1][i][0],curArr[1][i][1]+1});
        }
        return resultArr;
    }
    int distributeCoins(TreeNode* root) {
        dfs(root);
        return answer;
    }
};