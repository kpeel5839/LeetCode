class Solution {
public:
    bool checkSubarraySum(vector<int>& nums, int k) {
        int n=nums.size();
        unordered_map<int,int>m;
        m[0]=-1;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(m.find(sum%k)!=m.end()){
                m[sum%k]=min(m[sum%k],i);
            }else{
                m[sum%k]=i;
            }
            if(i-m[sum%k]>1){
                return true;
            }
        }
        return false;
    }
};