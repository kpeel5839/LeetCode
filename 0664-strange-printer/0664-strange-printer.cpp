class Solution {
public:
    typedef vector<int>vi;
    typedef vector<vi>vii;
    int strangePrinter(string s) {
        int n=s.size();
        vii dp(n,vi(n,1e9));
        for(int i=0;i<n;i++){
            dp[i][i]=1;
        }
        for(int i=2;i<=n;i++){
            for(int j=0;j+i-1<n;j++){
                if(s[j]==s[j+i-1]){
                    dp[j][j+i-1]=min(dp[j][j+i-1],dp[j+1][j+i-1]);
                }
                for(int c=j;c<j+i-1;c++){
                    dp[j][j+i-1]=min(dp[j][j+i-1],dp[j][c]+dp[c+1][j+i-1]);
                }
            }
        }
        return dp[0][n-1];
    }
};