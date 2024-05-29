class Solution {
public:
    typedef long long ll;
    typedef vector<int>vi;
    typedef vector<vi>vii;
    typedef vector<ll>vl;
    typedef vector<vl>vll;
    ll maximumValueSum(vector<int>& nums, int k, vector<vector<int>>& edges) {
        vl diff;
        ll answer=0;
        for(int i=0;i<nums.size();i++){
            answer+=nums[i];
            diff.push_back((nums[i]^k)-nums[i]);
        }
        sort(diff.begin(),diff.end(),[](ll o1,ll o2){
            return o1>o2;
        });
        for(int i=0;i+1<diff.size();i+=2){
            if(diff[i]+diff[i+1]<0){
                break;
            }
            answer+=diff[i]+diff[i+1];
        }
        return answer;
    }
};