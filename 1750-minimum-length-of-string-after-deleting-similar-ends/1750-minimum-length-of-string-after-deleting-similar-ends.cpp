class Solution {
public:
  int minimumLength(string s) {
    char pre=s.at(0);
    int count=0;
    vector<vector<int>>compression;
    for(int i=0;i<s.length();i++){
      if(pre!=s.at(i)){
        compression.push_back({pre-'a',count});
        pre=s.at(i);
        count=1;
        continue;
      }
      count++;
    }
    compression.push_back({pre-'a',count});
    int l=0;
    int r=compression.size()-1;
    int cutCount=0;
    while(l<r){
      if(compression[l][0]!=compression[r][0]){
        break;
      }
      cutCount+=compression[l++][1]+compression[r--][1];
    }
    if(l==r&&compression[l][1]!=1){
      return 0;
    }
    return s.length()-cutCount;
  }
};