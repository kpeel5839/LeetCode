class Solution {
public:
  vector<int> productExceptSelf(vector<int>& nums) {
    int n=nums.size();
    vector<int>lr(n+2,1);
    vector<int>rl(n+2,1);
    for(int i=1;i<=n;i++){
      lr[i]=lr[i-1]*nums[i-1];
    }
    for(int i=n;1<=i;i--){ 
      rl[i]=rl[i+1]*nums[i-1];
    }
    vector<int>answer;
    for(int i=1;i<=n;i++){
      answer.push_back(lr[i-1]*rl[i+1]);
    }
    return answer;
  }
};