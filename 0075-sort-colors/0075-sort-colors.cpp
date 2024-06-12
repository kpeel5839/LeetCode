class Solution {
public:
    void sortColors(vector<int>& nums) {
        vector<int>cnt(3,0);
        for(int i=0;i<nums.size();i++){
            cnt[nums[i]]++;
        }
        int pointer=0;
        for(int i=0;i<nums.size();i++){
            while(pointer!=3&&cnt[pointer]==0){
                pointer++;
            }
            nums[i]=pointer;
            cnt[pointer]--;
        }
    }
};