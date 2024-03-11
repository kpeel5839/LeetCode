class Solution {
public:
  string customSortString(string order, string s) {
    vector<int>cnt(26);
    for(int i=0;i<s.length();i++){
      cnt[s.at(i)-'a']++;
    }
    string answer;
    for(int i=0;i<order.length();i++){
      int index=order.at(i)-'a';
      if(cnt[index]!=0){
        for(int j=0;j<cnt[index];j++){
          answer.push_back(index+'a');
        }
        cnt[index]=0;
      }
    }
    for(int i=0;i<cnt.size();i++){
      if(cnt[i]!=0){
        for(int j=0;j<cnt[i];j++){
          answer.push_back(i+'a');
        }
      }
    }
    return answer;
  }
};