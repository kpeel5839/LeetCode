class Solution {
public:
  int firstMissingPositive(vector<int>& nums) {
    int n=nums.size();
    for(auto&v:nums){
      if(v<=0){
        v=n+1;
      }
    }
    for(int i=0;i<n;i++){
      int v=abs(nums[i]);
      if(n<v){
        continue;
      }
      if(nums[v-1]<0){
        continue;
      }
      nums[v-1]*=-1;
    }
    for(int i=0;i<n;i++){
      if(0<=nums[i]){
        return i+1;
      }
    }
    return n+1;
  }
};