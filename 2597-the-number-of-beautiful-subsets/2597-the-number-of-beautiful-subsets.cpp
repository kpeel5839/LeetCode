class Solution {
public:
    int k;
    int answer=0;
    unordered_map<int,int>m;
    void getSubset(vector<int>&nums,int idx){
        if(idx!=-1){
            answer++;
        }
        for(int i=idx+1;i<nums.size();i++){
            if(m[nums[i]+k]||m[nums[i]-k]){
                continue;
            }
            m[nums[i]]++;
            getSubset(nums,i);
            m[nums[i]]--;
        }
    }
    int beautifulSubsets(vector<int>& nums, int k) {
        this->k=k;
        sort(nums.begin(),nums.end());
        getSubset(nums,-1);
        return answer;
    }
};