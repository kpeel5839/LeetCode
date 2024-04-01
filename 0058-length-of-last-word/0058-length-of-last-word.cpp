class Solution {
public:
  int lengthOfLastWord(string s) {
    stringstream ss(s);
    string token;
    int answer=0;
    while(ss>>token){
      int size=token.size();
      answer=size;
    }
    return answer;
  }
};