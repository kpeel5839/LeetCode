class Solution {
public:
  bool isIsomorphic(string s, string t) {
    unordered_set<char>ss;
    unordered_map<char,char>m;
    int n=s.size();
    for(int i=0;i<n;i++){
      if(m.find(s.at(i))==m.end()&&ss.find(t.at(i))!=ss.end()){
        return false;
      }
      if(m.find(s.at(i))==m.end()){
        m[s.at(i)]=t.at(i);
        ss.insert(t.at(i));
        continue;
      }
      if(m[s.at(i)]!=t.at(i)){
        return false;
      }
    }
    return true;
  }
};