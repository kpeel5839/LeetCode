class Solution {
public:
    int numSubarraysWithSum(vector<int>& nums, int goal) {
      nums.push_back(1);
      int n=nums.size();
      vector<int> cnt(n,1);
      int zeroCount=0;
      for(int i=0;i<n;i++){
        if(nums[i]==0){
          zeroCount++;
        }
        if(nums[i]==1){
          for(int j=i-1;0<=j;j--){
            if(nums[j]==1){
              break;
            }
            cnt[j]=zeroCount+1;
          }
          zeroCount=0;
        }
      }
      int l=0;
      int answer=0;
      int sum=0;
      for(int i=0;i<n-1;i++){
        sum+=nums[i];
        while(goal<sum&&l!=i){
          sum-=nums[l++];
        }
        if(sum==goal){
          answer+=min(i-l+1,cnt[l]);
        }
      }
      return answer;
    }
};