class Solution {
public:
  typedef vector<int>vi;
  typedef vector<vi>vii;
  string s;
  int k,n;
  vii dp;
  int dfs(int idx,int pre){
    if(idx==n){
      return 0;
    }
    if(dp[pre][idx]!=0){
      return dp[pre][idx];
    }
    if(pre==26||abs(pre-(s[idx]-'a'))<=k){
      dp[pre][idx]=dfs(idx+1,s[idx]-'a')+1;
    }
    return dp[pre][idx]=max(dp[pre][idx],dfs(idx+1,pre));
  }
  int longestIdealString(string s, int k) {
    this->s=s;
    this->k=k;n=s.size();
    dp=vii(27,vi(n,0));
    return dfs(0,26);
  }
};