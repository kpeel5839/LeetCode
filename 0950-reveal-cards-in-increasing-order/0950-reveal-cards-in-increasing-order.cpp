class Solution {
public:
  vector<int> deckRevealedIncreasing(vector<int>& deck) {
    int n=deck.size();
    int cnt=0;
    int idx=1;
    int push_idx=0;
    vector<bool>visited(n,false);
    sort(deck.begin(),deck.end());
    vector<int>answer(n,0);
    visited[0]=true;
    answer[0]=deck[0];
    while(idx!=n){
      push_idx=(push_idx+1)%n;
      if(!visited[push_idx]){
        cnt++;
      }
      if(cnt==2){
        cnt=0;
        visited[push_idx]=true;
        answer[push_idx]=deck[idx++];
      }
    }
    return answer;
  }
};