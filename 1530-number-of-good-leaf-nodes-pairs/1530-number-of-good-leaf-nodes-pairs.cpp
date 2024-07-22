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
    typedef vector<bool>vb;
    typedef vector<vi>vii;
    typedef vector<vii>viii;
    int MAX_SIZE=1024;
    int nodeNumber=1;
    vii graph;
    vii dist;
    vb leaf;
    void makeGraph(TreeNode*cur){
        if(cur==nullptr){
            return;
        }
        bool isLeaf=true;
        int rootNodeNumber=nodeNumber;
        if(cur->left!=nullptr){
            nodeNumber++;
            graph[rootNodeNumber].push_back(nodeNumber);
            graph[nodeNumber].push_back(rootNodeNumber);
            makeGraph(cur->left);
            isLeaf=false;
        }
        if(cur->right!=nullptr){
            nodeNumber++;
            graph[rootNodeNumber].push_back(nodeNumber);
            graph[nodeNumber].push_back(rootNodeNumber);
            makeGraph(cur->right);
            isLeaf=false;
        }
        if(isLeaf){
            leaf[rootNodeNumber]=true;
        }
    }
    void go(int start){
        queue<vi>q;
        q.push({start,0});
        while(q.size()!=0){
            vi a=q.front();q.pop();
            for(int next:graph[a[0]]){
                if(dist[start][next]==-1){
                    q.push({next,a[1]+1});
                    dist[start][next]=a[1]+1;
                }
            }
        }
    }
    int countPairs(TreeNode* root, int distance) {
        graph=vii(MAX_SIZE+1);
        dist=vii(MAX_SIZE+1,vi(MAX_SIZE+1,-1));
        leaf=vb(MAX_SIZE+1,false);
        makeGraph(root);
        vector<int>leafs;
        for(int i=1;i<=MAX_SIZE;i++){
            if(leaf[i]){
                go(i);
                leafs.push_back(i);
            }
        }
        int answer=0;
        for(int i=0;i<leafs.size();i++){
            for(int j=i+1;j<leafs.size();j++){
                if(dist[leafs[i]][leafs[j]]<=distance){
                    answer++;
                }
            }
        }
        return answer;
    }
};