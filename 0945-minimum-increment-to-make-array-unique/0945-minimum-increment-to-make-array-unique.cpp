class Solution {
public:
    int minIncrementForUnique(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        int n=nums.size();
        int number=nums[0];
        int answer=0;
        for(int i=0;i<n;i++){
            number=max(number,nums[i]);
            answer+=number-nums[i];
            number++;
        }
        return answer;
    }
};