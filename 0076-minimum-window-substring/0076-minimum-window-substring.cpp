class Solution {
public:
    
  bool isMatch(map<char, int>& ss, map<char, int>& tt) {
    //for (auto v : ss) {
    //  printf("ss[%c] : %d\n", v.first, v.second);
    //}
    
    //cout << "\n";
    
    for (auto v : tt) {
      char key = v.first;
      if (tt[key] > ss[key]) {
        return false;
      }
    }
    
    return true;
  }
  
  string minWindow(string s, string t) {
    map<char, int> ss;
    map<char, int> tt;
    int l = 0;

    for (char c : t) {
      tt[c]++;
    }
    
    int answer = INT_MAX;
    int left = 0;
    int right = 0;

    for (int i = 0; i < s.length(); i++) {
      ss[s.at(i)]++;

      // cout << "right is " << i << "\n";
      while (l <= i && isMatch(ss, tt)) {
        int length = i - l + 1;
        
        if (length < answer) {
          left = l;
          right = i;
          answer = length;
        }
        
        ss[s.at(l)]--;
        l++;
      }
    }

    return answer == INT_MAX ? "" : s.substr(left, right - left + 1);
  }
};