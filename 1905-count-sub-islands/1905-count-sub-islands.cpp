class Solution {
public:
    typedef vector<int>vi;
    typedef vector<vi>vii;
    typedef vector<bool>vb;
    typedef vector<vb>vbb;
    vii islands;
    vi dy={-1,0,1,0};
    vi dx={0,1,0,-1};
    int h;
    int w;
    vii g1;
    vii g2;
    vbb visited;
    bool isOutOfRange(int y,int x){
        return y<0||y>=h||x<0||x>=w;
    }
    void bfs(int y,int x,int index){
        queue<vi>q;
        set<pair<int,int>>s;
        q.push({y,x});
        s.insert({y,x});
        visited[y][x]=true;
        while(!q.empty()){
            vi p=q.front();q.pop();
            for(int i=0;i<4;i++){
                int ny=p[0]+dy[i];
                int nx=p[1]+dx[i];
                if(isOutOfRange(ny,nx)||visited[ny][nx]||g2[ny][nx]==0){
                    continue;
                }
                visited[ny][nx]=true;
                s.insert({ny,nx});
                q.push({ny,nx});
            }
        }
        for(auto v:s){
            if(g1[v.first][v.second]!=1){
                return;
            }
        }
        for(auto v:s){
            islands[v.first][v.second]=index;
        }
    }
    int countSubIslands(vector<vector<int>>& grid1, vector<vector<int>>& grid2) {
        h=grid1.size();
        w=grid1[0].size();
        g1=grid1;
        g2=grid2;
        islands=vii(h,vi(w));
        visited=vbb(h,vb(w));
        int index=0;
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                if(g2[i][j]==1&&!visited[i][j]){
                    bfs(i,j,++index);
                }
            }
        }
        set<int>s;
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                cout<<islands[i][j]<<" ";
                if(islands[i][j]!=0){
                    s.insert(islands[i][j]);
                }
            }
            cout<<"\n";
        }
        return s.size();
    }
};