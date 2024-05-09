class Solution {
public:
  
  long long maximumHappinessSum(vector<int>& h, int k) {
    sort(h.begin(),h.end(),[](int o1,int o2){
      return o1>o2;
    });
    long long sum=0;
    for(int i=0;i<k;i++){
      if(h[i]-i<=0){
        break;
      }
      sum+=(h[i]-i);
    }
    return sum;
  }
};