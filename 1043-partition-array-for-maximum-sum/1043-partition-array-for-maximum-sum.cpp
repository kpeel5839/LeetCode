class Solution {
public:
  typedef vector<int> vi;
  typedef vector<vi> vii;
  int n;
  int k;
  vi arr;
  vii dp;
  vii prefix;
  
  int dfs(int index, int kk) {
    if (index == n) {
      return 0;
    }
    
    if (dp[index][kk] != -1) {
      return dp[index][kk];
    }
    
    if (kk == k) {
      return dp[index][kk] = dfs(index + 1, 1) + prefix[index - kk + 1][index] * kk;
    }
    
    return dp[index][kk] = max(dfs(index + 1, kk + 1), dfs(index + 1, 1) + prefix[index - kk + 1][index] * kk);
  }
  
  int maxSumAfterPartitioning(vector<int>& arr, int k) {
    this->n = arr.size();
    this->k = k;
    this->arr = arr;
    this->dp = vii(n, vi(k + 1, -1));
    this->prefix = vii(n, vi(n, 0));
    
    for (int i = 0; i < n; i++) {
      int m = 0;
      for (int j = i; j < n; j++) {
        m = max(m, arr[j]);
        prefix[i][j] = m;
      }
    }
    
    return dfs(0, 1);
  }
};