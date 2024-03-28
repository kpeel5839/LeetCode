class Solution {
public:
  int maxSubarrayLength(vector<int>& nums, int k) {
    int l=0;
    map<int,int>m;
    int answer=1;
    for(int i=0;i<nums.size();i++){
      m[nums[i]]++;
      while(l!=i&&k<m[nums[i]]){
        m[nums[l++]]--;
      }
      answer=max(answer,i-l+1);
    }
    return answer;
  }
};