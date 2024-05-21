class Solution {
public:
    int answer=0;
    vector<int>nums;
    void dfs(int idx,int value){
        for(int i=idx+1;i<nums.size();i++){
            answer+=(value^nums[i]);
            dfs(i,value^nums[i]);
        }
    }
    int subsetXORSum(vector<int>& nums) {
        this->nums=nums;
        dfs(-1,0);
        return answer;
    }
};