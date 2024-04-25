class Solution {
public:
  vector<int>nums;
  vector<int>andValues;
  vector<vector<unordered_map<int,int>>>dp;
  int n,m;
  int dfs(int idx,int aIdx,int And){
    if(idx==n){
      if(aIdx==m){
        return 0;
      }
      return 1e8;
    }
    if(aIdx==m){
      return 1e8;
    }
    if(dp[aIdx][idx][And]){
      return dp[aIdx][idx][And];
    }
    int inclu=1e8;
    if((And&nums[idx])==andValues[aIdx]){
      inclu=dfs(idx+1,aIdx+1,(1<<17)-1)+nums[idx];
    }
    int exclu=dfs(idx+1,aIdx,And&nums[idx]);
    return dp[aIdx][idx][And]=min(inclu,exclu);
  }
  int minimumValueSum(vector<int>& nums, vector<int>& andValues) {
    this->nums=nums;
    this->andValues=andValues;
    this->n=nums.size();this->m=andValues.size();
    dp.resize(m,vector<unordered_map<int,int>>(n));
    int result=dfs(0,0,(1<<17)-1);
    return result==1e8?-1:result;
  }
};