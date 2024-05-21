class Solution {
public:
    vector<vector<int>>answer;
    void dfs(vector<int>&nums,int idx,vector<int>a){
        answer.push_back(a);
        for(int i=idx+1;i<nums.size();i++){
            a.push_back({nums[i]});
            dfs(nums,i,a);
            a.pop_back();
        }
    }
    vector<vector<int>> subsets(vector<int>& nums) {
        dfs(nums,-1,{});
        return answer;
    }
};