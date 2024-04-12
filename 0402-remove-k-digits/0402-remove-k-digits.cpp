class Solution {
public:
  struct comp{
    bool operator()(vector<int>&o1,vector<int>&o2){
      if(o1[0]==o2[0]){
        return o1[1]>o2[1];
      }
      return o1[0]>o2[0];
    }
  };
  string removeKdigits(string num, int k) {
    if(num.size()==k){
      return "0";
    }
    int lastIdx=-1;
    priority_queue<vector<int>,vector<vector<int>>,comp>q;
    string answer;
    int i;
    for(i=0;i<k+1;i++){
      q.push({num.at(i)-'0',i});
    }
    while(true){
      while(lastIdx>q.top()[1]){
        q.pop();
      }
      vector<int>value=q.top();
      lastIdx=value[1];
      answer.push_back(value[0]+'0');q.pop();
      if(answer.size()==num.size()-k){
        break;
      }
      q.push({num.at(i)-'0',i++});
    }
    string realAnswer;
    bool isNotZero=true;
    for(int i=0;i<answer.size();i++){
      if(answer[i]!='0'){
        isNotZero=false;
      }
      if(!isNotZero){
        realAnswer.push_back(answer[i]);
      }
    }
    return realAnswer;
  }
};