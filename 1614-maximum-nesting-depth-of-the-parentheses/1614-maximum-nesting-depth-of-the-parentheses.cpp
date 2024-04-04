class Solution {
public:
  int maxDepth(string s) {
    int depth=0;
    int n=s.size();
    int answer=0;
    for(int i=0;i<n;i++){
      char c=s.at(i);
      if(c=='('){
        depth++;
      }else if(c==')'){
        depth--;
      }
      answer=max(answer,depth);
    }
    return answer;
  }
};