class Solution {
public:
  string firstPalindrome(vector<string>& words) {
    for(string s: words){
      int n=s.length();
      for(int i=0; i<n; i++){
        if(s.at(i)!=s.at(n-i-1)){
          break;
        }
        if(i==n-1){
          return s;
        }
      }
    }
    return "";
  }
};