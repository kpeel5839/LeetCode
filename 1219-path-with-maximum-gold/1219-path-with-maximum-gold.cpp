class Solution {
public:
    typedef vector<int> vi;
    typedef vector<vi> vii;
    typedef vector<vii> viii;
    typedef vector<viii> viiii;
    vi dy={-1,0,1,0};
    vi dx={0,1,0,-1};
    int h,w;
    vii visited;
    int answer=0;
    vii g;
    bool isOutOfRange(int y,int x){
        return y<0||y>=h||x<0||x>=w;
    }
    void dfs(int y,int x,int gold){
        if(g[y][x]==0){
            return;
        }
        gold+=g[y][x];
        answer=max(answer,gold);
        for(int i=0;i<4;i++){
            int ny=y+dy[i];
            int nx=x+dx[i];
            if(isOutOfRange(ny, nx)||visited[ny][nx]){
                continue;
            }
            visited[y][x]=1;
            dfs(ny,nx,gold);
            visited[y][x]=0;
        }
    }
    int getMaximumGold(vector<vector<int>>& grid) {
        h=grid.size();
        w=grid[0].size();
        g=grid;
        visited=vii(h,vi(w,0));
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                if(g[i][j]!=0){
                    dfs(i,j,0);
                }
            }
        }
        return answer;
    }
};