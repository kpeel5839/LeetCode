class Solution {
public:
  
  typedef vector<int> vi;
  typedef vector<vi> vii;
  typedef vector<vii> viii;
  
  int h;
  int w;
  vi dx = {-1, 0, 1};
  viii dp;
  vii grid;
  
  bool isOutOfRange(int x) {
    return x < 0 || x >= w;
  }
  
  int dfs(int row, int col1, int col2) {
    if (row == h - 1) {
      return 0;
    }
    
    if (dp[row][col1][col2] != -1) {
      return dp[row][col1][col2];
    }
    
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        int nCol1 = col1 + dx[i];
        int nCol2 = col2 + dx[j];
        
        if (isOutOfRange(nCol1) || isOutOfRange(nCol2)) {
           continue;
        }
        
        if (nCol1 == nCol2) {
          dp[row][col1][col2] = max(dp[row][col1][col2], dfs(row + 1, nCol1, nCol2) + grid[row + 1][nCol1]);
        } else {
          dp[row][col1][col2] = max(dp[row][col1][col2], dfs(row + 1, nCol1, nCol2) + grid[row + 1][nCol1] + grid[row + 1][nCol2]);
        }
      }
    }
    return dp[row][col1][col2];
  }
  
  int cherryPickup(vector<vector<int>>& grid) {
    this->h = grid.size();
    this->w = grid[0].size();
    dp = viii(h, vii(w, vi(w, -1)));
    this->grid = grid;
    return dfs(0, 0, w - 1) + grid[0][0] + grid[0][w - 1];
  }
};