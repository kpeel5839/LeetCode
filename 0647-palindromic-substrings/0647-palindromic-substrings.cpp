class Solution {
public:
  typedef vector<bool> vb;
  typedef vector<vb> vbb;
  
  int countSubstrings(string s) {
    int answer = 0;
    int n = s.length();
    vbb isP(n, vb(n, false));
    
    for (int i = 0; i < n; i++) {
      isP[i][i] = true;
      answer++;
    }
    
    for (int i = 2; i <= n; i++) {
      for (int j = 0; j < n - i + 1; j++) {
        if (i == 2) {
          if (s.at(j) == s.at(j + i - 1)) {
            isP[j][j + i - 1] = true;
          }
        } else {
          if (s.at(j) == s.at(j + i - 1) && isP[j + 1][j + i - 2]) {
            isP[j][j + i - 1] = true;
          }
        }
        
        if (isP[j][j + i - 1]) {
          answer++;
        }
      }
    }
    
    return answer;
  }
};