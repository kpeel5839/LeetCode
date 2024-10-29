class Solution {
public:
    typedef vector<int>vi;
    typedef vector<vi>vii;
    int maxMoves(vector<vector<int>>& grid) {
        int h=grid.size();
        int w=grid.size();
        vii dp=vii(h+2,vi(w+1,0));
        vii g=vii(h+2,vi(w+1,0));
        for(int i=0;i<grid.size();i++){
            for(int j=0;j<grid[i].size();j++){
                g[i+1][j+1]=grid[i][j];
            }
        }
        for(int i=1;i<=h;i++){
            dp[i][1]=1;
        }
        int answer=1;
        for(int i=2;i<=w;i++){
            for(int j=1;j<=h;j++){
                int ma=0;
                for(int move=-1;move<=1;move++){
                    if(g[j+move][i-1]>=g[j][i]){
                        continue;
                    }
                    ma=max(ma,dp[j+move][i-1]);
                }
                if(ma==0){
                    continue;
                }
                dp[j][i]=max(dp[j][i],ma+1);
                answer=max(answer,dp[j][i]);
            }
        }
        return answer-1;
    }
};