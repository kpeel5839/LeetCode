class Solution {
public:
    typedef vector<int>vi;
    typedef vector<vi>vii;
    vii books;
    int sl;
    vii dp;
    int dfs(int idx,int pre,int maxHeight){
        int n=books.size();
        if(idx==n){
            return maxHeight;
        }
        if(dp[pre][idx]!=1e9){
            return dp[pre][idx];
        }
        if(books[idx][0]+pre<=sl){
            dp[pre][idx]=min(dp[pre][idx],dfs(idx+1,books[idx][0]+pre,max(books[idx][1],maxHeight)));
        }
        dp[pre][idx]=min(dp[pre][idx],dfs(idx+1,books[idx][0],books[idx][1])+maxHeight);
        return dp[pre][idx];
    }
    int minHeightShelves(vector<vector<int>>& books, int shelfWidth) {
        this->sl=shelfWidth;
        this->books=books;
        dp=vii(sl+1,vi(books.size(),1e9));
        return dfs(0,0,0);
    }
};