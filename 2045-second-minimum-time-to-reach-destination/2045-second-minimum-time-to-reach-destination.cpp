class Solution {
public:
    typedef vector<int>vi;
    typedef vector<vi>vii;
    vii graph;
    int getCnt(int n,int start,int end){
        vii dist(n+1);
        queue<vi>q;
        q.push({start,0});
        dist[start].push_back(0);
        vi answer;
        while(q.size()!=0){
            vi p=q.front();q.pop();
            for(int next:graph[p[0]]){
                if(dist[next].size()==0||(dist[next].size()<2&&p[1]+1<n*2&&p[1]+1>dist[next].back())){
                    dist[next].push_back(p[1]+1);
                    q.push({next,p[1]+1});
                    if(next==n){
                        answer.push_back(dist[next].back());
                    }
                }
            }
        }
        sort(answer.begin(),answer.end());
        return answer[1];
    }

    int secondMinimum(int n, vector<vector<int>>& edges, int time, int change) {
        graph=vii(n+1);
        for(int i=0;i<edges.size();i++){
            graph[edges[i][0]].push_back(edges[i][1]);
            graph[edges[i][1]].push_back(edges[i][0]);
        }
        int resultCnt=getCnt(n,1,n);
        int answer=0;
        for(int i=0;i<resultCnt;i++){
            if((answer/change)%2==1){
                answer=((answer/change)+1)*change;
            }
            answer+=time;
        }
        return answer;
    }
};
