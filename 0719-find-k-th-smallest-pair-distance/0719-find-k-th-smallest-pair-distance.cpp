class Solution {
public:
    typedef vector<int>vi;
    typedef vector<vi>vii;
    int smallestDistancePair(vector<int>& nums, int k) {
        vector<int>cnt(1e6+1);
        sort(nums.begin(),nums.end());
        for(int i=0;i<nums.size();i++){
            for(int j=i+1;j<nums.size();j++){
                cnt[nums[j]-nums[i]]++;
            }
        }
        int realCnt=0;
        for(int i=0;i<=1e6;i++){
            realCnt+=cnt[i];
            if(k<=realCnt){
                return i;
            }
        }
        return -1;
    }
};