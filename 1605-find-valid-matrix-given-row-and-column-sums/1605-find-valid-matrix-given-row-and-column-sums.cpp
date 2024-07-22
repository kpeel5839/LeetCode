class Solution {
public:
    typedef vector<int>vi;
    typedef vector<vi>vii;
    typedef vector<vii>viii;
    vector<vector<int>> restoreMatrix(vector<int>& rowSum, vector<int>& colSum) {
        int h=rowSum.size();
        int w=colSum.size();
        vii result(h,vi(w,0));
        if(h>=w){
            vi realRowSum(h,0);
            for(int i=0;i<w;i++){
                result[i][i]=colSum[i];
                realRowSum[i]+=result[i][i];
            }
            for(int i=0;i<h;i++){
                if(realRowSum[i]<=rowSum[i]){
                    continue;
                }
                for(int j=0;j<h;j++){
                    if(i==j||rowSum[j]<=realRowSum[j]){
                        continue;
                    }
                    int diff=min(realRowSum[i]-rowSum[i],rowSum[j]-realRowSum[j]);
                    realRowSum[i]-=diff;
                    realRowSum[j]+=diff;
                    result[j][i]+=diff;
                    result[i][i]-=diff;
                    if(realRowSum[i]==rowSum[i]){
                        break;
                    }
                }
            }
        }else{
            vi realColSum(w,0);
            for(int i=0;i<h;i++){
                result[i][i]=rowSum[i];
                realColSum[i]+=result[i][i];
            }
            for(int i=0;i<w;i++){
                if(realColSum[i]<=colSum[i]){
                    continue;
                }
                for(int j=0;j<w;j++){
                    if(i==j||colSum[j]<=realColSum[j]){
                        continue;
                    }
                    int diff=min(realColSum[i]-colSum[i],colSum[j]-realColSum[j]);
                    realColSum[i]-=diff;
                    realColSum[j]+=diff;
                    result[i][j]+=diff;
                    result[i][i]-=diff;
                    if(realColSum[i]==colSum[i]){
                        break;
                    }
                }
            }
        }
        return result;
    }
};