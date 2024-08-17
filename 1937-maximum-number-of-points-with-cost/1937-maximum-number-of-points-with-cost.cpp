class Solution {
public:
    typedef long long ll;
    typedef vector<ll>vl;
    typedef vector<vl>vll;
    long long maxPoints(vector<vector<int>>& points) {
        int h=points.size();
        int w=points[0].size();
        vll dp(h,vl(w));
        ll answer=0;
        for(int i=0;i<w;i++){
            dp[0][i]=points[0][i];
            if(1==h){
                answer=max(answer,dp[0][i]);
            }
        }
        for(int i=1;i<h;i++){
            queue<vl>q;
            for(int j=0;j<w;j++){
                q.push({i,j,dp[i-1][j]});
                dp[i][j]=points[i][j]+dp[i-1][j];
            }
            while(!q.empty()){
                vl p=q.front();q.pop();
                if(p[1]!=0&&dp[i][p[1]-1]-points[i][p[1]-1]<p[2]-1){
                    dp[i][p[1]-1]=p[2]-1+points[i][p[1]-1];
                    q.push({i,p[1]-1,p[2]-1});
                }
                if(p[1]!=w-1&&dp[i][p[1]+1]-points[i][p[1]+1]<p[2]-1){
                    dp[i][p[1]+1]=p[2]-1+points[i][p[1]+1];
                    q.push({i,p[1]+1,p[2]-1});
                }
                if(i==h-1){
                    answer=max(answer,dp[i][p[1]]);
                }
            }
        }
        return answer;
    }
};