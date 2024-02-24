class Solution {
public:
  typedef vector<int> vi;
  typedef vector<bool> vb;
  typedef vector<vi> vii;
  typedef vector<vii> viii;
  vii m;
  viii graph;
  int n,f;
  struct comp{
    bool operator()(vi&o1,vi&o2){
      return o1[1]>o2[1];
    }
  };
  vi dijkstra(){
    priority_queue<vi,vii,comp>q;//{index,value}
    vb visited(n,false);
    vi answer; 
    q.push({0,0});
    q.push({f,0});
    while(q.size()!=0){
      vi p=q.top();q.pop();
      if(visited[p[0]]){
        continue;
      }
      visited[p[0]]=true;
      answer.push_back(p[0]);
      for(auto v:graph[p[0]]){
        if(visited[v[0]]||v[1]<p[1]){
          continue;
        }
        q.push({v[0],v[1]});
      }
    }
    return answer;
  }
  vector<int> findAllPeople(int n, vector<vector<int>>& m, int firstPerson) {
    this->m=m;
    this->n=n;
    this->f=firstPerson;
    graph=viii(n);
    for(auto v:m){
      graph[v[0]].push_back({v[1],v[2]});
      graph[v[1]].push_back({v[0],v[2]});
    }
    return dijkstra();
  }
};