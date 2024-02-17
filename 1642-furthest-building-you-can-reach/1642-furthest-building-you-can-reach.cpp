class Solution {
public:
  typedef vector<int> vi;
  struct comp{
    bool operator()(int& o1,int& o2){
      return o1<o2;
    }
  };
  int furthestBuilding(vector<int>& heights, int bricks, int ladders) {
    int n=heights.size();
    priority_queue<int,vi,comp>q;
    for(int i=1;i<n;i++){
      if(heights[i-1]>=heights[i]){
        continue;
      }
      int diff=heights[i]-heights[i-1];
      if(bricks<diff){
        if(ladders==0){
          return i-1;
        }
        if(q.size()!=0){
          int v=q.top();
          if(diff<v){
            q.pop();
            bricks+=v;
            q.push(diff);
            bricks-=diff;
          }
        }
        ladders--;
      }else{
        q.push(diff);
        bricks-=diff;
      }
    }
    return n-1;
  }
};