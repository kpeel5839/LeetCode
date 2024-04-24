class Solution {
public:
  map<int,int>dp;
  int dfs(int n){
    if(n==0){
      return 0;
    }else if(n==1){
      return 1;
    }else if(n==2){
      return 1;
    }
    if(dp.find(n)!=dp.end()){
      return dp[n];
    }
    return dp[n]=dfs(n-1)+dfs(n-2)+dfs(n-3);
  }
  int tribonacci(int n) {
    return dfs(n);
  }
};