using namespace std;

class Solution {
public:
  int h;
  int w;
  int maxMove;
  int mod = 1000000007;
  vector<int> dx = {0, 1, 0, -1};
  vector<int> dy = {-1, 0, 1, 0};
  bool isOutOfRange(int y, int x) { return y < 0 || y >= h || x < 0 || x >= w; }
  vector<vector<vector<int>>> dp;

  int dfs(int y, int x, int moveCount) {
    if (isOutOfRange(y, x)) {
      return 1;
    }

    if (maxMove <= moveCount) {
      return 0;
    }

    if (dp[moveCount][y][x] != -1) {
      return dp[moveCount][y][x];
    }

    dp[moveCount][y][x] = 0;

    for (int i = 0; i < 4; i++) {
      int ny = y + dy[i];
      int nx = x + dx[i];
      dp[moveCount][y][x] = (dp[moveCount][y][x] + dfs(ny, nx, moveCount + 1)) % mod;
    }

    return dp[moveCount][y][x];
  };

  int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
    this->h = m;
    this->w = n;
    this->maxMove = maxMove;
    this->dp = vector<vector<vector<int>>>(maxMove, vector<vector<int>>(h, vector<int>(w, -1)));
    return dfs(startRow, startColumn, 0) % mod;
  };
};
