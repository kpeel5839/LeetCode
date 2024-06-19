class Solution {
public:
    typedef vector<int>vi;
    bool helper(vi bd,int m,int k,int max){
        int cnt=0;
        int numberCnt=0;
        for(int i=0;i<bd.size();i++){
            if(max<bd[i]){
                numberCnt=0;
                continue;
            }
            numberCnt++;
            if(k<=numberCnt){
                numberCnt=0;
                cnt++;
            }
        }
        return m<=cnt;
    }
    int minDays(vector<int>& bloomDay, int m, int k) {
        int l=1;
        int r=1e9;
        int answer=-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(helper(bloomDay,m,k,mid)){
                r=mid-1;
                answer=mid;
            }else{
                l=mid+1;
            }
        }
        return answer;
    }
};