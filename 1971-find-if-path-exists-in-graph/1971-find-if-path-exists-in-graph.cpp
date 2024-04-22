class Solution {
public:
  typedef vector<int>vi;
  typedef vector<vi>vii;
  typedef vector<bool>vb;
  vii graph;
  int s,d;
  vb visited;
  bool dfs(int cur){
    if(visited[cur]){
      return false;
    }
    if(cur==d){
      return true;
    }
    visited[cur]=true;
    for(auto next:graph[cur]){
      if(dfs(next)){
        return true;
      }
    }
    return false;
  }
  bool validPath(int n, vector<vector<int>>& edges, int source, int destination) {
    s=source;d=destination;
    visited=vb(n,false);
    graph=vii(n);
    for(int i=0;i<edges.size();i++){
      graph[edges[i][0]].push_back(edges[i][1]);
      graph[edges[i][1]].push_back(edges[i][0]);
    }
    return dfs(s);
  }
};