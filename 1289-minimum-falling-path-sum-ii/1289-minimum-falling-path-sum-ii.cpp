class Solution {
public:
  typedef long long ll;
  typedef vector<ll>vl;
  typedef vector<vl>vll;
  vl dx={-1,1};
  int h,w;
  vll dp;
  bool isOutOfRange(int y,int x){
    return y<0||y>=h||x<0||x>=w;
  }
  int minFallingPathSum(vector<vector<int>>& grid) {
    h=grid.size();w=grid[0].size();
    dp.resize(h,vl(w,1e8));
    for(int i=0;i<w;i++){
      dp[0][i]=grid[0][i];
    }
    for(int i=1;i<h;i++){
      for(int j=0;j<w;j++){
        for(int c=0;c<w;c++){
          if(j==c){
            continue;
          }
          dp[i][j]=min(dp[i][j],grid[i][j]+dp[i-1][c]);
        }
      }
    }
    return (int)*min_element(dp[h-1].begin(),dp[h-1].end());
  }
};