class Solution {
public:
  int trap(vector<int>& height) {
    int n=height.size();
    stack<vector<int>>st;
    vector<int> lower(n,0);
    int answer=0;
    for(int i=0;i<n;i++){
      if(st.size()==0){
        st.push({height[i],i});
        continue;
      }
      while(st.size()!=0&&st.top()[0]<=height[i]){
        int previousHeight=lower[st.top()[1]];
        int diff=st.top()[0]-previousHeight;
        answer+=diff*(i-st.top()[1]-1);
        st.pop();
      }
      if(st.size()!=0&&height[i]<st.top()[0]){
        int previousHeight=lower[st.top()[1]];
        int diff=((st.top()[0]-previousHeight)-(st.top()[0]-height[i]));
        answer+=diff*(i-st.top()[1]-1);
        lower[st.top()[1]]=max(previousHeight,height[i]);
      }
      st.push({height[i],i});
    }
    return answer;
  }
};