class Solution {
public:
    typedef vector<int>vi;
    typedef vector<vi>vii;
    int countSquares(vector<vector<int>>& matrix) {
        int h=matrix.size();
        int w=matrix[0].size();
        vii dp(h+1,vi(w+1,0));
        int answer=0;
        for(int i=1;i<=h;i++){
            for(int j=1;j<=w;j++){
                if(matrix[i-1][j-1]!=1){
                    continue;
                }
                int mi=min(dp[i-1][j-1],min(dp[i-1][j],dp[i][j-1]));
                dp[i][j]=1+mi;
                answer+=1+mi;
            }
        }
        return answer;
    }
};