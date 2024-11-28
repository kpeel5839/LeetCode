class Solution {
public:
    typedef vector<int>vi;
    typedef vector<vi>vii;
    int h;
    int w;
    bool isOutOfRange(int y,int x){
        return y<0||y>=h||x<0||x>=w;
    }
    struct comp{
        bool operator()(vi&o1,vi&o2){
            return o1[2]>o2[2];
        }
    };
    vi dy={-1,0,1,0};
    vi dx={0,1,0,-1};
    int minimumObstacles(vector<vector<int>>& grid) {
        h=grid.size();
        w=grid[0].size();
        priority_queue<vi,vii,comp>pq;
        vii dist(h,vi(w,1e9));
        pq.push({0,0,0});
        dist[0][0]=0;
        while(!pq.empty()){
            vi p=pq.top();pq.pop();
            if(dist[p[0]][p[1]]<p[2]){
                continue;
            }
            if(p[0]==h-1&&p[1]==w-1){
                return p[2];
            }
            for(int i=0;i<4;i++){
                int ny=p[0]+dy[i];
                int nx=p[1]+dx[i];
                if(isOutOfRange(ny,nx)){
                    continue;
                }
                int value=p[2]+grid[ny][nx];
                if(value<dist[ny][nx]){
                    dist[ny][nx]=value;
                    pq.push({ny,nx,value});
                }
            }
        }
        return -1;
    }
};