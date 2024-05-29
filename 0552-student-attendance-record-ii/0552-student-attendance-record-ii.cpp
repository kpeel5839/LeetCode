class Solution {
public:
    typedef vector<int>vi;
    typedef vector<vi>vii;
    typedef vector<vii>viii;
    int MOD=1e9+7;
    viii dp;
    int n;
    int dfs(int i,int j,int c){
        if(c==n){
            return 1;
        }
        if(dp[i][j][c]!=-1){
            return dp[i][j][c];
        }
        dp[i][j][c]=0;
        if(i==0){
            dp[i][j][c]=(dp[i][j][c]+dfs(i+1,0,c+1))%MOD;
        }
        if(j!=2){
            dp[i][j][c]=(dp[i][j][c]+dfs(i,j+1,c+1))%MOD;
        }
        dp[i][j][c]=(dp[i][j][c]+dfs(i,0,c+1))%MOD;
        return dp[i][j][c];
    }
    int checkRecord(int n) {
        this->n=n;
        dp.resize(2,vii(3,vi(n,-1)));
        return dfs(0,0,0);
    }
};