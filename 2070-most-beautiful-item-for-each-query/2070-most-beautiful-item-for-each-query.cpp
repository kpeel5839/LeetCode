class Solution {
public:
    typedef vector<int>vi;
    typedef vector<vi>vii;
    vector<int> maximumBeauty(vector<vector<int>>& items, vector<int>& queries) {
        sort(items.begin(),items.end(),[](vi&o1,vi&o2){
            if(o1[0]==o2[0]){
                return o1[1]>o2[1];
            }
            return o1[0]<o2[0];
        });
        int n=items.size();
        vi v(n,0);
        int ma=0;
        for(int i=0;i<n;i++){
            ma=max(ma,items[i][1]);
            v[i]=ma;
        }
        vi answer;
        for(int i=0;i<queries.size();i++){
            int l=0;
            int r=n-1;
            int ans=-1;
            while(l<=r){
                int m=(l+r)/2;
                if(queries[i]>=items[m][0]){
                    ans=m;
                    l=m+1;
                }else{
                    r=m-1;
                }
            }
            answer.push_back(ans==-1?0:v[ans]);
        }
        return answer;
    }
};