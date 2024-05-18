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
    vector<vector<int>>graph;
    vector<int>coins;
    int nodeNumber=0;
    int dfs(TreeNode*cur){
        int curNodeNumber=nodeNumber++;
        if(cur->left!=nullptr){
            int leftNodeNumber=dfs(cur->left);
            graph[curNodeNumber].push_back(leftNodeNumber);
            graph[leftNodeNumber].push_back(curNodeNumber);
        }
        if(cur->right!=nullptr){
            int rightNodeNumber=dfs(cur->right);
            graph[curNodeNumber].push_back(rightNodeNumber);
            graph[rightNodeNumber].push_back(curNodeNumber);
        }
        coins[curNodeNumber]=cur->val;
        return curNodeNumber;
    }
    int distributeCoins(TreeNode* root) {
        int n=100;
        graph.resize(n+1);
        coins.resize(n+1);
        dfs(root);
        queue<vector<int>>q;
        for(int i=0;i<=n;i++){
            if(coins[i]<=1){
                continue;
            }
            q.push({i,0,i});
        }
        int answer=0;
        while(q.size()!=0){
            vector<int>p=q.front();q.pop();
            if(coins[p[2]]==1){
                continue;
            }
            for(int next:graph[p[0]]){
                if(coins[next]==0){
                    answer+=(p[1]+1);
                    coins[p[2]]--;
                    coins[next]++;
                }
                if(p[2]==next||coins[p[2]]==1){
                    continue;
                }
                q.push({next,p[1]+1,p[2]});
            }
        }
        return answer;
    }
};