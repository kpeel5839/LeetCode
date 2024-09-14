class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        int answer=1;
        int cnt=1;
        int pre=-1;
        int maxElement=*max_element(nums.begin(),nums.end());
        for(int i=1;i<nums.size();i++){
            if(nums[i]!=nums[i-1]){
                pre=-1;
                if(maxElement==nums[i-1]){
                    answer=max(cnt,answer);
                }
                cnt=0;
            }
            cnt++;
        }
        if(maxElement==nums.back()){
            answer=max(answer,cnt);
        }
        return answer;
    }
};