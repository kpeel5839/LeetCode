class Solution {
public:
  int findDuplicate(vector<int>& nums) {
    set<int> s;
    for(auto v:nums){
      if(s.find(v)!=s.end()){
        return v;
      }
      s.insert(v);
    }
    return -1;
  }
};