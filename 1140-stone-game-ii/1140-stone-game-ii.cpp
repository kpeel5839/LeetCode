class Solution {
public:
    typedef vector<int>vi;
    typedef vector<vi>vii;
    typedef vector<vii>viii;
    viii dp;
    vi p;
    int n;
    vi sum;
    int dfs(int turn, int idx,int m){
        if(idx==n){
            return 0;
        }
        if(dp[turn][idx][m]!=1e9){
            return dp[turn][idx][m];
        }
        for(int i=1;i<=2*m;i++){
            if(n<idx+i){
                break;
            }
            int s=sum[idx+i-1]-((idx==0)?0:sum[idx-1]);
            if(turn==0){
                if(dp[turn][idx][m]==1e9){
                    dp[turn][idx][m]=dfs(1,idx+i,max(i,m))+s;
                }else{
                    dp[turn][idx][m]=max(dp[turn][idx][m],dfs(1,idx+i,max(i,m))+s);
                }
            }else{
                dp[turn][idx][m]=min(dp[turn][idx][m],dfs(0,idx+i,max(i,m)));
            }
        }
        return dp[turn][idx][m];
    }
    int stoneGameII(vector<int>& piles) {
        p=piles;
        n=piles.size();
        dp=viii(2,vii(n+1,vi(n+1,1e9)));
        sum=vi(n,p[0]);
        for(int i=1;i<n;i++){
            sum[i]=sum[i-1]+p[i];
        }
        int result= dfs(0,0,1);
        return result;
    }
};