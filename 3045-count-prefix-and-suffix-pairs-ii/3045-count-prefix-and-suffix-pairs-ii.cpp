class Solution {
public:
  typedef long long ll;
  typedef vector<string> vs;
  typedef vector<ll> vl;
  typedef vector<vl> vll;
  typedef vector<int> vi;
  
  vs w;
  vi pi;

  void getPi(string p){
    int j=0;
    for(int i=1;i<p.length();i++){
      while(j!=0&&p.at(i)!=p.at(j)){
        j=pi[j-1];
      }
      if(p.at(i)==p.at(j)){
        pi[i]=++j;
      }
    }
  }
  
  ll countPrefixSuffixPairs(vector<string>& words) {
    int n=words.size();
    w=words;
    vl dp(words.size(),0);
    map<string,int>m;
    ll answer=0;
    for(int i=0;i<n;i++){
      set<int> correct;
      pi=vi(w[i].length(),0);
      getPi(w[i]);
      int index=w[i].length()-1;
      while(true){
        correct.insert(index);
        index=pi[index]-1;
        if(index<0){
          break;
        }
      }
      string s;
      for(int j=0;j<w[i].length();j++){
        s.push_back(w[i].at(j));
        if(correct.find(j)!=correct.end()){
          if(m.find(s)!=m.end()){
            answer+=dp[m[s]]+1;
          }
        }
      }
      if(m.find(w[i])!=m.end()){
        dp[i]=dp[m[w[i]]]+1;
      }
      m[w[i]]=i;
    }
    return answer;
  }
};