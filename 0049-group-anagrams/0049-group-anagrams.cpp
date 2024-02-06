class Solution {
public:
  typedef long long ll;
  typedef vector<int> vi;
  typedef vector<string> vs;
  typedef vector<vs> vss;
  vector<vector<string>> groupAnagrams(vector<string>& strs) {
    map<vi, vs> m;
    
    for (string s : strs) {
      vi count(26, 0);
        
      for (auto c : s) {
        int digit = c - 'a';
        count[digit]++;
      }
      
      m[count].push_back(s);
    }
    
    vss answer;
    for (auto v : m) {
      answer.push_back(v.second);
    }
    return answer;
  }
};