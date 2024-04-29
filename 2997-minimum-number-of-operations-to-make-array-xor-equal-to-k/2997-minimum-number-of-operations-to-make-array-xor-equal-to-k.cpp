class Solution {
public:
  int minOperations(vector<int>& nums, int k) {
    int n=nums.size();
    int answer=0;
    for(int i=0;i<32;i++){
      int oneCnt=0;
      for(int j=0;j<n;j++){
        if((nums[j]&(1<<i))!=0){
          oneCnt++;
        }
      }
      if((k&(1<<i))!=0){//짝수개로맞추어ㅑ함
        if(oneCnt%2==0){
          answer++;
        }
      }else{
        if(oneCnt%2==1){
          answer++;
        }
      }
    }
    return answer++;
  }
};