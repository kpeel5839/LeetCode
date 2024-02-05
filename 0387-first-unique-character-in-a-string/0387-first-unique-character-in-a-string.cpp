class Solution {
public:
    int firstUniqChar(string s) {
      vector<int> count(26, 0);
      
      for (auto v : s) {
        count[v - 'a']++;
      }
      
      for (int i = 0; i < s.length(); i++) {
        if (count[s.at(i) - 'a'] == 1) {
          return i;
        }
      }
      return -1;
    }
};