class Solution {
public:
  typedef vector<int>vi;
  typedef vector<bool>vb;
  typedef vector<vi>vii;
  typedef vector<vb>vbb;
  int h,w;
  vbb visited;
  vii land;
  vi dx={-1,0,1,0};
  vi dy={0,1,0,-1};
  bool isOutOfRange(int y,int x){
    return y<0||y>=h||x<0||x>=w;
  }
  vi bfs(int y,int x){
    vi mi={y,x};
    vi ma={y,x};
    queue<vi>q;
    visited[y][x]=true;
    q.push({y,x});
    while(q.size()!=0){
      vi p=q.front();q.pop();
      for(int i=0;i<4;i++){
        int ny=p[0]+dy[i];
        int nx=p[1]+dx[i];
        if(isOutOfRange(ny,nx)||visited[ny][nx]||land[ny][nx]!=1){
          continue;
        }
        visited[ny][nx]=true;
        q.push({ny,nx});
        if(mi[0]>=ny){
          if(mi[0]==ny){
            if(mi[1]>nx){
              mi[0]=ny;
              mi[1]=nx;
            }
          }else{
            mi[0]=ny;
            mi[1]=nx;
          }
        }
        if(ma[0]<=ny){
          if(ma[0]==ny){
            if(ma[1]<nx){
              ma[0]=ny;
              ma[1]=nx;
            }
          }else{
            ma[0]=ny;
            ma[1]=nx;
          }
        }
      }
    }
    return {mi[0],mi[1],ma[0],ma[1]};
  }
  vector<vector<int>> findFarmland(vector<vector<int>>& land) {
    this->land=land;
    h=land.size();w=land[0].size();
    visited=vbb(h,vb(w,false));
    vii answer;
    for(int i=0;i<h;i++){
      for(int j=0;j<w;j++){
        if(land[i][j]==1&&!visited[i][j]){
          answer.push_back(bfs(i,j));
        }
      }
    }
    return answer;
  }
};