class Solution {
public:
  int majorityElement(vector<int>& nums) {
    int count = floor(nums.size() / 2.0);
    map<int, int> m;
    
    for (auto v : nums) {
      m[v]++;
      
      if (count < m[v]) {
        return v;
      }
    }
    
    return -1;
  }
};