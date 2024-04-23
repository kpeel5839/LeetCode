class Solution {
public:
  typedef vector<int>vi;
  typedef vector<vi>vii;
  typedef vector<vii>viii;
  vii graph;
  vi cnt;
  vector<int> findMinHeightTrees(int n, vector<vector<int>>& edges) {
    if(n==1){
      return {0};
    }
    graph=vii(n);
    cnt=vi(n);
    for(int i=0;i<edges.size();i++){
      graph[edges[i][0]].push_back(edges[i][1]);
      graph[edges[i][1]].push_back(edges[i][0]);
      cnt[edges[i][0]]++;
      cnt[edges[i][1]]++;
    }
    queue<int>q;
    int process=0;
    for(int i=0;i<n;i++){
      if(cnt[i]==1){
        q.push(i);
      }
    }
    while(n-process>2){
      int size=q.size();
      process+=size;
      for(int i=0;i<size;i++){
        int cur=q.front();q.pop();
        for(int next:graph[cur]){
          if(--cnt[next]==1){
            q.push(next);
          }
        }
      }
    }
    vi ans;
    while(q.size()!=0){
      ans.push_back(q.front());q.pop();
    }
    return ans;
  }
};