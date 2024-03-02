class Solution {
public:
  vector<int> sortedSquares(vector<int>& nums) {
    vector<int>answer;
    for(int i=0;i<nums.size();i++){
      answer.push_back(nums[i]*nums[i]);
    }
    sort(answer.begin(),answer.end(),[](int o1,int o2){
      return o1<o2;
    });
    return answer;
  }
};