class Solution {
public:
  typedef vector<int>vi;
  typedef vector<vi>vii;
  vi dx={0,1,0,-1};
  vi dy={-1,0,1,0};
  int h,w;
  bool isOutOfRange(int y,int x){
    return y<0||y>=h||x<0||x>=w;
  }
  int islandPerimeter(vector<vector<int>>& grid) {
    h=grid.size();w=grid[0].size();
    int answer=0;
    for(int i=0;i<h;i++){
      for(int j=0;j<w;j++){
        if(grid[i][j]==0){
          continue;
        }
        for(int dir=0;dir<4;dir++){
          int ny=i+dy[dir];
          int nx=j+dx[dir];
          if(isOutOfRange(ny,nx)||grid[ny][nx]==0){
            answer++;
          }
        }
      }
    }
    return answer;
  }
};