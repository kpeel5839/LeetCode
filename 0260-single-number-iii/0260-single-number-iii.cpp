class Solution {
public:
    typedef long long ll;
    vector<int> singleNumber(vector<int>& nums) {
        int n=nums.size();
        ll res=0;
        for(int i=0;i<n;i++){
            res^=nums[i];
        }
        ll lowestBit=res&-res;
        vector<ll>result(2);
        for(int i=0;i<n;i++){
            if((lowestBit&nums[i])==0){
                result[0]^=nums[i];
            }else{
                result[1]^=nums[i];
            }
        }
        return {(int)result[0],(int)result[1]};
    }
};