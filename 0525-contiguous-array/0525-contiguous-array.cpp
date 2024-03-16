class Solution {
public:
  int findMaxLength(vector<int>& nums) {
    int answer=0;
    unordered_map<int,int>m;
    m[0]=-1;
    int sum=0;
    for(int i=0;i<nums.size();i++){
      sum+=(nums[i]==0?-1:1);
      if(m.find(sum)!=m.end()){
        answer=max(answer,i-m[sum]);
        continue;
      }
      m[sum]=i;
    }
    return answer;
  }
};