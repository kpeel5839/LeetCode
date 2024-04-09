class Solution {
public:
  int timeRequiredToBuy(vector<int>& tickets, int k) {
    int n=tickets.size();
    int answer=0;
    for(int i=0;i<n;i++){
      if(i<=k){
        answer+=min(tickets[k],tickets[i]);
      }else{
        answer+=min(tickets[k]-1,tickets[i]);
      }
    }
    return answer;
  }
};