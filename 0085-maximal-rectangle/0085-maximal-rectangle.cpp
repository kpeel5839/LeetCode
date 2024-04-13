class Solution {
public:
  int maximalRectangle(vector<vector<char>>& matrix) {
    int h=matrix.size();
    int w=matrix[0].size();
    vector<vector<int>>height(h+1,vector<int>(w+1,0));
    int answer=0;
    for(int i=1;i<=h;i++){
      for(int j=1;j<=w;j++){
        if(matrix[i-1][j-1]=='1'){
          height[i][j]=height[i-1][j]+1;
        }
        int minHeight=1e9;
        for(int c=1;0<j-c+1;c++){
          if(matrix[i-1][j-c]!='1'){
            break;
          }
          minHeight=min(minHeight,height[i][j-c+1]);
          answer=max(answer,c*minHeight);
        }
      }
    }
    return answer;
  }
};