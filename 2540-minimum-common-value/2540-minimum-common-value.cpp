class Solution {
public:
  int getCommon(vector<int>& nums1, vector<int>& nums2) {
    set<int>s;
    for(auto v:nums2){
      s.insert(v);
    }
    for(auto v:nums1){
      if(s.find(v)!=s.end()){
        return v;
      }
    }
    return -1;
  }
};