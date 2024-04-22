class Solution {
public:
  typedef vector<int>vi;
  unordered_set<string>se;
  string target;
  vi dp;
  char up(char c){
    int n=c-'0';
    n++;
    n%=10;
    return (char)(n+'0');
  }
  char down(char c){
    int n=c-'0';
    n--;
    if(n<0){
      n+=10;
    }
    return (char)(n+'0');
  }
  void bfs(string s){
    if(se.find("0000")!=se.end()){
      return;
    }
    queue<vector<string>>q;
    dp[stoi(s)]=0;
    q.push({s,"0"});
    while(q.size()!=0){
      vector<string> p=q.front();q.pop();
      if(target==p[0]){
        return;
      }
      int moveCnt=stoi(p[1]);
      for(int i=0;i<4;i++){
        string ss=string(p[0]);
        ss[i]=up(ss[i]);
        if(se.find(ss)==se.end()&&dp[stoi(ss)]==-1){
          q.push({ss,to_string(moveCnt+1)});
          dp[stoi(ss)]=moveCnt+1;
        }
        ss[i]=down(ss[i]);
        ss[i]=down(ss[i]);
        if(se.find(ss)==se.end()&&dp[stoi(ss)]==-1){
          q.push({ss,to_string(moveCnt+1)});
          dp[stoi(ss)]=moveCnt+1;
        }
      }
    }
  }
  int openLock(vector<string>& deadends, string target) {
    for(auto&v:deadends){
      se.insert(v);
    }
    if(se.find("0000")!=se.end()){
      return -1;
    }
    this->target=target;
    dp=vi(10000,-1);
    bfs("0000");
    return dp[stoi(target)];
  }
};