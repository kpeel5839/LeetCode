class Solution {
public:
    typedef vector<int>vi;
    int maxSatisfied(vector<int>& customers, vector<int>& grumpy, int minutes) {
        int n=customers.size();
        int answer=0;
        vi prefix(n+1,0);
        for(int i=0;i<n;i++){
            if(grumpy[i]==1){
                prefix[i+1]+=customers[i];
            }else{
                answer+=customers[i];
            }
            prefix[i+1]=prefix[i+1]+prefix[i];
        }
        int ma=0;
        for(int i=minutes;i<=n;i++){
            ma=max(ma,prefix[i]-prefix[i-minutes]);
        }
        return answer+ma;
    }
};