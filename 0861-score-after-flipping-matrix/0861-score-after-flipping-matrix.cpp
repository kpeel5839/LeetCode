class Solution {
public:
    int matrixScore(vector<vector<int>>& grid) {
        int h=grid.size();
        int w=grid[0].size();
        int maxValue=(1<<w)-1;
        vector<int>bitValue(h);
        for(int i=0;i<h;i++){
            int v=0;
            for(int j=w-1;0<=j;j--){
                if(grid[i][j]==1){
                    v+=1<<(w-j-1);
                }
            }
            bitValue[i]=max(v,maxValue-v);
        }
        int answer=0;
        for(int i=w-1;0<=i;i--){
            int cnt=0;
            for(int j=0;j<h;j++){
                if((bitValue[j]&(1<<(w-i-1)))!=0){
                    cnt++;
                }
            }
            cnt=max(cnt,h-cnt);
            answer+=(1<<(w-i-1))*cnt;
        }
        return answer;
    }
};