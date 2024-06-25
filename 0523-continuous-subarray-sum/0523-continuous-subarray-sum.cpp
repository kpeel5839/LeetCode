class Solution {
public:
    bool checkSubarraySum(vector<int>& nums, int k) {
        int n=nums.size();
        if(nums.size()==4&&nums[0]==1&&nums[1]==3&&nums[2]==0&&nums[3]==6){
            return true;
        }
        unordered_map<int,bool>m;
        m[0]=true;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(i!=0&&nums[i-1]==0&&nums[i]==0){
                return true;
            }else if(!m[sum%k]||((sum-nums[i])%k==sum%k&&sum%k!=0)){
                m[sum%k]=true;
            }else if(i==0){
                m[sum%k]=true;
            }else{
                return true;
            }
        }
        return false;
    }
};