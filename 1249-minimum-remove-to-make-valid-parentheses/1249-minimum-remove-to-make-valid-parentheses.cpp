class Solution {
public:
  string minRemoveToMakeValid(string s) {
    set<int>idx;
    stack<int>st;
    for(int i=0;i<s.size();i++){
      if(s.at(i)=='('){
        st.push(i);
      }else if(s.at(i)==')'){
        if(st.size()!=0){
          st.pop();
          continue;
        }
        idx.insert(i);
      }
    }
    while(st.size()!=0){
      idx.insert(st.top());st.pop();
    }
    string answer;
    for(int i=0;i<s.size();i++){
      if(idx.find(i)!=idx.end()){
        continue;
      }
      answer.push_back(s.at(i));
    }
    return answer;
  }
};