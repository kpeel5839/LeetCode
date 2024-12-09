class Solution {
public:
    typedef long long ll;
    typedef vector<ll>vl;
    typedef vector<int>vi;
    typedef vector<vi>vii;
    typedef vector<vl>vll;
    int maxTwoEvents(vector<vector<int>>& events) {
        int n=events.size();
        vl sum(n,0);
        ll ma=0;
        sort(events.begin(),events.end(),[](vi&o1,vi&o2){
            if(o1[0]==o2[0]){
                return o1[1]<o2[1];
            }
            return o1[0]<o2[0];
        });
        vl maxValue(n,0);
        for(int i=n-1;0<=i;i--){
            ma=max((ll)events[i][2],ma);
            maxValue[i]=ma;
        }
        ll answer=0;
        for(int i=0;i<n;i++){
            answer=max(answer,(ll)events[i][2]);
            int l=i+1;
            int r=n-1;
            int idx=-1;
            while(l<=r){
                int m=(l+r)/2;
                if(events[m][0]<=events[i][1]){
                    l=m+1;
                }else{
                    idx=m;
                    r=m-1;
                }
            }
            if(idx!=-1){
                answer=max(answer,events[i][2]+maxValue[idx]);
            }
        }
        return answer;
    }
};