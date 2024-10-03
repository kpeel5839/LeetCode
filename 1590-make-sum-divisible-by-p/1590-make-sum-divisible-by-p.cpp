class Solution {
public:
    typedef vector<int>vi;
    typedef vector<vi>vii;
    typedef long long ll;

    int minSubarray(vector<int>& nums, int p) {
        ll totalSum=0;
        for(auto&v:nums){
            totalSum+=v;
        }
        map<ll,ll>m;
        ll x=totalSum%p;
        if(x==0){
            return 0;
        }
        ll answer=nums.size();
        ll sum=0;
        m[0]=-1;
        for(int i=0;i<nums.size();i++){
            sum=(sum+nums[i])%p;
            int f=((sum+p)-x)%p;
            
            if(m.find(f)!=m.end()){
                answer=min(i-m[f],answer);
            }
            m[sum]=i;
        }
        return answer==nums.size()?-1:answer;
    }
};