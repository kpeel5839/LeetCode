class Solution {
public:
    int subarraysDivByK(vector<int>& nums, int k) {
        map<int,int>m;
        int sum=1e8;
        m[sum%k]=1;
        int answer=0;
        for(int i=0;i<nums.size();i++){
            sum+=nums[i];
            answer+=m[sum%k]++;
        }
        return answer;
    }
};