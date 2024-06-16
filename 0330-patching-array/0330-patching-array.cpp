class Solution {
public:
    typedef long long ll;
    int minPatches(vector<int>& nums, int n) {
        ll sum=0;
        int size=nums.size();
        sort(nums.begin(),nums.end());
        int answer=0;
        int pointer=0;
        while(sum<n){
            if(pointer!=size&&nums[pointer]<=sum+1){
                sum+=nums[pointer++];
                continue;
            }
            answer++;
            sum+=sum+1;
        }
        return answer;
    }
};