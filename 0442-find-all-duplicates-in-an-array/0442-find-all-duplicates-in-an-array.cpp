class Solution {
public:
  vector<int> findDuplicates(vector<int>& nums) {
    int n=nums.size();
    int add=1e6;
    vector<int>answer;
    for(int i=0;i<nums.size();i++){
      int value=0;
      if(nums[i]<add){
        value=nums[i];
      }else if(add<nums[i]&&nums[i]<add*2){
        value=nums[i]-add;
      }else{
        value=nums[i]-add*2;
      }
      nums[value-1]+=add;
      if(add*2<nums[value-1]){
        answer.push_back(value);
      }
    }
    return answer;
  }
};