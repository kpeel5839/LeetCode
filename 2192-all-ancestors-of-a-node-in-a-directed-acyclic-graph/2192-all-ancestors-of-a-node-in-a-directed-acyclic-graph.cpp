class Solution {
public:
    typedef vector<int>vi;
    typedef vector<vi>vii;
    typedef vector<bool>vb;
    map<int,vi>m;
    vii answer;
    vb visited;
    void getAncestor(int cur,int parent){
        if(visited[cur]){
            return;
        }
        visited[cur]=true;
        if(cur!=parent){
            answer[parent].push_back(cur);
        }
        for(auto v:m[cur]){
            getAncestor(v,parent);
        }
    }
    vector<vector<int>> getAncestors(int n, vector<vector<int>>& edges) {
        answer.resize(n);
        for(int i=0;i<edges.size();i++){
            m[edges[i][1]].push_back(edges[i][0]);
        }
        for(int i=0;i<n;i++){
            visited=vb(n,false); 
            getAncestor(i,i);
        }
        for(int i=0;i<answer.size();i++){
            sort(answer[i].begin(),answer[i].end());
        }
        return answer;
    }
};