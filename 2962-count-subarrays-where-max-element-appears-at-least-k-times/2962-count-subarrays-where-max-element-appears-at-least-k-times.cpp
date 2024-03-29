class Solution {
public:
  long long countSubarrays(vector<int>& nums, int k) {
    int n=nums.size();
    int maxElement=0;
    long long answer=0;
    unordered_map<int,vector<int>>m;
    for(int i=0;i<n;i++){
      maxElement=max(maxElement,nums[i]);
      m[nums[i]].push_back(i);
    }
    vector<int>idx=m[maxElement];
    int l=0;
    int cnt=0;
    for(int i=idx[l];i<n;i++){
      if(nums[i]==maxElement){
        cnt++;
      }
      while(k<cnt){
        l++;
        cnt--;
      }
      if(cnt==k){
        answer+=(idx[l]+1);
      }
    }
    return answer;
  }
};