class Solution {
public:
  bool checkValidString(string s) {
    stack<int>st;
    deque<int>star;
    for(int i=0;i<s.size();i++){
      if(s.at(i)=='('){
        st.push(i);
      }else if(s.at(i)==')'){
        if(st.size()==0){
          if(star.size()==0){
            return false; 
          }
          star.pop_front();
        }else{
          st.pop();
        }
      }else{
        star.push_back(i);
      }
    }
    while(st.size()!=0){
      if(star.size()==0||st.top()>star.back()){
        return false;
      }
      st.pop();
      star.pop_back();
    }
    return true;
  }
};