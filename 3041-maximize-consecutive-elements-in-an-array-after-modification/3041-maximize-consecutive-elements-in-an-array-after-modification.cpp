class Solution {
public:
  typedef vector<int> vi;
  typedef vector<vi> vii;
  typedef vector<vii> viii;
  int maxSelectedElements(vector<int>& nums) {
    sort(nums.begin(),nums.end());
    int n=nums.size();
    vii dp(2,vi(nums.size(),1));
    map<int,int>m;
    int answer=1;
    for(int i=0;i<n;i++){
      if(m.find(nums[i])!=m.end()){
        int index=m[nums[i]];
        dp[1][i]=max(dp[1][i],dp[0][index]+1);
      }
      if(m.find(nums[i]-1)!=m.end()){
        int index=m[nums[i]-1];
        dp[0][i]=max(dp[0][i],dp[0][index]+1);
        dp[1][i]=max(dp[1][i],dp[1][index]+1);
      }
      if(m.find(nums[i]-2)!=m.end()){
        int index=m[nums[i]-2];
        dp[0][i]=max(dp[0][i],dp[1][index]+1);
      }
      answer=max(answer,dp[0][i]);
      answer=max(answer,dp[1][i]);
      m[nums[i]]=i;
    }
    return answer;
  }
};