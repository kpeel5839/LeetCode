class Solution {
public:
  long long countSubarrays(vector<int>& nums, int minK, int maxK) {
    map<int,int>m;
    int n=nums.size();
    int lower=0;
    int l=0;
    long long answer=0;
    for(int i=0;i<n;i++){
      if(nums[i]<minK||maxK<nums[i]){
        m=map<int,int>();
        lower=i+1;
        l=i+1;
        continue;
      }
      m[nums[i]]++;
      while(l!=i&&(nums[l]!=minK&&nums[l]!=maxK)||1<m[nums[l]]){
        m[nums[l++]]--;
      }
      if(1<=m[minK]&&1<=m[maxK]){
        answer+=(l-lower+1);
      }
    }
    return answer;
  }
};