class Solution {
public:
  int firstMissingPositive(vector<int>& nums) {
    unordered_set<int>s;
    for(auto&v:nums){
      s.insert(v);
    }
    for(int i=1;i<=1e5+1;i++){
      if(s.find(i)!=s.end()){
        continue;
      }
      return i;
    }
    return -1;
  }
};