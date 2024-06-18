class Solution {
public:
    typedef vector<int>vi;
    typedef vector<vi>vii;
    int maxProfitAssignment(vector<int>& difficulty, vector<int>& profit, vector<int>& worker) {
        int m=difficulty.size();
        vii v(m,vi(2));
        for(int i=0;i<m;i++){
            v[i]={difficulty[i],profit[i]};
        }
        sort(v.begin(),v.end(),[](vi o1,vi o2){
            if(o1[0]==o2[0]){
                return o1[1]<o2[1];
            }
            return o1[0]<o2[0];
        });
        int ma=0;
        for(int i=0;i<m;i++){
            ma=max(ma,v[i][1]);
            v[i][1]=ma;
        }
        int ans=0;
        for(int i=0;i<worker.size();i++){
            int l=0;
            int r=m-1;
            int answer=-1;
            while(l<=r){
                int m=(l+r)/2;
                if(v[m][0]<=worker[i]){
                    l=m+1;
                    answer=m;
                }else{
                    r=m-1;
                }
            }
            if(answer==-1){
                continue;
            }
            ans+=v[answer][1];
        }
        return ans;
    }
};