class Solution {
public:
    typedef long long ll;
    long long largestPerimeter(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        ll answer=-1;
        ll sum=nums[0]+nums[1];
        for(int i=2;i<nums.size();i++){
            if(sum>nums[i]){
                answer=sum+nums[i];
            }
            sum+=nums[i];
        }
        return answer;
    }
};