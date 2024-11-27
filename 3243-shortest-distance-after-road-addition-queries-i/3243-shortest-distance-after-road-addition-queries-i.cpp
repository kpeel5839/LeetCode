class Solution {
public:
    typedef vector<int>vi;
    typedef vector<vi>vii;
    int n;
    vi visited;
    vii queries;
    vii graph;
    int bfs(){
        visited=vi(n,-1);
        queue<vi>q;
        q.push({0,0});
        visited[0]=0;
        while(!q.empty()){
            vi p=q.front();q.pop();
            if(p[0]==n-1){
                return p[1];
            }
            for(int i=0;i<graph[p[0]].size();i++){
                int next=graph[p[0]][i];
                if(visited[next]!=-1){
                    continue;
                }
                visited[next]=p[1]+1;
                q.push({next,p[1]+1});
            }
        }
        return -1;
    }
    vector<int> shortestDistanceAfterQueries(int n, vector<vector<int>>& queries) {
        this->n=n;
        this->queries=queries;
        graph=vii(n,vi());
        for(int i=0;i<n-1;i++){
            graph[i].push_back(i+1);
        }
        vi answer;
        for(int i=0;i<queries.size();i++){
            cout<<"queries : "<<queries[i][0]<<" "<<queries[i][1]<<"\n";
            graph[queries[i][0]].push_back(queries[i][1]);
            answer.push_back(bfs());
        }
        return answer;
    }
};