class Solution {
public:
  string makeGood(string s) {
    deque<char>dq;
    int n=s.size();
    int diff=abs('a'-'A');
    cout<<diff<<"\n";
    for(int i=0;i<n;i++){
      if(dq.size()!=0&&abs(dq.back()-s.at(i))==diff){
        dq.pop_back();
        continue;
      }
      dq.push_back(s.at(i));
    }
    string answer;
    while(dq.size()!=0){
      answer.push_back(dq.front());
      dq.pop_front();
    }
    return answer;
  }
};