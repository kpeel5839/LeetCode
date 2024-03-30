class Solution {
public:
  int subarraysWithKDistinct(vector<int>& nums, int k) {
    int lower=0; 
    int l=0;
    int cnt=0;
    unordered_map<int,int>m;
    int n=nums.size();
    int answer=0;
    for(int i=0;i<n;i++){
      int v=nums[i];
      if(m[v]==0){
        cnt++;
      }
      m[v]++;
      while(l!=i&&k<cnt){
        int vv=nums[l++];
        m[vv]--;
        if(m[vv]==0){
          cnt--;
        }
        lower=l;
      }
      while(i!=l&&k==cnt&&1<m[nums[l]]){//최대한땡겨줌
        m[nums[l]]--;
        l++;
      }
      if(k==cnt){
        answer+=(l-lower+1);
      }
    }
    return answer;
  }
};